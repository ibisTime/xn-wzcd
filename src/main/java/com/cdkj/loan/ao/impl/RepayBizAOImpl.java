package com.cdkj.loan.ao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.bo.IBankSubbranchBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IJudgeBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IReplaceRepayApplyBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSDictBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISupplementReasonBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Judge;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.domain.SYSDict;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.SupplementReason;
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
import com.cdkj.loan.dto.req.XN630578Req;
import com.cdkj.loan.dto.res.XN630907Res;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ECollectBankcardType;
import com.cdkj.loan.enums.EDealResult;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.enums.EReplaceRepayApplyNode;
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
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IOrderAO orderAO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IJudgeBO judgeBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBankSubbranchBO bankSubbranchBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private ISupplementReasonBO supplementReasonBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IReplaceRepayApplyBO replaceRepayApplyBO;

    @Autowired
    private ISYSDictBO sysDictBO;

    // 变更银行卡
    @Override
    @Transactional
    public void editBankcardNew(XN630510Req req) {
        String code = bankcardBO.saveBankcardBiz(req);
        repayBizBO.refreshBankcardNew(req.getCode(), code, req.getUpdater(),
            req.getRemark());
    }

    // 变更银行卡
    @Override
    @Transactional
    public void editBankcardModify(XN630511Req req) {
        bankcardBO.getBankcard(req.getCode());
        repayBizBO.refreshBankcardModify(req.getCode(), req.getBankcardCode(),
            req.getUpdater(), req.getRemark());
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
    private void advanceRepayCarLoanOss(XN630512Req req, RepayBiz repayBiz) {
        // 1、判断还款业务是否是还款中，还款计划是否含有催收失败，进红名单处理，红名单处理中的状态，有则无法处理
        if (!ERepayBizNode.TO_REPAY.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不处于还款中");
        }

        List<RepayPlan> planList = repayPlanBO
            .queryRepayPlanListByRepayBizCode(repayBiz.getCode());
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.HANDLER_TO_RED.getCode()
                .equals(repayPlan.getCurNodeCode())) {
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
        repayBizBO.refreshAdvanceRepayCarLoan(req, repayBiz,
            realWithholdAmount);
        // 改变还款计划状态
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.TO_REPAY.getCode()
                .equals(repayPlan.getCurNodeCode())) {
                // 更新还款计划
                Long monthRepayAmount = repayPlan.getRepayCapital()
                        * repayPlan.getRepayInterest();
                repayPlanBO.repaySuccess(repayPlan, monthRepayAmount);
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
        // // TODO 验证还款业务状态，以及业务类型是否是产品
        // RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        // repayBiz.setBlackHandleNote(blackHandleNote);
        // repayBiz.setCurNodeCode(ERepayBizNode.PRO_BAD_DEBT.getCode());
        // repayBiz.setUpdater(updater);
        // repayBiz.setUpdateDatetime(new Date());
        // repayBiz.setRemark(remark);
        // repayBizBO.refreshEnterBlackList(repayBiz);
        //
        // RepayPlan condition = new RepayPlan();
        // condition.setRepayBizCode(code);
        // List<RepayPlan> planList = repayPlanBO.queryRepayPlanList(condition);
        // for (RepayPlan repayPlan : planList) {
        // repayPlan.setCurNodeCode(ERepayPlanNode.PRD_HANDLER_TO_BLACK
        // .getCode());
        // repayPlanBO.refreshToBlackProduct(repayPlan);
        // }

    }

    @Override
    @Transactional
    public void confirmSettledProduct(XN630513Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        // // if (!ERepayBizNode.PRO_SETTLED.getCode()
        // // .equals(repayBiz.getCurNodeCode())) {
        // // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
        // // "当前产品状态不是已还款，不能确认结清！");
        // // }
        //
        // // 更新还款业务
        // //
        // repayBiz.setCurNodeCode(ERepayBizNode.PRO_CONFIRM_SETTLE.getCode());
        repayBiz.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        repayBiz.setUpdater(req.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(req.getRemark());
        repayBizBO.confirmSettledProduct(repayBiz);
    }

    // 逻辑
    // 1、节点前提判断
    // 2、将信息录入还款计划，还款业务节点信息更新
    @Override
    @Transactional
    public void takeCarApply(XN630550Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.TC_APPLY.getCode().equals(preNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在申请收车节点！");
        }

        // 还款计划落地数据
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            req.getCode(), ERepayPlanNode.HANDLER_TO_RED);
        repayPlanBO.takeCarApply(repayPlan, req);

        // 还款业务变更节点
        String nextNodeCode = getNextNodeCode(preNodeCode,
            EBoolean.YES.getCode());
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarApply(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            nextNodeCode, req.getTcApplyNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void takeCarRiskManageCheck(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.TC_RISK_MANAGE_CHECK.getCode().equals(preNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在收车风控经理审核节点！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        // 还款业务变更节点
        String nextNodeCode = getNextNodeCode(preNodeCode, approveResult);
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(note);
        repayBizBO.takeCarRiskManageCheck(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            nextNodeCode, note, operator);
    }

    @Override
    @Transactional
    public void takeCarCompanyManageCheck(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.TC_COMPANY_MANAGE_CHECK.getCode()
            .equals(preNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在收车分公司总经理审核节点！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }
        // 还款业务变更节点
        String nextNodeCode = getNextNodeCode(preNodeCode, approveResult);
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(note);
        repayBizBO.takeCarCompanyManageCheck(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            nextNodeCode, note, operator);
    }

    @Override
    @Transactional
    public void takeCarRiskLeaderCheck(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.TC_RISK_LEADER_CHECK.getCode().equals(preNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在风控总监审核节点！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        // 还款业务变更节点
        String nextNodeCode = getNextNodeCode(preNodeCode, approveResult);
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(code,
            ERepayPlanNode.HANDLER_TO_RED);
        // 如果没有填写拖车费用和赎金，则不需要经过财务
        if (StringUtils.isBlank(repayPlan.getRansom())
                && repayPlan.getTsCarAmount() == null) {
            repayBiz.setCurNodeCode(ERepayBizNode.TC_RESULT_INPUT.getCode());
        } else {
            repayBiz.setCurNodeCode(nextNodeCode);
        }
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(note);
        repayBizBO.takeCarRiskLeaderCheck(repayBiz);
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            nextNodeCode, note, operator);
    }

    @Override
    @Transactional
    public void takeCarFinanceManageCheck(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.TC_FINANCE_CHECK.getCode().equals(preNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在财务经理审核节点！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        // 还款业务变更节点
        String nextNodeCode = getNextNodeCode(preNodeCode, approveResult);
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(note);
        repayBizBO.takeCarFinanceManageCheck(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            nextNodeCode, note, operator);
    }

    @Override
    @Transactional
    public void takeCarSureFk(String code, String remitBankCode,
            String remitBillPdf, Date remitDatetime, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.TC_SURE_FK.getCode().equals(preNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在确认放款节点！");
        }

        // 还款计划变更节点
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(code,
            ERepayPlanNode.HANDLER_TO_RED);
        repayPlanBO.takeCarSureFk(repayPlan, remitBankCode, remitBillPdf,
            remitDatetime, operator);

        // 还款业务变更节点
        String nextNodeCode = getNextNodeCode(preNodeCode,
            EBoolean.YES.getCode());
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBizBO.takeCarSureFk(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            nextNodeCode, null, operator);
    }

    @Override
    @Transactional
    public void takeCarInputResult(XN630556Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.TC_RESULT_INPUT.getCode().equals(preNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在录入收车结果节点！");
        }

        // 还款计划变更节点
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            req.getCode(), ERepayPlanNode.HANDLER_TO_RED);
        repayPlanBO.takeCarInputResult(repayPlan, req);

        // 还款业务变更节点
        String nextNodeCode = getNextNodeCode(preNodeCode,
            EBoolean.YES.getCode());
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBiz.setFinalPayee(req.getFinalPayee());
        repayBiz.setPayeeEnclosure(req.getPayeeEnclosure());
        repayBizBO.takeCarInputResult(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            nextNodeCode, req.getTakeNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void takeCarResultHandle(XN630557Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.TC_TO_HANDLE.getCode().equals(preNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在收车结果已录入待处理节点！");
        }

        // 还款计划变更节点
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            req.getCode(), ERepayPlanNode.HANDLER_TO_RED);
        repayPlanBO.takeCarResultHandle(repayPlan, req);

        // 还款业务变更节点
        String nextNodeCode = null;
        if (EDealResult.SELLED.getCode().equals(req.getDealResult())) {// 转卖
            nextNodeCode = ERepayBizNode.SELLED_FINANCIAL_AUDIT.getCode();
        } else if (EDealResult.REDEEM.getCode().equals(req.getDealResult())) {// 赎回或缴纳押金
            nextNodeCode = ERepayBizNode.REDEEM_FINANCIAL_AUDIT.getCode();
        } else if (EDealResult.GREEN.getCode().equals(req.getDealResult())) {// 申请结清
            BudgetOrder budgetOrder = budgetOrderBO
                .getBudgetOrderByRepayBizCode(req.getCode());
            // 判断是否抵押过
            if (EBudgetOrderNode.LOCAL_PLEDGE_ACHIEVE.getCode()
                .equals(budgetOrder.getPledgeCurNodeCode())
                    || EBudgetOrderNode.OUT_PLEDGE_ACHIEVE.getCode()
                        .equals(budgetOrder.getPledgeCurNodeCode())) {
                nextNodeCode = ERepayBizNode.RELEASE_MORTGAGE_APPLY.getCode();
            } else {
                nextNodeCode = ERepayBizNode.COMMIT_SETTLE.getCode();
            }
            // 还款计划处理为已还款
            repayPlanBO.refreshRepayPlanTakeCarHandle(
                repayPlan.getRepayBizCode(), ERepayPlanNode.REPAY_YES);
        } else if (EDealResult.JUDGE.getCode().equals(req.getDealResult())) {// 司法诉讼，还款计划暂不处理
            nextNodeCode = ERepayBizNode.JUDGE.getCode();
        } else if (EDealResult.COMPANY_CLEARANCE.getCode()
            .equals(req.getDealResult())) {// 公司结清
            nextNodeCode = ERepayBizNode.CLEARANCE_CASHIER.getCode();
            ReplaceRepayApply replaceRepayApply = replaceRepayApplyBO
                .getReplaceRepayApply(req.getReplaceRepayCode());
            replaceRepayApply
                .setCurNodeCode(EReplaceRepayApplyNode.CANCEL.getCode());
            replaceRepayApply.setUpdater(req.getOperator());
            replaceRepayApply.setUpdateDatetime(new Date());
            replaceRepayApplyBO.refreshReplaceRepayStatus(replaceRepayApply);
        } else if (EDealResult.DEFERRED_TREATMENT.getCode()
            .equals(req.getDealResult())) {// 暂缓处理
            nextNodeCode = preNodeCode;
        }
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBiz.setDealResult(req.getDealResult());
        repayBiz.setDealEnclosure(req.getDealEnclosure());
        repayBiz.setRemark(req.getRemark());
        repayBizBO.takeCarResultHandle(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(), preNodeCode,
            nextNodeCode, req.getFeeNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void judgeFinanceSureReceipt(XN630563Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getRepayBizCode());
        if (!ERepayBizNode.FINANCE_SURE_RECEIPT.getCode()
            .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务不在财务确认收款节点！");
        }

        repayBiz.setJudgeReceiptDatetime(DateUtil.strToDate(
            req.getJudgeReceiptDatetime(), DateUtil.DATA_TIME_PATTERN_1));
        repayBiz.setJudgeReceiptAmount(
            StringValidater.toLong(req.getJudgeReceiptAmount()));
        repayBiz.setJudgeReceiptBankCode(req.getJudgeReceiptBankCode());

        repayBiz.setJudgeBillPdf(req.getJudgeBillPdf());

        repayBiz.setJudgeNote(req.getJudgeNote());
        repayBiz.setUpdater(req.getOperator());
        repayBiz.setUpdateDatetime(new Date());

        String preCurNodeCode = repayBiz.getCurNodeCode();
        repayBiz.setCurNodeCode(
            nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode).getNextNode());
        repayBizBO.refreshJudgeFinanceSureReceipt(repayBiz);

        BudgetOrder condition = new BudgetOrder();
        condition.setRepayBizCode(repayBiz.getCode());
        List<BudgetOrder> budgetOrderList = budgetOrderAO
            .queryBudgetOrderList(condition);
        BudgetOrder budgetOrder = budgetOrderList.get(0);
        CollectBankcard bankcardCondition = new CollectBankcard();
        bankcardCondition.setCompanyCode(budgetOrder.getCompanyCode());
        List<CollectBankcard> queryCollectBankcardList = collectBankcardBO
            .queryCollectBankcardList(bankcardCondition);
        for (CollectBankcard collectBankcard : queryCollectBankcardList) {
            if (ECollectBankcardType.PLATFORM.getCode()
                .equals(collectBankcard.getType())) {// 公司的收款账号
                repayBiz.setJudgeReceiptBankcard(
                    collectBankcard.getBankcardNumber());// 收款账号
            }
        }

        // 日志记录
        ERepayBizNode node = ERepayBizNode.getMap()
            .get(repayBiz.getCurNodeCode());
        sysBizLogBO.saveNewAndPreEndSYSBizLog(req.getRepayBizCode(),
            EBizLogType.REPAY_BIZ, req.getRepayBizCode(), preCurNodeCode,
            node.getCode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void commitSettle(XN630570Req req) {
        RepayBiz data = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = data.getCurNodeCode();
        if (!ERepayBizNode.COMMIT_SETTLE.getCode().equals(data.getCurNodeCode())
                && !ERepayBizNode.TO_REPAY.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在结算单申请节点！");
        }

        data.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        data.setRefundBankSubbranch(req.getRefundBankSubbranch());
        data.setRefundBankRealName(req.getRefundBankRealName());

        data.setRefundBankcard(req.getRefundBankcard());
        data.setSecondCompanyInsurance(req.getSecondCompanyInsurance());
        data.setThirdCompanyInsurance(req.getThirdCompanyInsurance());
        data.setSettleAttach(req.getSettleAttach());
        data.setSettleDatetime(DateUtil.strToDate(req.getSettleDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setIsDepositReceipt(req.getIsDepositReceipt());
        if (EBoolean.YES.getCode().equals(req.getIsDepositReceipt())) {
            data.setDepositReceipt(req.getDepositReceipt());
        } else {
            data.setDepositReceiptLostProof(req.getDepositReceiptLostProof());
        }
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        String nextNodeCode = ERepayBizNode.SETTLE_RISK_MANAGER_CHECK.getCode();
        data.setCurNodeCode(nextNodeCode);
        repayBizBO.refreshCommitSettle(data);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.REPAY_BIZ, data.getCode(), preCurNodeCode, nextNodeCode,
            req.getRemark(), req.getOperator());
    }

    @Override
    @Transactional
    public void riskManagerCheck(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.SETTLE_RISK_MANAGER_CHECK.getCode()
            .equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在风控经理审核节点！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);
        repayBizBO.refreshRiskManagerCheck(code, nextNodeCode, note, operator);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
            nextNodeCode, note, operator);
    }

    @Override
    @Transactional
    public void riskManageAudit(XN630578Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.SETTLE_RISK_MANAGE_AUDIT.getCode()
            .equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在风控总监理审核节点，不能操作！");
        }
        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            req.getApproveResult());

        repayBizBO.riskManageAudit(req.getCode(), nextNodeCode,
            req.getApproveNote(), req.getOperator());

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
            nextNodeCode, req.getApproveNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void settleFinanceCheck(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.FINANCE_CHECK.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在财务审核节点！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);

        repayBizBO.refreshFinanceCheck(code, nextNodeCode, note, operator);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
            nextNodeCode, note, operator);
    }

    @Override
    @Transactional
    public void settleCashRemit(XN630572Req req) {
        RepayBiz data = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = data.getCurNodeCode();
        if (!ERepayBizNode.CASH_REMIT.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在确认付款节点！");
        }
        data.setSettlePayDatetime(DateUtil.strToDate(req.getSettlePayDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        BudgetOrder budgetOrder = budgetOrderBO
            .getBudgetOrder(data.getRefCode());
        CollectBankcard condition = new CollectBankcard();
        condition.setCompanyCode(budgetOrder.getCompanyCode());
        List<CollectBankcard> list = collectBankcardBO
            .queryCollectBankcardList(condition);
        for (CollectBankcard collectBankcard : list) {
            if (ECollectBankcardType.PLATFORM.getCode()
                .equals(collectBankcard.getType())) {
                data.setSettleBankcard(collectBankcard.getCode());
            }
        }
        data.setSettlePdf(req.getSettlePdf());

        data.setSettleNote(req.getSettleNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        String nextNodeCode = getNextNodeCode(data.getCurNodeCode(),
            EBoolean.YES.getCode());
        data.setCurNodeCode(nextNodeCode);

        // 业务结束
        data.setRestPeriods(0);
        data.setRestAmount(0L);
        data.setRestOverdueAmount(0L);

        repayBizBO.refreshCashRemit(data);

        // 还款业务结束，预算单改为已还款
        budgetOrder.setCurNodeCode(EBudgetOrderNode.REPAY_YES.getCode());
        budgetOrder.setIsEnd(EBoolean.YES.getCode());
        budgetOrderBO.updateBudgetOrderEnd(budgetOrder);

        // 还款计划的已还金额改为当月月供，剩余欠款改为0
        List<RepayPlan> repayPlans = repayPlanBO
            .queryRepayPlanListByRepayBizCode(req.getCode());
        for (RepayPlan repayPlan : repayPlans) {
            if (repayPlan.getCurPeriods() == 1) {// 首期
                repayPlan.setPayedAmount(data.getFirstRepayAmount());
            } else {
                repayPlan.setPayedAmount(data.getMonthAmount());
            }
            repayPlan.setOverplusAmount(0L);
            repayPlanBO.refreshRepayPlanPayedAmount(repayPlan);
        }

        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ, data.getCode(),
            preCurNodeCode, req.getSettleNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void settleReleaseMortgageApply(String code, String releaseApplyNote,
            String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.RELEASE_MORTGAGE_APPLY.getCode()
            .equals(preCurNodeCode)
                && !ERepayBizNode.TO_REPAY.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在解除抵押申请节点！");
        }
        if (EBoolean.YES.getCode().equals(repayBiz.getIsLogistics())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前还款业务在资料传递中，请先去资料传递！");
        }

        String nextNodeCode = ERepayBizNode.RISK_INDOOR_CHECK.getCode();

        // 如果客户未逾期过，即白名单，则不需要经过风控审核
        // 查这个人所有的还款业务，累计逾期期数相加
        RepayBiz data = new RepayBiz();
        data.setUserId(repayBiz.getUserId());
        List<RepayBiz> repayBizList = repayBizBO.queryRepayBizList(data);
        if (CollectionUtils.isNotEmpty(repayBizList)) {
            int i = 0;
            for (RepayBiz domain : repayBizList) {
                i += domain.getTotalOverdueCount();
            }
            if (i == 0) {
                // 生成资料传递
                logisticsBO.saveLogistics(ELogisticsType.REPAY_BIZ.getCode(),
                    code, operator, repayBiz.getCurNodeCode(),
                    ERepayBizNode.MORTGAGE_PRINT.getCode());
                // 产生物流单后改变状态为物流传递中
                repayBiz.setIsLogistics(EBoolean.YES.getCode());
                repayBizBO.updateIsLogistics(repayBiz);
                nextNodeCode = ERepayBizNode.RELEASE_MORTGAGE_APPLY.getCode();// 还款业务节点不变
                // 日志
                sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ,
                    repayBiz.getCode(), nextNodeCode, releaseApplyNote,
                    operator);
            } else {
                // 日志记录
                sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                    EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                    nextNodeCode, releaseApplyNote, operator);
            }
        }
        repayBizBO.refreshReleaseMortgageApply(code, nextNodeCode,
            releaseApplyNote, operator);
    }

    @Override
    @Transactional
    public void settleRiskIndoorCheck(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.RISK_INDOOR_CHECK.getCode().equals(preCurNodeCode)) {
            throw new BizException("xn0000", "还款业务不在风控内勤审核节点！");
        }

        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);
        repayBizBO.refreshRiskIndoorCheck(code, nextNodeCode, note, operator);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
            nextNodeCode, note, operator);
    }

    @Override
    @Transactional
    public void settleRiskManagerCheck(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.RISK_MANAGER_CHECK.getCode()
            .equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在风控经理审核节点，不能操作！");
        }
        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            approveResult);

        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        repayBizBO.refreshRiskManagerCheck(code, nextNodeCode, note, operator);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
            nextNodeCode, note, operator);
    }

    @Override
    @Transactional
    public void settleriskManageAudit(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.RISK_MANAGE_AUDIT.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在风控总监审核节点！");
        }
        if (EBoolean.YES.getCode().equals(repayBiz.getIsLogistics())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点处于物流传递中，不能操作");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }
        String nextNodeCode = null;
        if (EBoolean.NO.getCode().equals(approveResult)) {
            nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
                approveResult);
            repayBizBO.settleriskManageAudit(code, nextNodeCode, note,
                operator);
            // 日志记录
            sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                nextNodeCode, note, operator);
        } else {
            nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
                approveResult);
            // 生成资料传递
            logisticsBO.saveLogistics(ELogisticsType.REPAY_BIZ.getCode(), code,
                operator, repayBiz.getCurNodeCode(), nextNodeCode);
            // 产生物流单后改变状态为物流传递中
            repayBiz.setIsLogistics(EBoolean.YES.getCode());
            repayBizBO.updateIsLogistics(repayBiz);
            // 日志
            sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ,
                repayBiz.getCode(), preCurNodeCode, note, operator);
        }
    }

    @Override
    @Transactional
    public RepayBiz settleMortgagePrint(String code, String releaseDatetimeStr,
            String releaseTemplateId, String releaseNote, String operator) {
        RepayBiz repayBiz = getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.MORTGAGE_PRINT.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在打印岗打印节点！");
        }
        if (EBoolean.YES.getCode().equals(repayBiz.getIsLogistics())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点处于物流传递中，不能操作");
        }

        String nextNodeCode = getNextNodeCode(repayBiz.getCurNodeCode(),
            EBoolean.YES.getCode());

        Date releaseDatetime = DateUtil.strToDate(releaseDatetimeStr,
            DateUtil.FRONT_DATE_FORMAT_STRING);
        repayBizBO.refreshMortgagePrint(repayBiz, nextNodeCode, releaseDatetime,
            releaseTemplateId, releaseNote, operator);

        // 判断是否是银行驻点补件
        // 查补件单
        Logistics condition = new Logistics();
        condition.setBizCode(code);
        condition.setFromNodeCode(ERepayBizNode.MORTGAGE_PRINT.getCode());
        condition.setToNodeCode(ERepayBizNode.PHYSICAL_PARTS.getCode());
        condition.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
        List<Logistics> logisticsList = logisticsBO
            .queryLogisticsList(condition);
        if (CollectionUtils.isEmpty(logisticsList)) {
            // 生成资料传递
            logisticsBO.saveLogistics(ELogisticsType.REPAY_BIZ.getCode(), code,
                operator, repayBiz.getCurNodeCode(), nextNodeCode);
        }
        // 产生物流单后改变状态为物流传递中
        repayBiz.setIsLogistics(EBoolean.YES.getCode());
        repayBizBO.updateIsLogistics(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
            nextNodeCode, releaseNote, operator);
        return repayBiz;
    }

    @Override
    @Transactional
    public void settleMortgageCommitFile(String code, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.MORTGAGE_COMMIT_FILE.getCode()
            .equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在驻行人员提交材料节点！");
        }
        String nextNodeCode = getNextNodeCode(preCurNodeCode,
            EBoolean.YES.getCode());
        repayBiz.setCurNodeCode(nextNodeCode);
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.refreshMortgageCommit(repayBiz);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
            EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
            nextNodeCode, null, operator);
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

    @Override
    @Transactional
    public void physicalParts(List<String> codeList, String operator) {
        for (String code : codeList) {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
            if (!ERepayBizNode.PHYSICAL_PARTS.getCode()
                .equals(repayBiz.getCurNodeCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是理件岗理件节点，不能操作");
            }
            if (EBoolean.YES.getCode().equals(repayBiz.getIsLogistics())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点处于物流传递中，不能操作");
            }
        }
        for (String code : codeList) {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
            String preCurNodeCode = repayBiz.getCurNodeCode();
            // 生成资料传递
            NodeFlow nodeFlow = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurNodeCode);
            List<SupplementReason> supplementReason = supplementReasonBO
                .getSupplementReasonByLogisticsCode(code);
            String loCode = logisticsBO.saveLogistics(
                ELogisticsType.REPAY_BIZ.getCode(), code, operator,
                repayBiz.getCurNodeCode(), nodeFlow.getNextNode());
            // 传递补件原因
            if (CollectionUtils.isNotEmpty(supplementReason)) {
                for (SupplementReason reason : supplementReason) {
                    supplementReasonBO.refreshLogisticsCode(reason.getId(),
                        loCode);
                }
            }
            // 产生物流单后改变状态为物流传递中
            repayBiz.setIsLogistics(EBoolean.YES.getCode());
            repayBizBO.updateIsLogistics(repayBiz);

            // 日志记录
            sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                nodeFlow.getNextNode(), null, operator);
        }

    }

    @Override
    @Transactional
    public void financialAudit(String code, String approveResult,
            String approveNote, String operator, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String curNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.REDEEM_FINANCIAL_AUDIT.getCode().equals(curNodeCode)
                && !ERepayBizNode.SELLED_FINANCIAL_AUDIT.getCode()
                    .equals(curNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在财务审核节点！");
        }
        // 当前节点
        String nextNodeCode = null;
        RepayPlan repayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            repayBiz.getCode(), ERepayPlanNode.HANDLER_TO_RED);

        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }

        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            if (ERepayBizNode.REDEEM_FINANCIAL_AUDIT.getCode()
                .equals(curNodeCode)) {
                if (repayPlan.getCurPeriods() == repayPlan.getPeriods()) {// 最后一期
                    BudgetOrder budgetOrder = budgetOrderBO
                        .getBudgetOrderByRepayBizCode(repayBiz.getRefCode());
                    // 判断是否抵押过
                    if (EBudgetOrderNode.LOCAL_PLEDGE_ACHIEVE.getCode()
                        .equals(budgetOrder.getPledgeCurNodeCode())
                            || EBudgetOrderNode.OUT_PLEDGE_ACHIEVE.getCode()
                                .equals(budgetOrder.getPledgeCurNodeCode())) {
                        nextNodeCode = ERepayBizNode.RELEASE_MORTGAGE_APPLY
                            .getCode();
                    } else {
                        nextNodeCode = ERepayBizNode.COMMIT_SETTLE.getCode();
                    }
                    // 还款计划处理为已还款
                    repayPlanBO.refreshRepayPlanTakeCarHandle(
                        repayPlan.getRepayBizCode(), ERepayPlanNode.REPAY_YES);
                } else {
                    nextNodeCode = ERepayBizNode.TO_REPAY.getCode();
                    // 还款计划处理为继续还款中
                    repayPlanBO.repaySuccess(repayPlan,
                        repayPlan.getRepayAmount());
                    sysBizLogBO.refreshPreSYSBizLog(
                        EBizLogType.ABNORMAL_REPAY_BIZ, repayBiz.getCode(),
                        curNodeCode, note, operator);
                }
            } else {
                nextNodeCode = ERepayBizNode.JUDGE_BAD.getCode();

                // 还款计划处理为坏账
                repayPlanBO.refreshRepayPlanTakeCarHandle(repayBiz.getCode(),
                    ERepayPlanNode.BAD_DEBT);

                sysBizLogBO.refreshPreSYSBizLog(EBizLogType.ABNORMAL_REPAY_BIZ,
                    repayBiz.getCode(), curNodeCode, note, operator);

                // 预算单改为结束
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrderByRepayBizCode(code);
                budgetOrder.setIsEnd(EBoolean.YES.getCode());
                budgetOrderBO.updateBudgetOrderEnd(budgetOrder);

            }
        } else {
            nextNodeCode = ERepayBizNode.TC_RESULT_INPUT.getCode();
        }

        repayBizBO.refreshFinanceCheck(code, nextNodeCode, approveNote,
            operator);
        if (!ERepayBizNode.JUDGE_BAD.getCode().equals(nextNodeCode)
                && !ERepayBizNode.TO_REPAY.getCode().equals(nextNodeCode)) {
            // 日志记录
            sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), curNodeCode,
                nextNodeCode, note, operator);
        }
    }

    @Override
    public Object unclearedLoanTotalAmount() {
        List<RepayBiz> repayBizList = repayBizBO
            .queryRepayBizList(new RepayBiz());
        Long unclearedLoanTotalAmount = 0L;
        for (RepayBiz repayBiz : repayBizList) {
            unclearedLoanTotalAmount += repayBiz.getRestAmount();
        }
        XN630907Res res = new XN630907Res();
        res.setUnclearedLoanTotalAmount(
            String.valueOf(unclearedLoanTotalAmount));
        return res;
    }

    @Override
    @Transactional
    public void clearanceCashier(String code, String paymentBank,
            String paymentPdf, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String curNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.CLEARANCE_CASHIER.getCode().equals(curNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "还款业务不在公司结清出纳打款节点，不能操作！");
        }
        // 当前节点
        repayBiz.setCurNodeCode(
            nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode).getNextNode());
        repayBiz.setPaymentBank(paymentBank);
        repayBiz.setPaymentPdf(paymentPdf);
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.clearanceCashier(repayBiz);

        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.ABNORMAL_REPAY_BIZ,
            repayBiz.getCode(), curNodeCode, null, operator);
    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition) {
        Paginable<RepayBiz> results = repayBizBO.getPaginable(start, limit,
            condition);
        for (RepayBiz repayBiz : results.getList()) {
            initRepayBiz(repayBiz);
        }
        return results;
    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPageByRoleCode(int start, int limit,
            RepayBiz condition) {
        Paginable<RepayBiz> paginable = repayBizBO.getPaginableByRoleCode(start,
            limit, condition);
        for (RepayBiz repayBiz : paginable.getList()) {
            // initRepayBiz(repayBiz);先注释掉，查询太慢，缺字段的时候再补
        }
        return paginable;
    }

    @Override
    public Object queryRepayBizByTotalOverdueCount(int start, int limit,
            RepayBiz condition, String curOverdueCount) {
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        if (curOverdueCount == null) {
            curOverdueCount = "1-100";
        }
        String[] split = curOverdueCount.split(",");// 用逗号分割
        for (String string : split) {
            // 判断是否只输入了一个数或一个区间
            if (string.equals(curOverdueCount)) {
                String[] strings = string.split("-");
                for (String string2 : strings) {
                    // 判断是否只输入了一个区间
                    if (string2.equals(curOverdueCount)) {
                        arrayList.add(string);
                    } else {
                        list.add(string2);
                    }
                }
                if (CollectionUtils.isNotEmpty(list)) {
                    int x = Integer.parseInt(list.get(0));
                    int y = Integer.parseInt(list.get(1));
                    if (x <= y) {
                        for (int i = x; i <= y; i++) {
                            arrayList.add(i + "");
                        }
                    } else {
                        for (int i = y; i <= x; i++) {
                            arrayList.add(i + "");
                        }
                    }
                }
            } else {
                String[] strings = string.split("-");
                for (String data : strings) {
                    if (string.equals(data)) {
                        arrayList.add(data);
                    } else {
                        list.add(data);
                    }
                }
                if (CollectionUtils.isNotEmpty(list)) {
                    if (list.size() > 2) {
                        int a = Integer.parseInt(list.get(0));
                        int b = Integer.parseInt(list.get(1));
                        int c = Integer.parseInt(list.get(2));
                        int d = Integer.parseInt(list.get(3));
                        if (a <= b) {
                            for (int i = a; i <= b; i++) {
                                arrayList.add(i + "");
                            }
                        } else {
                            for (int i = b; i <= a; i++) {
                                arrayList.add(i + "");
                            }
                        }
                        if (c <= d) {
                            for (int i = c; i <= d; i++) {
                                arrayList.add(i + "");
                            }
                        } else {
                            for (int i = d; i <= c; i++) {
                                arrayList.add(i + "");
                            }
                        }

                    } else {
                        int x = Integer.parseInt(list.get(0));
                        int y = Integer.parseInt(list.get(1));
                        for (int i = x; i <= y; i++) {
                            arrayList.add(i + "");
                        }
                    }
                }
            }
        }
        if (curOverdueCount.equals("0")) {
            return null;
        }
        condition.setCurOverdueCountList(arrayList);
        Paginable<RepayBiz> paginable = repayBizBO
            .getPaginableByTotalOverdueCount(start, limit, condition);
        for (RepayBiz repayBiz : paginable.getList()) {
            initRepayBiz(repayBiz);
        }
        return paginable;
    }

    @Override
    public Object queryRepayBizByOverdue(int start, int limit,
            RepayBiz condition) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 1; i <= 36; i++) {
            arrayList.add(i + "");
        }
        condition.setCurOverdueCountList(arrayList);
        Paginable<RepayBiz> paginable = repayBizBO
            .getPaginableByTotalOverdueCount(start, limit, condition);
        for (RepayBiz repayBiz : paginable.getList()) {
            initRepayBiz(repayBiz);
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
        initRepayBiz(repayBiz);
        return repayBiz;
    }

    private void initRepayBiz(RepayBiz repayBiz) {
        // 申请人信息
        repayBiz.setUser(userBO.getUser(repayBiz.getUserId()));

        // 还款计划信息
        RepayPlan condition = new RepayPlan();
        condition.setOrder("cur_periods", true);
        condition.setRepayBizCode(repayBiz.getCode());
        List<RepayPlan> repayPlanList = repayPlanBO
            .queryRepayPlanList(condition);
        repayBiz.setRepayPlanList(repayPlanList);
        Long actualRefunds = 0L;
        for (RepayPlan repayPlan : repayPlanList) {
            if (repayPlan.getDeposit() != null) {
                actualRefunds += repayPlan.getDeposit();
            }
        }
        repayBiz.setActualRefunds(actualRefunds + repayBiz.getLyDeposit());
        RepayPlan repayPlan = repayPlanBO
            .getRepayPlanCurMonth(repayBiz.getCode());
        repayBiz.setCurMonthRepayPlan(repayPlan);

        // 预算单信息
        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
            repayBiz.setBudgetOrder(
                budgetOrderAO.getBudgetOrder(repayBiz.getRefCode()));
        } else {
            repayBiz.setMallOrder(orderAO.getOrder(repayBiz.getRefCode()));
        }

        // 业务公司
        if (StringUtils.isNotBlank(repayBiz.getCompanyCode())) {
            Department department = departmentBO
                .getDepartment(repayBiz.getCompanyCode());
            repayBiz.setCompanyName(department.getName());
        }

        // 司法诉讼
        Judge judge = judgeBO.getJudgeByRepaybizCode(repayBiz.getCode());
        repayBiz.setJudge(judge);

        RepayPlan overdueRepayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
            repayBiz.getCode(), ERepayPlanNode.HANDLER_TO_RED);
        repayBiz.setOverdueRepayPlan(overdueRepayPlan);

        if (StringUtils.isNotBlank(repayBiz.getUpdater())) {
            SYSUser updater = sysUserBO.getUser(repayBiz.getUpdater());
            repayBiz.setUpdaterName(updater.getRealName());
        }

        if (StringUtils.isNotBlank(repayBiz.getLoanBank())) {
            BankSubbranch bankSubbranch = bankSubbranchBO
                .getBankSubbranch(repayBiz.getLoanBank());
            repayBiz.setLoanBankName(bankSubbranch.getFullName());
        }

        // 最新收车时间
        List<RepayPlan> planList = repayPlanBO
            .queryRepayPlanListByRepayBizCode(repayBiz.getCode());
        Integer newestTakeDate = 0;
        Date newestTakeDatetime = new Date();
        for (RepayPlan domain : planList) {
            if (domain.getTakeDatetime() != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                String takeDatetime = dateFormat
                    .format(domain.getTakeDatetime());
                Integer take = Integer.parseInt(takeDatetime);
                if (take > newestTakeDate) {
                    newestTakeDate = take;
                    newestTakeDatetime = domain.getTakeDatetime();
                }
            }
        }

        if (StringUtils.isNotBlank(repayBiz.getBankcardCode())) {
            Bankcard bankcard = bankcardBO
                .getBankcard(repayBiz.getBankcardCode());
            repayBiz.setBankcardNumber(bankcard.getBankcardNumber());
        }

        if (newestTakeDatetime != null) {
            repayBiz.setNewestTakeDatetime(newestTakeDatetime);
        }
    }

}
