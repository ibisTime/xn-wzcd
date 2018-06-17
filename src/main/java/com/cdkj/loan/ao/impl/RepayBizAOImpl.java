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
import com.cdkj.loan.bo.IJudgeBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630512Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.req.XN630550Req;
import com.cdkj.loan.dto.req.XN630556Req;
import com.cdkj.loan.dto.req.XN630557Req;
import com.cdkj.loan.dto.req.XN630563Req;
import com.cdkj.loan.dto.req.XN630570Req;
import com.cdkj.loan.dto.req.XN630572Req;
import com.cdkj.loan.dto.req.XN630576Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EDealResult;
import com.cdkj.loan.enums.ELogisticsType;
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

    @Autowired
    private IJudgeBO judgeBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    private ISYSBizLogBO sysBizLogBO;

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

        // 司法诉讼
        Judge judgeCondition = new Judge();
        judgeCondition.setRepayBizCode(repayBiz.getCode());
        repayBiz.setJudgeList(judgeBO.queryJudgeList(judgeCondition));

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
        repayBizBO
            .refreshAdvanceRepayCarLoan(req, repayBiz, realWithholdAmount);
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

    // 逻辑
    // 1、节点前提判断
    // 2、将信息录入还款计划，还款业务节点信息更新
    @Override
    @Transactional
    public void takeCarApply(XN630550Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.TC_APPLY.getCode().equals(repayBiz.getCurNodeCode())
                && !ERepayBizNode.TC_RISK_MANAGE_CHECK_NO.getCode().equals(
                    repayBiz.getCurNodeCode())
                && !ERepayBizNode.TC_COMPANY_MANAGE_CHECK_NO.getCode().equals(
                    repayBiz.getCurNodeCode())
                && !ERepayBizNode.TC_RISK_LEADER_CHECK_NO.getCode().equals(
                    repayBiz.getCurNodeCode())
                && !ERepayBizNode.TC_FINANCE_CHECK_NO.getCode().equals(
                    repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在拖车提交节点！");
        }

        // 还款计划落地数据
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlanBO.takeCarApply(repayPlan, req);

        // 还款业务变更节点
        String preNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(preNodeCode,
            EBoolean.YES.getCode());
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarApply(repayBiz);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    public void takeCarRiskManageCheck(String code, String approveResult,
            String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.TC_RISK_MANAGE_CHECK.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在拖车风控经理审核节点！");
        }

        // 还款业务变更节点
        String preNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(preNodeCode, approveResult);
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarRiskManageCheck(repayBiz);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void takeCarCompanyManageCheck(String code, String approveResult,
            String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.TC_COMPANY_MANAGE_CHECK.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在拖车分公司总经理审核节点！");
        }

        // 还款业务变更节点
        String preNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(preNodeCode, approveResult);
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarCompanyManageCheck(repayBiz);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), operator);

    }

    @Override
    public void takeCarRiskLeaderCheck(String code, String approveResult,
            String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.TC_RISK_LEADER_CHECK.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在风控总监审核节点！");
        }

        // 还款业务变更节点
        String preNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(preNodeCode, approveResult);
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarRiskLeaderCheck(repayBiz);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void takeCarFinanceManageCheck(String code, String approveResult,
            String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.TC_FINANCE_CHECK.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在财务经理审核节点！");
        }

        // 还款业务变更节点
        String preNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(preNodeCode, approveResult);
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarFinanceManageCheck(repayBiz);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void takeCarSureFk(String code, String remitBankCode,
            String remitBillPdf, Date remitDatetime, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.TC_SURE_FK.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在确认放款节点！");
        }

        // 还款计划变更节点
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(code,
            ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlanBO.takeCarSureFk(repayPlan, remitBankCode, remitBillPdf,
            remitDatetime, operator);

        // 还款业务变更节点
        String preNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(preNodeCode,
            EBoolean.YES.getCode());
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarSureFk(repayBiz);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), operator);
    }

    @Override
    public void takeCarInputResult(XN630556Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.TC_RESULT_INPUT.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在录入拖车结果节点！");
        }

        // 还款计划变更节点
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlanBO.takeCarInputResult(repayPlan, req);

        // 还款业务变更节点
        String preNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = getNextNodeCode(preNodeCode,
            EBoolean.YES.getCode());
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarInputResult(repayBiz);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    public void takeCarResultHandle(XN630557Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.TC_TO_HANDLE.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在拖车结果已录入待处理节点！");
        }

        // 还款计划变更节点
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlanBO.takeCarResultHandle(repayPlan, req);

        // 还款业务变更节点
        String preNodeCode = repayBiz.getCurNodeCode();
        String nextNodeCode = null;
        if (EDealResult.SELLED.getCode().equals(req.getDealResult())) {// 出售
            nextNodeCode = ERepayBizNode.SELLED.getCode();
            // 还款计划处理为坏账
            repayPlanBO.refreshRepayPlanTakeCarHandle(
                repayPlan.getRepayBizCode(), ERepayPlanNode.BAD_DEBT);

        } else if (EDealResult.REDEEM.getCode().equals(req.getDealResult())
                || EDealResult.GREEN.getCode().equals(req.getDealResult())) {// 赎回或缴纳押金
            if (repayPlan.getCurPeriods() == repayPlan.getPeriods()) {// 最后一期
                nextNodeCode = ERepayBizNode.COMMIT_SETTLE.getCode();
                // 还款计划处理为已结清
                repayPlanBO.refreshRepayPlanTakeCarHandle(
                    repayPlan.getRepayBizCode(), ERepayPlanNode.REPAY_YES);

            } else {
                nextNodeCode = ERepayBizNode.TO_REPAY.getCode();
                // 还款计划处理为继续还款中
                repayPlanBO.repaySuccess(repayPlan,
                    repayPlan.getMonthRepayAmount());
            }
        } else if (EDealResult.JUDGE.getCode().equals(req.getDealResult())) {// 司法诉讼，还款计划暂不处理
            nextNodeCode = ERepayBizNode.JUDGE.getCode();
        }
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarResultHandle(repayBiz);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            currentNode.getCode(), currentNode.getValue(), req.getOperator());
    }

    @Override
    @Transactional
    public void judgeFinanceSureReceipt(XN630563Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.FINANCE_SURE_RECEIPT.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "当前还款业务不在财务确认收款节点！");
        }

        repayBiz.setJudgeReceiptDatetime(DateUtil.strToDate(
            req.getJudgeReceiptDatetime(), DateUtil.DATA_TIME_PATTERN_1));
        repayBiz.setJudgeReceiptAmount(StringValidater.toLong(req
            .getJudgeReceiptAmount()));
        repayBiz.setJudgeReceiptBank(req.getJudgeReceiptBank());
        repayBiz.setJudgeReceiptBankcard(req.getJudgeReceiptBankcard());
        repayBiz.setJudgeBillPdf(req.getJudgeBillPdf());

        repayBiz.setJudgeNote(req.getJudgeNote());
        repayBiz.setUpdater(req.getOperator());
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.refreshJudgeFinanceSureReceipt(repayBiz);

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap().get(
            nodeFlowBO.getNodeFlowByCurrentNode(repayBiz.getCurNodeCode())
                .getNextNode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getCode(),
            EBizLogType.REPAY_BIZ, req.getCode(), repayBiz.getCurNodeCode(),
            node.getCode(), node.getValue(), req.getOperator());
    }

    @Override
    public void settltCommitSettle(XN630570Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.COMMIT_SETTLE.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "还款业务不在结算单申请节点！");
        }

        RepayBiz data = new RepayBiz();
        data.setCode(req.getCode());
        data.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        data.setRefundBankSubbranch(req.getRefundBankSubbranch());
        data.setRefundBankRealName(req.getRefundBankRealName());

        data.setRefundBankcard(req.getRefundBankcard());
        data.setSecondCompanyInsurance(req.getSecondCompanyInsurance());
        data.setThirdCompanyInsurance(req.getThirdCompanyInsurance());
        data.setSettleAttach(req.getSettleAttach());
        data.setSettleDatetime(DateUtil.strToDate(req.getSettleDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));

        data.setDepositReceipt(req.getDepositReceipt());
        data.setRemark(req.getRemark());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            EBoolean.YES.getCode());
        data.setCurNodeCode(nextNodeCode);
        repayBizBO.refreshCommitSettle(data);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
            repayBiz.getCurNodeCode(), nextNodeCode, currentNode.getValue(),
            req.getOperator());
    }

    @Override
    @Transactional
    public void settleFinanceCheck(String code, String approveResult,
            String approveNote, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.FINANCE_CHECK.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "还款业务不在财务审核节点！");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);

        repayBizBO.refreshFinanceCheck(code, nextNodeCode, approveNote,
            operator);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
            repayBiz.getCurNodeCode(), nextNodeCode, currentNode.getValue(),
            operator);
    }

    @Override
    @Transactional
    public void settleCashRemit(XN630572Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.CASH_REMIT.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "还款业务不在出纳打款节点！");
        }

        RepayBiz data = new RepayBiz();
        data.setCode(req.getCode());
        data.setSettlePayDatetime(DateUtil.strToDate(
            req.getSettlePayDatetime(), DateUtil.DATA_TIME_PATTERN_1));
        data.setSettleBank(req.getSettleBank());
        data.setSettleBankcard(req.getSettleBankcard());
        data.setSettlePdf(req.getSettlePdf());

        data.setSettleNote(req.getSettleNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            EBoolean.YES.getCode());
        data.setCurNodeCode(nextNodeCode);
        repayBizBO.refreshCashRemit(data);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
            repayBiz.getCurNodeCode(), nextNodeCode, currentNode.getValue(),
            req.getOperator());
    }

    @Override
    @Transactional
    public void settleReleaseMortgageApply(String code,
            String releaseApplyNote, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.RELEASE_MORTGAGE_APPLY.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "还款业务不在解除抵押申请节点！");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            EBoolean.YES.getCode());
        repayBizBO.refreshReleaseMortgageApply(code, nextNodeCode,
            releaseApplyNote, operator);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
            repayBiz.getCurNodeCode(), nextNodeCode, currentNode.getValue(),
            operator);
    }

    @Override
    @Transactional
    public void settleRiskIndoorCheck(String code, String approveResult,
            String approveNote, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.RISK_INDOOR_CHECK.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "还款业务不在风控内勤审核节点！");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);
        repayBizBO.refreshRiskIndoorCheck(code, nextNodeCode, approveNote,
            operator);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
            repayBiz.getCurNodeCode(), nextNodeCode, currentNode.getValue(),
            operator);
    }

    @Override
    @Transactional
    public void settleRiskManagerCheck(String code, String approveResult,
            String approveNote, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (!ERepayBizNode.RISK_MANAGER_CHECK.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "还款业务不在风控经理审核节点！");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);
        repayBizBO.refreshRiskManagerCheck(code, nextNodeCode, approveNote,
            operator);

        // 生成资料传递
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(repayBiz
            .getCurNodeCode());
        logisticsBO.saveLogistics(ELogisticsType.REPAY_BIZ.getCode(), code,
            repayBiz.getUserId(), repayBiz.getCurNodeCode(), nextNodeCode,
            nodeFlow.getFileList());

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
            repayBiz.getCurNodeCode(), nextNodeCode, currentNode.getValue(),
            operator);
    }

    @Override
    @Transactional
    public void settleMortgageInput(XN630576Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.MORTGAGE_INPUT.getCode().equals(
            repayBiz.getCurNodeCode())) {
            throw new BizException("xn0000", "还款业务不在驻行人员回录抵押节点！");
        }

        RepayBiz data = new RepayBiz();
        data.setCode(req.getCode());
        data.setReleaseDatetime(DateUtil.strToDate(req.getReleaseDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setReleaseTemplateId(req.getReleaseTemplateId());
        data.setReleaseNote(req.getReleaseNote());
        data.setUpdater(req.getOperator());

        data.setUpdateDatetime(new Date());
        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            EBoolean.YES.getCode());
        data.setCurNodeCode(nextNodeCode);
        repayBizBO.refreshMortgageInput(data);

        // 日志记录
        ERepayBizNode currentNode = ERepayBizNode.getMap().get(
            repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
            repayBiz.getCurNodeCode(), nextNodeCode, currentNode.getValue(),
            req.getOperator());
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
