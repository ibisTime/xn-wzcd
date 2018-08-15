package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ITotalAdvanceFundAO;
import com.cdkj.loan.bo.IAdvanceFundBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepointDetailBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ITotalAdvanceFundBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.domain.TotalAdvanceFund;
import com.cdkj.loan.dto.req.XN632174Req;
import com.cdkj.loan.dto.req.XN632176Req;
import com.cdkj.loan.dto.req.XN632233Req;
import com.cdkj.loan.enums.EAdvanceFundNode;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBudgetFrozenStatus;
import com.cdkj.loan.enums.EFbhStatus;
import com.cdkj.loan.enums.ERepointDetailStatus;
import com.cdkj.loan.enums.EReqBudgetNode;
import com.cdkj.loan.enums.ESettleWay;
import com.cdkj.loan.enums.ETotalAdvanceFundStatus;
import com.cdkj.loan.enums.ETotalAdvanceFundType;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月17日 上午11:24:06 
 * @history:
 */
@Service
public class TotalAdvanceFundAOImpl implements ITotalAdvanceFundAO {

    @Autowired
    private ITotalAdvanceFundBO totalAdvanceFundBO;

    @Autowired
    private IAdvanceFundBO advanceFundBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IRepointDetailBO repointDetailBO;

    @Autowired
    private IReqBudgetBO reqBudgetBO;

    @Autowired
    private ICarDealerBO carDealerBO;

