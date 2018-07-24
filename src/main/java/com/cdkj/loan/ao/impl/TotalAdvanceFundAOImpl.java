package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ITotalAdvanceFundAO;
import com.cdkj.loan.bo.IAdvanceFundBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
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
import com.cdkj.loan.domain.RepointDetail;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.domain.TotalAdvanceFund;
import com.cdkj.loan.dto.req.XN632174Req;
import com.cdkj.loan.dto.req.XN632176Req;
import com.cdkj.loan.dto.req.XN632233Req;
import com.cdkj.loan.enums.EAdvanceFundNode;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetFrozenStatus;
import com.cdkj.loan.enums.EFbhStatus;
import com.cdkj.loan.enums.ERepointDetailStatus;
import com.cdkj.loan.enums.EReqBudgetNode;
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

    @Override
    public void addTotalAdvanceFund(XN632174Req req) {
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
            // 日志
            sysBizLogBO.refreshPreSYSBizLog(EBizLogType.ADVANCE_FUND_BRANCH,
                advanceFund.getCode(), preNodeCode, req.getMakeBillNote(),
                req.getOperator());
            advanceFundBO.branchMakeBill(advanceFund);// 垫资汇总表的编号未放入 TODO
            totalAdvanceFund += getLong(advanceFund.getUseAmount());
        }
        TotalAdvanceFund data = new TotalAdvanceFund();
        data.setType(ETotalAdvanceFundType.FIRST.getCode());
        data.setCompanyCode(req.getCompanyCode());
        data.setTotalAdvanceFund(totalAdvanceFund);// 待垫资金额（制单时通过审核的所有垫资单相加总金额）
        ReqBudget reqBudget = reqBudgetBO.getTodayReqBudget(req
            .getCompanyCode());
        Long reqBudgetAmount = getLong(reqBudget.getPayAmount());
        Long payAmount = totalAdvanceFund - reqBudgetAmount;
        if (payAmount < 0) {
            payAmount = 0L;
            // 生成待收回预算款
            reqBudget.setCollectionAmount(reqBudgetAmount - totalAdvanceFund);
            reqBudget.setCurNodeCode(EReqBudgetNode.COLLECTION.getCode());
            // 生成日志
            sysBizLogBO.saveSYSBizLog(reqBudget.getCode(),
                EBizLogType.REQ_BUDGET, reqBudget.getCode(),
                EReqBudgetNode.COLLECTION.getCode());
            reqBudgetBO.refreshReqBudget(reqBudget);
        }
        data.setPayAmount(payAmount);// 付款金额（垫资总金额-请款预算单金额=本次垫资金额）
        data.setMakeBillNote(req.getMakeBillNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setStatus(EBoolean.NO.getCode());
        String totalAdvanceCode = totalAdvanceFundBO.saveTotalAdvanceFund(data);
        for (String code : codeList) {
            AdvanceFund advanceFund = advanceFundBO.getAdvanceFund(code);
            advanceFund.setTotalAdvanceFundCode(totalAdvanceCode);// 垫资单回写垫资汇总单编号
            advanceFundBO.branchMakeBill(advanceFund);
        }
        // 产生日志
        sysBizLogBO.saveSYSBizLog(data.getCode(),
            EBizLogType.ADVANCE_FUND_BRANCH, data.getCode(),
            EAdvanceFundNode.BRANCH_COMPANY.getCode());
    }

    @Override
    public int editTotalAdvanceFund(TotalAdvanceFund data) {
        if (!totalAdvanceFundBO.isTotalAdvanceFundExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return totalAdvanceFundBO.refreshTotalAdvanceFund(data);
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
    public String confirmPayBranchCompany(XN632176Req req) {

        TotalAdvanceFund data = new TotalAdvanceFund();
        data.setType(ETotalAdvanceFundType.FIRST.getCode());
        data.setCompanyCode(req.getCompanyCode());
        data.setTotalAdvanceFund(StringValidater.toLong(req
            .getTotalAdvanceFund()));
        data.setPayAmount(StringValidater.toLong(req.getPayAmount()));

        data.setPayDatetime(DateUtil.strToDate(req.getPayDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setPayBankcardCode(req.getPayBankcardCode());
        data.setBillPdf(req.getBillPdf());
        data.setPayNote(req.getPayNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setStatus(ETotalAdvanceFundStatus.HANDLED.getCode());// 待处理
        String totalAdvanceFundCode = totalAdvanceFundBO
            .saveTotalAdvanceFund(data);

        List<String> codeList = req.getCodeList();
        for (String code : codeList) {
            AdvanceFund advanceFund = advanceFundBO.getAdvanceFund(code);
            advanceFund.setTotalAdvanceFundCode(totalAdvanceFundCode);
            advanceFund
                .setAdvanceFundDatetime(DateUtil.strToDate(
                    req.getAdvanceFundDatetime(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            String preNodeCode = advanceFund.getCurNodeCode();
            advanceFund.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preNodeCode).getNextNode());
            advanceFundBO.confirmPayBranchCompany(advanceFund);
            EAdvanceFundNode node = EAdvanceFundNode.getMap().get(
                advanceFund.getCurNodeCode());
            sysBizLogBO.saveNewAndPreEndSYSBizLog(advanceFund.getCode(),
                EBizLogType.ADVANCE_FUND_BRANCH, advanceFund.getCode(),
                preNodeCode, node.getCode(), req.getPayNote(),
                req.getOperator());
        }

        return totalAdvanceFundCode;

    }

    @Override
    public void financeConfirm(XN632233Req req) {
        TotalAdvanceFund data = new TotalAdvanceFund();
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        data.setType(req.getType());
        data.setCompanyCode(budgetOrder.getCompanyCode());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());

        if (ETotalAdvanceFundType.SECOND.getCode().equals(req.getType())) {
            data.setPayAmount(StringValidater.toLong(req.getPayAmount()));
            data.setPayBankcardCode(req.getPayBankcardCode());
            data.setPayDatetime(DateUtil.strToDate(req.getPayDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setBillPdf(req.getPayBillPdf());
        }
        if (ETotalAdvanceFundType.COLLECTION.getCode().equals(req.getType())) {
            data.setCollectionAmount(StringValidater.toLong(req
                .getCollectionAmount()));
            data.setCollectionBankcardCode(req.getCollectionBankcardCode());
            data.setCollectionDatetime(DateUtil.strToDate(
                req.getCollectionDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setCollectionBillPdf(req.getCollectionBillPdf());
        }
        // 改回之前节点
        budgetOrder.setCurNodeCode(budgetOrder.getCancelNodeCode());
        budgetOrder.setCancelNodeCode(null);
        budgetOrder.setFrozenStatus(EBudgetFrozenStatus.NORMAL.getCode());
        budgetOrder.setFbhStatus(EFbhStatus.TO_PENDING_ENTRY.getCode());// 发保合状态改为已录入发保合
        budgetOrderBO.invoiceMismatchFinanceConfirm(budgetOrder);
        totalAdvanceFundBO.saveTotalAdvanceFund(data);
        if (EFbhStatus.TO_PENDING_ENTRY.getCode().equals(
            budgetOrder.getFbhStatus())) {
            // 已录入发保合 把返点明细状态改为待打款
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

    private Long getLong(Object obj) {
        if (null == obj) {
            return 0L;
        } else {
            return (Long) obj;
        }
    }

}
