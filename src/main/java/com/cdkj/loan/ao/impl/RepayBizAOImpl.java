package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.req.XN630551Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.exception.BizException;

@Service
public class RepayBizAOImpl implements IRepayBizAO {

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBudgetOrderAO budgetOrderAO;

    @Autowired
    private IOrderAO orderAO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    // 变更银行卡
    @Override
    public void editBankcardNew(XN630510Req req) {
        String code = bankcardBO.saveBankcardBiz(req);
        repayBizBO.refreshBankcardNew(req.getCode(), code, req.getUpdater(),
            req.getRemark());
    }

    // 变更银行卡
    @Override
    public void editBankcardModify(XN630511Req req) {
        bankcardBO.getBankcard(req.getCode());
        repayBizBO.refreshBankcardModify(req.getCode(), req.getBankcardCode(),
            req.getUpdater(), req.getRemark());
    }

    private void setRefInfo(RepayBiz repayBiz) {
        repayBiz.setUser(userBO.getUser(repayBiz.getUserId()));
        RepayPlan condition = new RepayPlan();
        condition.setOrder("cur_periods", true);
        condition.setRepayBizCode(repayBiz.getCode());
        List<RepayPlan> repayPlanList = repayPlanBO
            .queryRepayPlanList(condition);
        repayBiz.setRepayPlanList(repayPlanList);

        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
            repayBiz.setBudgetOrder(
                budgetOrderAO.getBudgetOrder(repayBiz.getRefCode()));
        } else {
            repayBiz.setMallOrder(orderAO.getOrder(repayBiz.getRefCode()));
        }

