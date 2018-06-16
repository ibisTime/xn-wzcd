package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630512Req;
import com.cdkj.loan.dto.req.XN630513Req;
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
    private ISYSUserBO sysUserBO;

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
            repayBiz.setBudgetOrder(budgetOrderAO.getBudgetOrder(repayBiz
                .getRefCode()));
        } else {
            repayBiz.setMallOrder(orderAO.getOrder(repayBiz.getRefCode()));
        }
        Long amount = 0L;
        for (RepayPlan repayPlan : repayPlanList) {
            // 借款余额
            Long overplusAmount = repayPlan.getOverplusAmount();
            amount = amount + overplusAmount;
        }

        RepayPlan overdueRepayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            repayBiz.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        repayBiz.setOverdueRepayPlan(overdueRepayPlan);
    }

    @Override
    @Transactional
    public void advanceRepayOss(XN630512Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
            advanceRepayCarLoanOss(req, repayBiz);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "暂不支持产品管理端提前还款");
        }
    }

    // 车贷订单提前还款逻辑
    // 1、判断还款业务是否是还款中，还款计划是否含有催收失败，进红名单处理，红名单处理中的状态，有则无法处理
    // 2、
    private void advanceRepayCarLoanOss(XN630512Req req, RepayBiz repayBiz) {
        // 1、判断还款业务是否是还款中，还款计划是否含有催收失败，进红名单处理，红名单处理中的状态，有则无法处理
        if (!ERepayBizNode.TO_REPAY.getCode().equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于还款中");
        }

        List<RepayPlan> planList = repayPlanBO
            .queryRepayPlanListByRepayBizCode(repayBiz.getCode());
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.HANDLER_TO_RED.getCode().equals(
                repayPlan.getCurNodeCode())
                    || ERepayPlanNode.QKCSB_APPLY_TC.getCode().equals(
                        repayPlan.getCurNodeCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前有逾期未处理完成的还款计划，不能提前还款！");
            }
        }

        // 代扣总金额
        Long allAmount = repayBiz.getRestAmount();
        // 代扣银行卡
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());
        // 必须扣全部，要么扣成功，要么扣失败，不能扣部分金额
        Long realWithholdAmount = baofuWithhold(bankcard, allAmount);
        // 更新还款业务
        repayBizBO.refreshAdvanceRepayCarLoan(repayBiz, realWithholdAmount);
        // 改变还款计划状态
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.TO_REPAY.getCode().equals(
                repayPlan.getCurNodeCode())) {
                // 更新还款计划
                repayPlanBO.repaySuccess(repayPlan,
                    repayPlan.getMonthRepayAmount());
            }
        }
    }

    // 提前还款
    @Override
    @Transactional
    public void advanceRepay(String code, String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
            advanceRepayCarLoan(code, repayBiz);
        } else {
            advanceRepayProductLoan(code, repayBiz);
        }
    }

    // 车贷订单提前还款
    private void advanceRepayCarLoan(String code, RepayBiz repayBiz) {
        if (!ERepayBizNode.TO_REPAY.getCode().equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于还款中");
        }

        // 判断还款计划中是否含有催收失败，进红名单处理，红名单处理中的状态，有则有逾期
        List<RepayPlan> planList = repayPlanBO
            .queryRepayPlanListByRepayBizCode(code);
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.HANDLER_TO_RED.getCode().equals(
                repayPlan.getCurNodeCode())
                    || ERepayPlanNode.QKCSB_APPLY_TC.getCode().equals(
                        repayPlan.getCurNodeCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前有逾期未处理完成的还款计划，不能提前还款！");
            }
        }
        // 代扣总金额
        Long allAmount = repayBiz.getRestAmount();
        // 代扣银行卡
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());
        // 必须扣全部，要么扣成功，要么扣失败，不能扣部分金额
        Long realWithholdAmount = baofuWithhold(bankcard, allAmount);
        // 更新还款业务
        repayBizBO.refreshAdvanceRepayCarLoan(repayBiz, realWithholdAmount);
        // 改变还款计划状态
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.TO_REPAY.getCode().equals(
                repayPlan.getCurNodeCode())) {
                // 更新还款计划
                repayPlanBO.repaySuccess(repayPlan,
                    repayPlan.getMonthRepayAmount());
            }
        }
    }

    // 产品订单提前还款
    private void advanceRepayProductLoan(String code, RepayBiz repayBiz) {
        if (!ERepayBizNode.PRO_TO_REPAY.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于还款中");
        }

        int count = repayPlanBO.getTotalCount(repayBiz.getCode(),
            ERepayPlanNode.PRD_TO_REPAY);
        if (count <= 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务已还完！");
        }

        // 代扣总金额
        Long allAmount = repayBiz.getRestAmount();
        // 代扣银行卡
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());
        // 必须扣全部，要么扣成功，要么扣失败，不能扣部分金额
        Long realWithholdAmount = baofuWithhold(bankcard, allAmount);
        // 更新还款业务
        repayBizBO.refreshAdvanceRepayCarLoan(repayBiz, realWithholdAmount);
        // 改变还款计划状态
        RepayPlan rpCondition = new RepayPlan();
        rpCondition.setCurNodeCode(ERepayPlanNode.TO_REPAY.getCode());
        rpCondition.setRepayBizCode(repayBiz.getCode());
        List<RepayPlan> rpList = repayPlanBO.queryRepayPlanList(rpCondition);
        if (CollectionUtils.isNotEmpty(rpList)) {
            for (RepayPlan repayPlan : rpList) {
                if (ERepayPlanNode.TO_REPAY.getCode().equals(
                    repayPlan.getCurNodeCode())) {
                    repayPlanBO.repaySuccess(repayPlan, realWithholdAmount);
                }
            }
        }
    }

    private Long baofuWithhold(Bankcard bankcard, Long amount) {
        Long successAmount = 0L;
        // TODO 宝付代扣逻辑
        successAmount = amount;
        return successAmount;
    }

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
        if (!ERepayBizNode.PRO_SETTLED.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前产品状态不是已还款，不能确认结清！");
        }

        // 更新还款业务
        repayBiz.setCurNodeCode(ERepayBizNode.PRO_CONFIRM_SETTLE.getCode());
        repayBiz.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        repayBiz.setUpdater(req.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(req.getRemark());
        repayBizBO.confirmSettledProduct(repayBiz);
    }

    //
    // @Override
    // public void approveByQkcsDepartment(String code, Long cutLyDeposit,
    // String updater, String remark) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
    // if (!ERepayBizNode.QKCS_DEPART_CHECK.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前还款业务不处于清欠催收部审核中");
    // }
    //
    // String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
    // EBoolean.YES.getCode());
    //
    // repayBizBO.approveByQkcsDepartment(repayBiz, nextNodeCode,
    // cutLyDeposit, updater, remark);
    // }
    //
    // @Override
    // public void approveByBankCheck(XN630551Req req) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
    // if (!ERepayBizNode.BANK_CHECK.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前还款业务不处于驻行人员审核中");
    // }
    //
    // String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
    // req.getApproveResult());
    //
    // repayBizBO.approveByBankCheck(req.getCode(), nextNodeCode, DateUtil
    // .strToDate(req.getSettleDatetime(), DateUtil.DATA_TIME_PATTERN_1),
    // req.getSettlePdf(), req.getOperator(), req.getRemark());
    // }
    //
    // @Override
    // public void approveByManager(String code, String approveResult,
    // String updater, String remark) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
    // if (!ERepayBizNode.MANAGER_CHECK.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前还款业务不处于总经理审核中");
    // }
    //
    // String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
    // approveResult);
    // repayBizBO.approveByManager(code, nextNodeCode, updater, remark);
    // }
    //
    // @Override
    // public void approveByFinance(String code, String approveResult,
    // String updater, String remark) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
    // if (!ERepayBizNode.FINANCE_CHECK.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前还款业务不处于财务审核中");
    // }
    //
    // String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
    // approveResult);
    // repayBizBO.approveByFinance(code, nextNodeCode, updater, remark);
    // }
    //
    // @Override
    // public void releaseMortgage(String code, Date releaseDatetime,
    // String updater) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
    // if (!ERepayBizNode.RELEASE_MORTGAGE.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前还款业务不处于解除抵押中");
    // }
    //
    // String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
    // EBoolean.YES.getCode());
    // repayBizBO
    // .releaseMortgage(code, nextNodeCode, releaseDatetime, updater);
    // }

    @Override
    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition) {
        Paginable<RepayBiz> results = repayBizBO.getPaginable(start, limit,
            condition);
        for (RepayBiz repayBiz : results.getList()) {
            setRefInfo(repayBiz);
        }
        return results;
    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPageByRoleCode(int start,
            int limit, RepayBiz condition) {
        Paginable<RepayBiz> paginable = repayBizBO.getPaginableByRoleCode(
            start, limit, condition);
        for (RepayBiz repayBiz : paginable.getList()) {
            setRefInfo(repayBiz);
        }
        return paginable;
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

    //
    // // 申请拖车逻辑：
    // // 1、前提条件：还款计划是“催收失败，进红名单处理”；再更改还款业务状态
    // @Override
    // @Transactional
    // public void applyTrailer(XN630555Req req) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
    //
    // RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
    // req.getCode(), ERepayPlanNode.HANDLER_TO_RED);
    // if (repayPlan == null) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "还款业务中没有进红名单处理的还款计划！");
    // }
    //
    // repayPlan.setCurNodeCode(ERepayPlanNode.QKCSB_APPLY_TC.getCode());
    // repayPlan.setTsCarAmount(StringValidater.toLong(req.getTsCarAmount()));
    // repayPlan.setTsBankcardNumber(req.getTsBankcardNumber());
    // repayPlan.setTsBankName(req.getTsBankName());
    //
    // repayPlan.setTsSubbranch(req.getTsSubbranch());
    // repayPlan.setTcApplyNote(req.getTcApplyNote());
    // repayPlanBO.applyTrailer(repayPlan);
    //
    // repayBiz.setCurNodeCode(ERepayBizNode.FINANCE_REMIT.getCode());
    // repayBiz.setUpdater(req.getOperator());
    // repayBiz.setUpdateDatetime(new Date());
    // repayBizBO.applyTrailer(repayBiz);
    // }
    //
    // @Override
    // public void financialMoney(String code, String operator,
    // String remitAmount, String remitPdf) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
    // if (!ERepayBizNode.FINANCE_REMIT.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前节点不是财务打款节点，不能操作！");
    // }
    // RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(code,
    // ERepayPlanNode.QKCSB_APPLY_TC);
    // repayPlan.setRemitAmount(StringValidater.toLong(remitAmount));
    // repayPlan.setRemitBillPdf(remitPdf);
    // repayPlanBO.financialMoney(repayPlan);
    //
    // repayBiz.setCurNodeCode(ERepayBizNode.QKCSB_TOTC.getCode());
    // repayBiz.setUpdater(operator);
    // repayBiz.setUpdateDatetime(new Date());
    // repayBizBO.financialMoney(repayBiz);
    // }
    //
    // @Override
    // public void trailerEntry(XN630557Req req) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
    // if (!ERepayBizNode.QKCSB_TOTC.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前节点不是清欠催收部拖车结果待录入节点，不能操作！");
    // }
    // RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
    // req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
    // repayPlan.setTakeCarAddress(req.getTakeCarAddress());
    // repayPlan.setTakeDatetime(DateUtil.strToDate(req.getTakeDatetime(),
    // DateUtil.FRONT_DATE_FORMAT_STRING));
    // repayPlan.setTakeLocation(req.getTakeLocation());
    // repayPlan.setTakeName(req.getTakeName());
    // repayPlan.setTakeNote(req.getTakeNote());
    // repayPlanBO.trailerEntry(repayPlan);
    //
    // repayBiz.setCurNodeCode(ERepayBizNode.QKCSB_TC_INPUT.getCode());
    // repayBiz.setUpdater(req.getOperator());
    // repayBiz.setUpdateDatetime(new Date());
    // repayBizBO.trailerEntry(repayBiz);
    // }
    //
    // @Override
    // public void trailerManage(String code, String appoveResult, String
    // operator) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
    // if (!ERepayBizNode.QKCSB_TC_INPUT.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前节点不是清欠催收部拖车结果已录入节点，不能操作！");
    // }
    // if (EtrailerManageResult.USER_REDEEM.getCode().equals(appoveResult)) {
    // repayBiz.setCurNodeCode(ERepayBizNode.QKCSB_REDEEM_APPLY.getCode());
    // } else {
    // repayBiz.setCurNodeCode(ERepayBizNode.JUDICIAL_LAWSUIT.getCode());
    // }
    // repayBiz.setUpdater(operator);
    // repayBiz.setUpdateDatetime(new Date());
    // repayBizBO.trailerManage(repayBiz);
    // }
    //
    // @Override
    // public void judicialLitigationEntry(String code, String buyOutAmount,
    // String way, String operator) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
    // if (!ERepayBizNode.JUDICIAL_LAWSUIT.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前节点不是司法诉讼节点，不能操作！");
    // }
    // RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(code,
    // ERepayPlanNode.QKCSB_APPLY_TC);
    // repayPlan.setBuyOutAmount(StringValidater.toLong(buyOutAmount));
    // if (EJudicialLitigationEntryWay.BAD_DEBT.getCode().equals(way)) {
    // repayPlan.setCurNodeCode(ERepayPlanNode.BAD_DEBT.getCode());
    // repayBiz.setCurNodeCode(ERepayBizNode.BAD_DEBT.getCode());
    // } else if (EJudicialLitigationEntryWay.TEAN_BUY_OUT.getCode().equals(
    // way)) {
    // repayPlan.setCurNodeCode(ERepayPlanNode.TEAN_BUY_OUT.getCode());
    // repayBiz.setCurNodeCode(ERepayBizNode.TEAN_BUY_OUT.getCode());
    // } else {
    // repayPlan.setCurNodeCode(ERepayPlanNode.TEAM_RENT.getCode());
    // repayBiz.setCurNodeCode(ERepayBizNode.TEAM_RENT.getCode());
    // }
    // repayPlanBO.judicialLitigationEntry(repayPlan);
    //
    // repayBiz.setUpdater(operator);
    // repayBiz.setUpdateDatetime(new Date());
    // repayBizBO.judicialLitigationEntry(repayBiz);
    // }
    //
    // @Override
    // public void qkcsbRedeemApply(XN630561Req req) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
    // if (!ERepayBizNode.QKCSB_REDEEM_APPLY.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前节点不是清欠催收部申请赎回节点，不能操作！");
    // }
    // RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
    // req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
    // repayPlan.setJourPdf(req.getJourPdf());
    // repayPlan.setGuaNote(req.getGuaNote());
    // repayPlan.setGuaName(req.getGuaName());
    // repayPlan.setGuaMobile(req.getGuaMobile());
    // repayPlan.setGuaIdNo(req.getGuaIdNo());
    // repayPlan.setGuaNowAddress(req.getGuaNowAddress());
    // repayPlan.setHousePdf(req.getHousePdf());
    // repayPlanBO.qkcsbRedeemApply(repayPlan);
    //
    // repayBiz.setCurNodeCode(ERepayBizNode.RISK_MANAGER_CHECK.getCode());
    // repayBiz.setUpdater(req.getOperator());
    // repayBiz.setUpdateDatetime(new Date());
    // repayBizBO.qkcsbRedeemApply(repayBiz);
    // }
    //
    // @Override
    // public void riskManagerCheck(XN630563Req req) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
    // if (!ERepayBizNode.RISK_MANAGER_CHECK.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前节点不是风控主管审核节点，不能操作！");
    // }
    // RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
    // req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
    // repayPlan.setSuggest(req.getSuggest());
    // repayPlan.setSuggestNote(req.getSuggestNote());
    // repayPlanBO.riskManagerCheck(repayPlan);
    //
    // if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
    // repayBiz.setCurNodeCode(ERepayBizNode.FINANCE_MANAGER_CHECK
    // .getCode());
    // } else {
    // repayBiz.setCurNodeCode(ERepayBizNode.QKCSB_REDEEM_APPLY.getCode());
    // }
    // repayBiz.setUpdater(req.getOperator());
    // repayBiz.setUpdateDatetime(new Date());
    // repayBizBO.riskManagerCheck(repayBiz);
    // }
    //
    // @Override
    // public void financeApprove(XN630562Req req) {
    // RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
    // if (!ERepayBizNode.FINANCE_MANAGER_CHECK.getCode().equals(
    // repayBiz.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前节点不是财务经理审核节点，不能操作！");
    // }
    // RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
    // req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
    // if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
    // if (ERepayPlanSuggest.SIX_SAFEGUARDS.getCode().equals(
    // repayPlan.getSuggest())) {
    // repayPlan.setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());
    // repayBiz.setCurNodeCode(ERepayBizNode.TO_REPAY.getCode());
    // repayBiz.setCurOverdueCount(repayBiz.getCurOverdueCount() - 1);
    // repayBiz.setOverdueAmount(repayBiz.getOverdueAmount()
    // - repayPlan.getOverdueAmount());
    // } else {
    // repayPlan.setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());
    // repayBiz.setCurNodeCode(ERepayBizNode.RELEASE_MORTGAGE
    // .getCode());
    // repayBiz.setCurOverdueCount(0);
    // repayBiz.setOverdueAmount(0L);
    // }
    // repayPlanBO.financeApprove(repayPlan);
    // } else {
    // repayBiz.setCurNodeCode(ERepayBizNode.RISK_MANAGER_CHECK.getCode());
    // }
    //
    // repayBiz.setUpdater(req.getOperator());
    // repayBiz.setUpdateDatetime(new Date());
    // repayBizBO.financeApprove(repayBiz);
    // }

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

    /** 
     * @see com.cdkj.loan.ao.IRepayBizAO#settleApply()
     */
    @Override
    public void settleApply() {
        // TODO Auto-generated method stub

    }

}
