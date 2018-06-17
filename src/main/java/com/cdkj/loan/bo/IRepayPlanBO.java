package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630550Req;
import com.cdkj.loan.dto.req.XN630556Req;
import com.cdkj.loan.dto.req.XN630557Req;
import com.cdkj.loan.enums.ERepayPlanNode;

public interface IRepayPlanBO extends IPaginableBO<RepayPlan> {

    public boolean checkRepayComplete(String repayBizCode, String repayPlanCode);

    public boolean checkPreUnpay(String repayBizCode, int curPeriod);

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public RepayPlan getRepayPlanCurMonth(String repayBizCode);

    public List<RepayPlan> queryRepayPlanListByRepayBizCode(String repayBizCode);

    public RepayPlan getRepayPlanListByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode);

    public RepayPlan getRepayPlanByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode);

    public RepayPlan getRepayPlan(String code);

    // 产生还款计划
    public void genereateNewRepayPlan(RepayBiz repayBiz);

    // 支付成功更新
    public void repaySuccess(RepayPlan repayPlan, Long realWithholdAmount);

    // 进入逾期
    public void refreshRepayPlanOverdue(RepayPlan repayPlan);

    // 逾期后更新
    public void refreshOverdueHandle(RepayPlan repayPlan);

    // 进入绿名单
    public void refreshToGreen(RepayPlan repayPlan);

    // 产品进入黑名单
    public void refreshToBlackProduct(RepayPlan repayPlan);

    // 部分支付方法
    public void repayPartSuccess(RepayPlan repayPlan, Long realWithholdAmount);

    // 缴纳清收成本
    public void payFee(RepayPlan repayPlan);

    // 缴纳代偿金额
    public void repayAmount(RepayPlan repayPlan);

    // 拖车申请
    public void takeCarApply(RepayPlan data, XN630550Req req);

    // 确认放款
    public void takeCarSureFk(RepayPlan data, String remitBankCode,
            String remitBillPdf, Date remitDatetime, String operator);

    // 录入拖车结果
    public void takeCarInputResult(RepayPlan data, XN630556Req req);

    // 结果处理
    public void takeCarResultHandle(RepayPlan data, XN630557Req req);

    public Paginable<RepayPlan> getPaginableByRoleCode(int start, int limit,
            RepayPlan condition);

    public int getTotalCount(String repayPlanCode, ERepayPlanNode repayPlanNode);
}
