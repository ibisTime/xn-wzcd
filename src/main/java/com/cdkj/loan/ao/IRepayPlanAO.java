package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayPlan;

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

}
