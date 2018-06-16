package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IReplaceRepayPlanAO;
import com.cdkj.loan.bo.IReplaceRepayApplyBO;
import com.cdkj.loan.bo.IReplaceRepayPlanBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.domain.ReplaceRepayPlan;
import com.cdkj.loan.dto.req.XN632330Req;
import com.cdkj.loan.dto.req.XN632335Req;
import com.cdkj.loan.enums.EBoolean;
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

    @Override
    public String addReplaceRepayPlan(XN632330Req req) {
        ReplaceRepayPlan data = new ReplaceRepayPlan();
        ReplaceRepayApply replaceRepayApply = replaceRepayApplyBO
            .getReplaceRepayApply(req.getReplaceApplyCode());
        if (null != replaceRepayApply) {
            data.setType(replaceRepayApply.getType());
            data.setCustomerUserId(replaceRepayApply.getApplyUser());
        }

        data.setCurNodeCode(
            EReplaceRepayPlanNode.TO_RISK_MANAGE_APPROVE.getCode());
        data.setReplaceApplyCode(req.getReplaceApplyCode());
        data.setBizCode(req.getBizCode());
        data.setIsPlatIssue(req.getIsPlatIssue());
        data.setTakeWay(req.getTakeWay());
        data.setDeferDays(StringValidater.toInteger(req.getDeferDays()));

        data.setApplyReason(req.getApplyReason());
        data.setApplyReasonNote(req.getApplyReasonNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());
        return replaceRepayPlanBO.saveReplaceRepayPlan(data);
    }

    @Override
    public void approveByRiskManage(String code, String approveResult,
            String riskNote, String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.TO_RISK_MANAGE_APPROVE.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在风控经理审核状态，无法审核！");
        }

        String curNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            curNodeCode = EReplaceRepayPlanNode.RISK_MANAGE_APPROVE_YES
                .getCode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            curNodeCode = EReplaceRepayPlanNode.RISK_MANAGE_APPROVE_NO
                .getCode();
        }

        replaceRepayPlanBO.updateRiskManageApprove(code, curNodeCode, riskNote,
            remark, operator);
    }

    @Override
    public void approveBySubcomp(String code, String approveResult,
            String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.RISK_MANAGE_APPROVE_YES.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在分公司审核状态，无法审核！");
        }

        String curNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            curNodeCode = EReplaceRepayPlanNode.SUBCOMP_APPROVE_YES.getCode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            curNodeCode = EReplaceRepayPlanNode.SUBCOMP_APPROVE_NO.getCode();
        }

        replaceRepayPlanBO.updateSubcompApprove(code, curNodeCode, remark,
            operator);
    }

    @Override
    public void approveByRiskChief(String code, String approveResult,
            String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.SUBCOMP_APPROVE_YES.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在风控总监审核状态，无法审核！");
        }

        String curNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            curNodeCode = EReplaceRepayPlanNode.RISK_CHIEF_APPROVE_YES
                .getCode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            curNodeCode = EReplaceRepayPlanNode.RISK_CHIEF_APPROVE_NO.getCode();
        }

        replaceRepayPlanBO.updateRiskChiefApprove(code, curNodeCode, remark,
            operator);
    }

    @Override
    public void approveByFianace(String code, String approveResult,
            String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.RISK_CHIEF_APPROVE_YES.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在财务审核状态，无法审核！");
        }

        String curNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            curNodeCode = EReplaceRepayPlanNode.FINANCE_APPROVE_YES.getCode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            curNodeCode = EReplaceRepayPlanNode.FINANCE_APPROVE_NO.getCode();
        }

        replaceRepayPlanBO.updateFianaceApprove(code, curNodeCode, remark,
            operator);
    }

    @Override
    public void updateConfirmLoan(XN632335Req req) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(req.getCode());
        if (!EReplaceRepayPlanNode.FINANCE_APPROVE_YES.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在确认放款状态，无法审核！");
        }

        ReplaceRepayPlan data = new ReplaceRepayPlan();
        data.setCode(req.getCode());
        data.setCurNodeCode(EReplaceRepayPlanNode.DONE.getCode());
        data.setRepayBank(req.getRepayBank());
        data.setRepayDate(DateUtil.strToDate(req.getRepayDate(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setRepayBankcard(req.getRepayBankcard());
        data.setRepayRate(StringValidater.toLong(req.getRepayRate()));
        data.setRepayUser(req.getRepayUser());
        data.setRepayBill(req.getRepayBill());
        data.setRepayNote(req.getRepayNote());
        data.setUpdater(req.getOperator());
        data.setUpdateDatetime(new Date());

        replaceRepayPlanBO.updateConfirmLoan(data);
    }

    @Override
    public Paginable<ReplaceRepayPlan> queryReplaceRepayPlanPage(int start,
            int limit, ReplaceRepayPlan condition) {
        return replaceRepayPlanBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ReplaceRepayPlan> queryReplaceRepayPlanList(
            ReplaceRepayPlan condition) {
        return replaceRepayPlanBO.queryReplaceRepayPlanList(condition);
    }

    @Override
    public ReplaceRepayPlan getReplaceRepayPlan(String code) {
        return replaceRepayPlanBO.getReplaceRepayPlan(code);
    }

}
