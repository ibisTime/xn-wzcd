package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.ReplaceRepayPlan;
import com.cdkj.loan.dto.req.XN632330Req;
import com.cdkj.loan.dto.req.XN632335Req;

/**
 * 代偿审核
 * @author: silver 
 * @since: 2018年6月15日 下午7:15:15 
 * @history:
 */
@Component
public interface IReplaceRepayPlanAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addReplaceRepayPlan(XN632330Req req);

    // 风控经理审核
    public void approveByRiskManage(String code, String approveResult,
            String riskNote, String remark, String operator);

    // 分公司总经理审核
    public void approveBySubcomp(String code, String approveResult,
            String remark, String operator);

    // 风控总监审核
    public void approveByRiskChief(String code, String approveResult,
            String remark, String operator);

    // 财务经理审核
    public void approveByFianace(String code, String approveResult,
            String remark, String operator);

    // 确认放款
    public void updateConfirmLoan(XN632335Req req);

    public Paginable<ReplaceRepayPlan> queryReplaceRepayPlanPage(int start,
            int limit, ReplaceRepayPlan condition);

    public Paginable<ReplaceRepayPlan> queryReplaceRepayPlanPageByRoleCode(
            int start, int limit, ReplaceRepayPlan condition);

    public List<ReplaceRepayPlan> queryReplaceRepayPlanList(
            ReplaceRepayPlan condition);

    public ReplaceRepayPlan getReplaceRepayPlan(String code);

}
