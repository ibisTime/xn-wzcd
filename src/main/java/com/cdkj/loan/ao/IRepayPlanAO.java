package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630532Req;
import com.cdkj.loan.dto.req.XN630537Req;

public interface IRepayPlanAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
            RepayPlan condition);

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public RepayPlan getRepayPlan(String code);

    public Paginable<RepayPlan> queryRepayPlanPageByRoleCode(int start,
            int limit, RepayPlan condition);

    // 当月还款名单
    public Object queryCurrentMonthRepayPage(int start, int limit,
            RepayPlan condition);

    // 逾期处理
    public void overdueHandle(XN630532Req req);

    // 缴纳清收成本
    public void payFee(String code, List<String> costList, String payType,
            String operator);

    // 记黑名单
    public void doMakeBlack(String code);

    // 未结清贷款审核
    public Long getUnsettledLoan();

    // 缴纳代偿金额
    public void repayAmount(String code, String operator, String payType,
            Long payAmount);

    // 每天凌晨定时更新还款计划状态为已结清
    public void doPayedDaily();

    // 催收过程
    public void collectionProcess(XN630537Req req);

}