        Long deposit = repayBiz.getLyDeposit() - repayBiz.getCutLyDeposit();
        Long amount = 0L;
        for (RepayPlan repayPlan2 : repayPlanList) {
            // 实际退款金额
            Long shouldDeposit = repayPlan2.getShouldDeposit();
            deposit = deposit + shouldDeposit;

            // 借款余额
            Long overplusAmount = repayPlan2.getOverplusAmount();
            amount = amount + overplusAmount;
        }
        repayBiz.setActualRefunds(deposit);
        repayBiz.setLoanBalance(amount);
        String bankName = bankBO.getBank(repayBiz.getLoanBank()).getBankName();
        repayBiz.setLoanBankName(bankName);
    }

    // 提前还款
    @Override
    public void advanceRepay(String code, String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.TO_REPAY.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于还款中");
        }

        // 判断是否逾期
        // List<RepayPlan> planList = repayPlanBO
        // .queryRepayPlanListByRepayBizCode(code);
        // for (RepayPlan repayPlan : planList) {
        // if (!repayPlan.getStatus().equals(
        // ERepayPlanNode.TO_REPAYMENTS.getCode())
        // && !repayPlan.getStatus().equals(
        // ERepayPlanStatus.YET_REPAYMENTS.getCode())
        // && !repayPlan.getStatus().equals(
        // ERepayPlanStatus.HESUAN_TO_GREEN.getCode())) {
        // // 逾期处理
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
        // "当前有逾期未处理完成的还款计划，不能提前还款！");
        // }
        // }

        // 提前还款服务费
        Long fwAmount = sysConfigBO.getLongValue(SysConstants.TQ_SERVICE);
        // 代扣总金额
        Long allAmount = repayBiz.getRestAmount() + fwAmount;
        // 代扣银行卡
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());
        // 必须扣全部，要么扣成功，要么扣失败，不能扣部分金额
        Long realWithholdAmount = baofuWithhold(bankcard, allAmount);
        // 更新还款业务
        repayBizBO.refreshAdvanceRepayCarLoan(repayBiz, realWithholdAmount);
        // 改变还款计划状态
        // for (RepayPlan repayPlan : planList) {
        // if (!ERepayPlanStatus.TO_REPAYMENTS.getCode().equals(
        // repayPlan.getStatus())) {
        // continue;
        // }
        // repayPlan.setStatus(ERepayPlanStatus.YET_REPAYMENTS.getCode());
        // repayPlanBO.refreshRepayPlanStatus(repayPlan);
        // }

    }

    @Override
    public void approveByQkcsDepartment(String code, String approveResult,
            Long cutLyDeposit, String updater, String remark) {
        // 1、审核前提：判断当前节点是否在请款催收部审核节点
        // QKCS_DEPART_CHECK
        if (EBoolean.YES.getCode().equals(approveResult)) {
        }
    }

    private Long baofuWithhold(Bankcard bankcard, Long amount) {
        Long successAmount = 0L;
        // TODO 宝付代扣逻辑
        successAmount = amount;
        return successAmount;
    }

    // private BooleanRes daiKou(RepayBiz repayBiz) {
    // long dkAmount = repayBiz.getFirstRepayAmount()
    // * repayBiz.getRestPeriods();
    // return new BooleanRes(true);
    // }

    @Override
    public void enterBlackListProduct(String code, String blackHandleNote,
            String updater, String remark) {
        // TODO 验证还款业务状态，以及业务类型是否是产品
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        repayBiz.setBlackHandleNote(blackHandleNote);
        repayBiz.setCurNodeCode(ERepayBizNode.PRO_BAD_DEBT.getCode());
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizBO.refreshEnterBlackList(repayBiz);

        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(code);
        List<RepayPlan> planList = repayPlanBO.queryRepayPlanList(condition);
        for (RepayPlan repayPlan : planList) {
            repayPlan.setCurNodeCode(ERepayPlanNode.PRD_HANDLER_TO_BLACK
                .getCode());
            repayPlanBO.refreshToBlackProduct(repayPlan);
        }
    }

    @Override
    @Transactional
    public void confirmSettledProduct(XN630513Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.PRO_SETTLED.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前产品状态不是已还款，不能确认结清！");
        }

        // 更新还款业务
        repayBiz.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        repayBiz.setSettleAttach(req.getSettleAttach());
        repayBiz.setSettleDatetime(new Date());
        repayBiz.setUpdater(req.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(req.getRemark());
        repayBizBO.confirmSettledProduct(repayBiz);

        // 还款计划批量结清
        // RepayPlan planConditon = new RepayPlan();
        // planConditon.setRepayBizCode(req.getCode());
        // List<RepayPlan> planList =
        // repayPlanBO.queryRepayPlanList(planConditon);
        // for (RepayPlan repayPlan : planList) {
        // repayPlan.setCurNodeCode(ERepayPlanNode.PRD_REPAY_YES.getCode());
        // repayPlanBO.refreshRepayPlanNode(repayPlan);
        // }
    }

    @Override
    public void approveByQkcsDepart(String code, Long cutLyDeposit,
            String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.QKCS_DEPART_CHECK.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于清款催收部审核中");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            EBoolean.YES.getCode());

        repayBizBO.approveByQkcsDepart(code, nextNodeCode, cutLyDeposit,
            updater, remark);
    }

    @Override
    public void approveByBankCheck(XN630551Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.BANK_CHECK.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于驻行人员审核中");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            req.getApproveResult());

        repayBizBO.approveByBankCheck(req.getCode(), nextNodeCode,
            DateUtil.strToDate(req.getSettleDatetime(),
                DateUtil.DATA_TIME_PATTERN_1),
            req.getSettlePdf(), req.getOperator(), req.getRemark());
    }

    @Override
    public void approveByManager(String code, String approveResult,
            String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.MANAGER_CHECK.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于总经理审核中");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);
        repayBizBO.approveByManager(code, nextNodeCode, updater, remark);
    }

    @Override
    public void approveByFinance(String code, String approveResult,
            String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.FINANCE_CHECK.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于财务审核中");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);
        repayBizBO.approveByFinance(code, nextNodeCode, updater, remark);
    }

    @Override
    public void releaseMortgage(String code, Date releaseDatetime,
            String updater) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.RELEASE_MORTGAGE.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于解除抵押中");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            EBoolean.YES.getCode());
        repayBizBO.releaseMortgage(code, nextNodeCode, releaseDatetime,
            updater);
    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition) {
        Paginable<RepayBiz> results = repayBizBO.getPaginable(start, limit,
            condition);
        for (RepayBiz repayBiz : results.getList()) {
            // LoanOrder loanOrder = new LoanOrder();
            // loanOrder.setRepayBizCode(repayBiz.getCode());
            // List<LoanOrder> queryLoanOrderList = loanOrderBO
            // .queryLoanOrderList(loanOrder);
            // repayBiz.setLoanOrderList(queryLoanOrderList);
            setRefInfo(repayBiz);
        }
        return results;
    }

    @Override
    public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
        return repayBizBO.queryRepayBizList(condition);
    }

    @Override
    public RepayBiz getRepayBiz(String code) {
        // 查询实际退款金额
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        setRefInfo(repayBiz);
        return repayBiz;
    }

    private String getNextNodeCode(String curNodeCode, String approveResult) {
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        String nextNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlow.getNextNode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlow.getBackNode();
        }
        return nextNodeCode;
    }

}
