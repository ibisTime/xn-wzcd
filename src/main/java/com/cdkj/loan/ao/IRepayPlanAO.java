package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630532Req;

public interface IRepayPlanAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRepayPlan(RepayPlan data);

    public int dropRepayPlan(String code);

    public int editRepayPlan(RepayPlan data);

    public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
            RepayPlan condition);

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public RepayPlan getRepayPlan(String code);

    // 按月还款
    public void repayMonthly(String code);

    // 当月还款名单
    public Object dyRepayment(int start, int limit, RepayPlan condition);

    // 逾期处理
    public void OverdueHandle(XN630532Req req);

    // 记绿名单
    public void ToGreen(String code, String overdueDeposit);

    // 记黑名单
    public void ToBlack(String code);

}
