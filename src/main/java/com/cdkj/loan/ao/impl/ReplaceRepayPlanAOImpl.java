package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.ao.IReplaceRepayPlanAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IReplaceRepayApplyBO;
import com.cdkj.loan.bo.IReplaceRepayPlanBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSDictBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.domain.ReplaceRepayPlan;
import com.cdkj.loan.domain.SYSDict;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN632330Req;
import com.cdkj.loan.dto.req.XN632335Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECollectBankcardType;
import com.cdkj.loan.enums.EReplaceRepayPlanNode;
import com.cdkj.loan.exception.BizException;

/**
 * 代偿审核
 * @author: silver 
 * @since: 2018年6月15日 下午7:18:36 
 * @history:
 */
@Service
public class ReplaceRepayPlanAOImpl implements IReplaceRepayPlanAO {
    @Autowired
    private IReplaceRepayPlanBO replaceRepayPlanBO;

    @Autowired
    private IReplaceRepayApplyBO replaceRepayApplyBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IBudgetOrderAO budgetOrderAO;

    @Autowired
    private ISYSDictBO sysDictBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    public String addReplaceRepayPlan(XN632330Req req) {
        ReplaceRepayPlan data = new ReplaceRepayPlan();
        ReplaceRepayApply replaceRepayApply = replaceRepayApplyBO
            .getReplaceRepayApply(req.getReplaceApplyCode());
        if (null != replaceRepayApply) {
            data.setType(replaceRepayApply.getType());
            RepayBiz repayBiz = repayBizBO.getRepayBiz(replaceRepayApply
                .getBizCode());
            data.setCustomerUserId(repayBiz.getUserId());
        }

        data.setCurNodeCode(EReplaceRepayPlanNode.RISK_MANAGE_APPROVE.getCode());
        data.setReplaceApplyCode(req.getReplaceApplyCode());
        data.setBizCode(req.getBizCode());
        data.setIsPlatIssue(req.getIsPlatIssue());
        data.setTakeWay(req.getTakeWay());
        data.setDeferDays(StringValidater.toInteger(req.getDeferDays()));

        data.setApplyReason(req.getApplyReason());
        data.setApplyReasonNote(req.getApplyReasonNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        String code = replaceRepayPlanBO.saveReplaceRepayPlan(data);

        sysBizLogBO.recordCurrentSYSBizLog(data.getBizCode(),
            EBizLogType.REPLACE_REPAY_PLAN, code,
            EReplaceRepayPlanNode.DC_APPLY.getCode(), req.getApplyReasonNote(),
            req.getOperator());
        sysBizLogBO.saveSYSBizLog(data.getBizCode(),
            EBizLogType.REPLACE_REPAY_PLAN, code,
            EReplaceRepayPlanNode.RISK_MANAGE_APPROVE.getCode());

        return code;
    }

    @Override
    public void approveByRiskManage(String code, String approveResult,
            String riskNote, String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.RISK_MANAGE_APPROVE.getCode().equals(
            replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在风控经理审核状态，无法审核！");
        }

        String nextNodeCode = getNextNodeCode(
            replaceRepayPlan.getCurNodeCode(), approveResult);

        replaceRepayPlanBO.updateRiskManageApprove(code, nextNodeCode,
            riskNote, remark, operator);

        sysBizLogBO
            .saveNewAndPreEndSYSBizLog(replaceRepayPlan.getBizCode(),
                EBizLogType.REPLACE_REPAY_PLAN, replaceRepayPlan.getCode(),
                replaceRepayPlan.getCurNodeCode(), nextNodeCode, riskNote,
                operator);
    }

    @Override
    public void approveBySubcomp(String code, String approveResult,
            String approveNote, String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.SUBCOMP_APPROVE.getCode().equals(
            replaceRepayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "代偿记录不在分公司审核状态，无法审核！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }
        String nextNodeCode = getNextNodeCode(
            replaceRepayPlan.getCurNodeCode(), approveResult);

        replaceRepayPlanBO.updateSubcompApprove(code, nextNodeCode, note,
            operator);

        sysBizLogBO.saveNewAndPreEndSYSBizLog(replaceRepayPlan.getBizCode(),
            EBizLogType.REPLACE_REPAY_PLAN, replaceRepayPlan.getCode(),
            replaceRepayPlan.getCurNodeCode(), nextNodeCode, approveNote,
            operator);
    }

    @Override
    public void approveByRiskChief(String code, String approveResult,
            String approveNote, String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.RISK_CHIEF_APPROVE.getCode().equals(
            replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在风控总监审核状态，无法审核！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }
        String nextNodeCode = getNextNodeCode(
            replaceRepayPlan.getCurNodeCode(), approveResult);

        replaceRepayPlanBO.updateRiskChiefApprove(code, nextNodeCode, note,
            operator);

        sysBizLogBO.saveNewAndPreEndSYSBizLog(replaceRepayPlan.getBizCode(),
            EBizLogType.REPLACE_REPAY_PLAN, replaceRepayPlan.getCode(),
            replaceRepayPlan.getCurNodeCode(), nextNodeCode, approveNote,
            operator);
    }

    @Override
    public void approveByFianace(String code, String approveResult,
            String approveNote, String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.FINANCE_APPROVE.getCode().equals(
            replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在财务审核状态，无法审核！");
        }
        // 审核说明
        SYSDict dict = sysDictBO.getSYSDictBykey("approve_note", approveNote);
        String note = dict.getDvalue();
        if ("99".equals(approveNote)) {
            note = remark;
        }
        String nextNodeCode = getNextNodeCode(
            replaceRepayPlan.getCurNodeCode(), approveResult);

        replaceRepayPlanBO.updateFianaceApprove(code, nextNodeCode, note,
            operator);

        sysBizLogBO.saveNewAndPreEndSYSBizLog(replaceRepayPlan.getBizCode(),
            EBizLogType.REPLACE_REPAY_PLAN, replaceRepayPlan.getCode(),
            replaceRepayPlan.getCurNodeCode(), nextNodeCode, approveNote,
            operator);
    }

    @Override
    public void updateConfirmLoan(XN632335Req req) {
        ReplaceRepayPlan data = replaceRepayPlanBO.getReplaceRepayPlan(req
            .getCode());
        if (!EReplaceRepayPlanNode.CONFIRM_LOAN.getCode().equals(
            data.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在确认放款状态，无法审核！");
        }
        String nextNodeCode = getNextNodeCode(data.getCurNodeCode(),
            EBoolean.YES.getCode());

        data.setCurNodeCode(nextNodeCode);
        data.setRepayDate(DateUtil.strToDate(req.getRepayDate(),
            DateUtil.DATA_TIME_PATTERN_1));
        RepayPlan repayPlan = repayPlanBO.getRepayPlan(data.getBizCode());
        RepayBiz repayBiz = repayBizBO.getRepayBiz(repayPlan.getRepayBizCode());
        BudgetOrder budgetOrder = budgetOrderAO.getBudgetOrder(repayBiz
            .getRefCode());
        CollectBankcard condition = new CollectBankcard();
        condition.setCompanyCode(budgetOrder.getCompanyCode());
        List<CollectBankcard> list = collectBankcardBO
            .queryCollectBankcardList(condition);
        for (CollectBankcard collectBankcard : list) {
            if (ECollectBankcardType.PLATFORM.getCode().equals(
                collectBankcard.getType())) {
                data.setRepayBankcard(collectBankcard.getCode());
            }
        }
        data.setRepayRate(StringValidater.toDouble(req.getRepayRate()));
        data.setRepayUser(req.getRepayUser());
        data.setRepayBill(req.getRepayBill());
        data.setRepayNote(req.getRepayNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());

        replaceRepayPlanBO.updateConfirmLoan(data);

        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPLACE_REPAY_PLAN,
            data.getCode(), data.getCurNodeCode(), req.getRepayNote(),
            req.getOperator());
    }

    // 获取下一个节点
    public String getNextNodeCode(String curNodeCode, String approveResult) {
        NodeFlow nodeFolw = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        String nextNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            nextNodeCode = nodeFolw.getNextNode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            nextNodeCode = nodeFolw.getBackNode();
        }
        return nextNodeCode;
    }

    @Override
    public Paginable<ReplaceRepayPlan> queryReplaceRepayPlanPage(int start,
            int limit, ReplaceRepayPlan condition) {
        Paginable<ReplaceRepayPlan> page = replaceRepayPlanBO.getPaginable(
            start, limit, condition);
        List<ReplaceRepayPlan> list = page.getList();
        for (ReplaceRepayPlan replaceRepayPlan : list) {
            init(replaceRepayPlan);
        }
        return page;
    }

    @Override
    public Paginable<ReplaceRepayPlan> queryReplaceRepayPlanPageByRoleCode(
            int start, int limit, ReplaceRepayPlan condition) {
        Paginable<ReplaceRepayPlan> page = replaceRepayPlanBO
            .getPaginableByRoleCode(start, limit, condition);
        List<ReplaceRepayPlan> list = page.getList();
        for (ReplaceRepayPlan replaceRepayPlan : list) {
            init(replaceRepayPlan);
        }
        return page;
    }

    @Override
    public List<ReplaceRepayPlan> queryReplaceRepayPlanList(
            ReplaceRepayPlan condition) {
        List<ReplaceRepayPlan> list = replaceRepayPlanBO
            .queryReplaceRepayPlanList(condition);
        for (ReplaceRepayPlan replaceRepayPlan : list) {
            init(replaceRepayPlan);
        }
        return list;
    }

    @Override
    public ReplaceRepayPlan getReplaceRepayPlan(String code) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        // 获取预算单
        if (StringUtils.isNotBlank(replaceRepayPlan.getBizCode())) {
            RepayPlan repayPlan = repayPlanBO.getRepayPlan(replaceRepayPlan
                .getBizCode());
            RepayBiz repayBiz = repayBizBO.getRepayBiz(repayPlan
                .getRepayBizCode());
            BudgetOrder budgetOrder = budgetOrderAO
                .getBudgetOrderByRepayBizCode(repayBiz.getCode());
            replaceRepayPlan.setBudgetOrder(budgetOrder);
        }
        init(replaceRepayPlan);
        return replaceRepayPlan;
    }

