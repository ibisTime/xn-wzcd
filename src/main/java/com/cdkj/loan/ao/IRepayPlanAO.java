package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630532Req;

public interface IRepayPlanAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
            RepayPlan condition);

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public RepayPlan getRepayPlan(String code);

    public Paginable<RepayPlan> queryRepayPlanPageByRoleCode(int start,
            int limit, RepayPlan condition);

    // 按月还款
    public void repayMonthly(String code, String operator);

    // 当月还款名单
    public Object queryCurrentMonthRepayPage(int start, int limit,
            RepayPlan condition);

    // 逾期处理
    public void overdueHandle(XN630532Req req);

    // 记黑名单
    public void ToBlack(String code);

    public Long getUnsettledLoan();

}
