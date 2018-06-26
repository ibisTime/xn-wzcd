package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IReplaceRepayPlanAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IReplaceRepayApplyBO;
import com.cdkj.loan.bo.IReplaceRepayPlanBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.ReplaceRepayApply;
import com.cdkj.loan.domain.ReplaceRepayPlan;
import com.cdkj.loan.domain.SYSUser;
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

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

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
            EReplaceRepayPlanNode.RISK_MANAGE_APPROVE.getCode());
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
        if (!EReplaceRepayPlanNode.RISK_MANAGE_APPROVE.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在风控经理审核状态，无法审核！");
        }

        String nextNodeCode = getNextNodeCode(replaceRepayPlan.getCurNodeCode(),
            approveResult);

        replaceRepayPlanBO.updateRiskManageApprove(code, nextNodeCode, riskNote,
            remark, operator);
    }

    @Override
    public void approveBySubcomp(String code, String approveResult,
            String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.SUBCOMP_APPROVE.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在分公司审核状态，无法审核！");
        }

        String nextNodeCode = getNextNodeCode(replaceRepayPlan.getCurNodeCode(),
            approveResult);

        replaceRepayPlanBO.updateSubcompApprove(code, nextNodeCode, remark,
            operator);
    }

    @Override
    public void approveByRiskChief(String code, String approveResult,
            String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.RISK_CHIEF_APPROVE.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在风控总监审核状态，无法审核！");
        }

        String nextNodeCode = getNextNodeCode(replaceRepayPlan.getCurNodeCode(),
            approveResult);

        replaceRepayPlanBO.updateRiskChiefApprove(code, nextNodeCode, remark,
            operator);
    }

    @Override
    public void approveByFianace(String code, String approveResult,
            String remark, String operator) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(code);
        if (!EReplaceRepayPlanNode.FINANCE_APPROVE.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在财务审核状态，无法审核！");
        }

        String nextNodeCode = getNextNodeCode(replaceRepayPlan.getCurNodeCode(),
            approveResult);

        replaceRepayPlanBO.updateFianaceApprove(code, nextNodeCode, remark,
            operator);
    }

    @Override
    public void updateConfirmLoan(XN632335Req req) {
        ReplaceRepayPlan replaceRepayPlan = replaceRepayPlanBO
            .getReplaceRepayPlan(req.getCode());
        if (!EReplaceRepayPlanNode.CONFIRM_LOAN.getCode()
            .equals(replaceRepayPlan.getCurNodeCode())) {
            throw new BizException("xn0000", "代偿记录不在确认放款状态，无法审核！");
        }
        String nextNodeCode = getNextNodeCode(replaceRepayPlan.getCurNodeCode(),
            EBoolean.YES.getCode());

        ReplaceRepayPlan data = new ReplaceRepayPlan();
        data.setCode(req.getCode());
        data.setCurNodeCode(nextNodeCode);
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
        Paginable<ReplaceRepayPlan> page = replaceRepayPlanBO
            .getPaginable(start, limit, condition);
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
        init(replaceRepayPlan);
        return replaceRepayPlan;
    }

    private void init(ReplaceRepayPlan replaceRepayPlan) {
        Bank bank = bankBO.getBankBySubbranch(replaceRepayPlan.getRepayBank());
        if (null != bank) {
            replaceRepayPlan.setRepayBankName(bank.getBankName());
        }

        SYSUser user = sysUserBO.getUser(replaceRepayPlan.getRepayUser());
        if (null != user) {
            replaceRepayPlan.setRepayUserName(user.getRealName());
        }

        user = sysUserBO.getUser(replaceRepayPlan.getCustomerUserId());
        if (null != user) {
            replaceRepayPlan.setCustomerUserName(user.getRealName());
        }

        user = sysUserBO.getUser(replaceRepayPlan.getUpdater());
        if (null != user) {
            replaceRepayPlan.setUpdaterName(user.getRealName());
        }

        if (StringUtils.isNotBlank(replaceRepayPlan.getBizCode())) {
            RepayPlan repayPlan = repayPlanBO
                .getRepayPlan(replaceRepayPlan.getBizCode());
            replaceRepayPlan.setRepayPlan(repayPlan);
        }
    }

}