    private void init(ReplaceRepayPlan replaceRepayPlan) {

        if (StringUtils.isNotBlank(replaceRepayPlan.getCustomerUserId())) {
            User user = userBO.getUser(replaceRepayPlan.getCustomerUserId());
            replaceRepayPlan.setCustomerUserName(user.getRealName());
        }

        if (StringUtils.isNotBlank(replaceRepayPlan.getUpdater())) {
            SYSUser user = sysUserBO.getUser(replaceRepayPlan.getUpdater());
            replaceRepayPlan.setUpdaterName(user.getRealName());
        }

        if (StringUtils.isNotBlank(replaceRepayPlan.getBizCode())) {
            RepayPlan repayPlan = repayPlanBO.getRepayPlan(replaceRepayPlan
                .getBizCode());
            replaceRepayPlan.setRepayPlan(repayPlan);
            RepayBiz repayBiz = repayBizBO.getRepayBiz(repayPlan
                .getRepayBizCode());
            replaceRepayPlan.setIdNo(repayBiz.getIdNo());
        }
        if (StringUtils.isNotBlank(replaceRepayPlan.getReplaceApplyCode())) {
            ReplaceRepayApply replaceRepayApply = replaceRepayApplyBO
                .getReplaceRepayApply(replaceRepayPlan.getReplaceApplyCode());
            replaceRepayPlan.setReplaceRepayApply(replaceRepayApply);
        }
    }

}