    @Override
    @Transactional
    public String addTotalAdvanceFund(XN632174Req req) {
        List<String> codeList = req.getCodeList();
        for (String code : codeList) {
            AdvanceFund advanceFund = advanceFundBO.getAdvanceFund(code);
            if (!EAdvanceFundNode.BRANCH_MAKE_BILL.getCode().equals(
                advanceFund.getCurNodeCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是分公司制单节点，不能操作！");
            }
        }
        Long totalAdvanceFund = 0L;// 待垫资金额（制单时通过审核的所有垫资单相加总金额）
        for (String code : codeList) {
            AdvanceFund advanceFund = advanceFundBO.getAdvanceFund(code);
            String preNodeCode = advanceFund.getCurNodeCode();// 当前节点
            advanceFund.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preNodeCode).getNextNode());
            // 补全分公司制单日志
            sysBizLogBO.refreshPreSYSBizLog(EBizLogType.ADVANCE_FUND_BRANCH,
                advanceFund.getCode(), preNodeCode, req.getMakeBillNote(),
                req.getOperator());
            advanceFundBO.branchMakeBill(advanceFund);
            totalAdvanceFund += getLong(advanceFund.getUseAmount());
        }
        TotalAdvanceFund data = new TotalAdvanceFund();
        data.setType(ETotalAdvanceFundType.FIRST.getCode());
        data.setCompanyCode(req.getCompanyCode());
        data.setTotalAdvanceFund(totalAdvanceFund);// 待垫资金额（制单时通过审核的所有垫资单相加总金额）
        ReqBudget reqBudget = reqBudgetBO.getTodayReqBudget(req
            .getCompanyCode());
        if (reqBudget == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "今天还未给该业务公司打预算款！");
        }
        Long reqBudgetAmount = getLong(reqBudget.getPayAmount());
        Long payAmount = totalAdvanceFund - reqBudgetAmount;
        if (payAmount < 0) {
            payAmount = 0L;
            // 生成待收回预算款
            // reqBudget.setCollectionAmount(reqBudgetAmount -
            // totalAdvanceFund); //在收回预算款时录入实收金额 界面打款金额-垫资总额展示应收金额
            reqBudget.setCurNodeCode(EReqBudgetNode.COLLECTION.getCode());
            // 生成日志
            sysBizLogBO.saveSYSBizLog(reqBudget.getCode(),
                EBizLogType.REQ_BUDGET, reqBudget.getCode(),
                EReqBudgetNode.COLLECTION.getCode());
        }
        reqBudget.setDzAmount(totalAdvanceFund);
        reqBudgetBO.refreshReqBudget(reqBudget);
        data.setPayAmount(payAmount);// 付款金额（垫资总金额-请款预算单金额=本次垫资金额）
        data.setMakeBillNote(req.getMakeBillNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setStatus(ETotalAdvanceFundStatus.TODO.getCode());// 0待打款给分公司
        String totalAdvanceCode = totalAdvanceFundBO.saveTotalAdvanceFund(data);
        // 生成 下一步确认打款给分公司日志
        sysBizLogBO.saveSYSBizLog(data.getCode(),
            EBizLogType.ADVANCE_FUND_BRANCH, data.getCode(),
            EAdvanceFundNode.BRANCH_COMPANY.getCode());
        return totalAdvanceCode;
    }

    @Override
    @Transactional
    public void confirmPayBranchCompany(XN632176Req req) {
        List<String> codeList = req.getCodeList();
        for (String code : codeList) {
            AdvanceFund advanceFund = advanceFundBO.getAdvanceFund(code);
            if (!EAdvanceFundNode.BRANCH_COMPANY.getCode().equals(
                advanceFund.getCurNodeCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是垫资流程确认打款给分公司节点，不能操作！");
            }
        }
        TotalAdvanceFund data = totalAdvanceFundBO
            .getTotalAdvanceFundByCompanyCodeAndStatus(req.getCompanyCode(),
                ETotalAdvanceFundStatus.TODO.getCode());

        data.setPayDatetime(DateUtil.strToDate(req.getPayDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));// 界面的垫资日期 垫资表的付款时间（付款给分公司的时间）
        data.setPayBankcardCode(req.getPayBankcardCode());
        data.setBillPdf(req.getBillPdf());
        data.setPayNote(req.getPayNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setStatus(ETotalAdvanceFundStatus.HANDLED.getCode());// 已打款给分公司
        totalAdvanceFundBO.refreshTotalAdvanceFund(data);
        // 补全确认打款给分公司的日志
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.ADVANCE_FUND_BRANCH,
            data.getCode(), EAdvanceFundNode.BRANCH_COMPANY.getCode(),
            req.getPayNote(), req.getOperator());

        for (String code : codeList) {
            AdvanceFund advanceFund = advanceFundBO.getAdvanceFund(code);
            advanceFund.setTotalAdvanceFundCode(data.getCode());
            advanceFund.setUpdateDatetime(new Date());
            String preNodeCode = advanceFund.getCurNodeCode();// 当前节点
            advanceFund.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preNodeCode).getNextNode());
            advanceFundBO.confirmPayBranchCompany(advanceFund);
            // 生成下一步操作日志 确认打款给车行
            sysBizLogBO.saveSYSBizLog(advanceFund.getBudgetCode(),
                EBizLogType.ADVANCE_FUND_BRANCH, advanceFund.getCode(),
                advanceFund.getCurNodeCode());
        }
    }

    @Override
    public void financeConfirm(XN632233Req req) {
        TotalAdvanceFund data = new TotalAdvanceFund();
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        data.setType(req.getType());// 类型（2发票不匹配补打款3发票不匹配收回款）
        data.setCompanyCode(budgetOrder.getCompanyCode());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        String amount = req.getAmount();
        if (ETotalAdvanceFundType.SECOND.getCode().equals(req.getType())) {// 发票不匹配补打款
            data.setPayAmount(StringValidater.toLong(amount));
            data.setPayDatetime(DateUtil.strToDate(req.getDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setPayBankcardCode(req.getBankcardCode());
            data.setBillPdf(req.getBillPdf());
            data.setPayNote(req.getRemark());
        } else {// 发票不匹配收回款
            data.setCollectionAmount(StringValidater.toLong(amount));
            data.setCollectionDatetime(DateUtil.strToDate(req.getDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setCollectionBankcardCode(req.getBankcardCode());
            data.setCollectionBillPdf(req.getBillPdf());
            data.setCollectionNote(req.getRemark());
        }
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        totalAdvanceFundBO.saveTotalAdvanceFund(data);
        // 改回发票不匹配时冻结的主流程节点
        budgetOrder.setCurNodeCode(budgetOrder.getCancelNodeCode());
        budgetOrder.setCancelNodeCode(null);
        budgetOrder.setFrozenStatus(EBudgetFrozenStatus.NORMAL.getCode());
        budgetOrder.setFbhStatus(EFbhStatus.TO_PENDING_ENTRY.getCode());// 发保合状态改为已录入发保合
        budgetOrderBO.invoiceMismatchFinanceConfirm(budgetOrder);

        // 已录入发保合 把返点明细状态改为待打款
        CarDealer carDealer = carDealerBO.getCarDealer(budgetOrder
            .getCarDealerCode());
        if (!carDealer.getSettleWay().equals(ESettleWay.MONTH.getCode())) {// 不是月结的在垫资后并且录完发保合可以返点
            RepointDetail condition = new RepointDetail();
            condition.setBudgetCode(budgetOrder.getCode());
            List<RepointDetail> list = repointDetailBO
                .queryRepointDetailList(condition);
            for (RepointDetail repointDetail : list) {
                repointDetail.setCurNodeCode(ERepointDetailStatus.TODO_PAY
                    .getCode());
                repointDetailBO.updateCurNodeCode(repointDetail);
            }
        }
    }

    @Override
    public int dropTotalAdvanceFund(String code) {
        if (!totalAdvanceFundBO.isTotalAdvanceFundExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return totalAdvanceFundBO.removeTotalAdvanceFund(code);
    }

    @Override
    public Paginable<TotalAdvanceFund> queryTotalAdvanceFundPage(int start,
            int limit, TotalAdvanceFund condition) {
        return totalAdvanceFundBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<TotalAdvanceFund> queryTotalAdvanceFundList(
            TotalAdvanceFund condition) {
        return totalAdvanceFundBO.queryTotalAdvanceFundList(condition);
    }

    @Override
    public TotalAdvanceFund getTotalAdvanceFund(String code) {
        return totalAdvanceFundBO.getTotalAdvanceFund(code);
    }

    @Override
    public int editTotalAdvanceFund(TotalAdvanceFund data) {
        if (!totalAdvanceFundBO.isTotalAdvanceFundExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return totalAdvanceFundBO.refreshTotalAdvanceFund(data);
    }

    private Long getLong(Object obj) {
        if (null == obj) {
            return 0L;
        } else {
            return (Long) obj;
        }
    }

}
