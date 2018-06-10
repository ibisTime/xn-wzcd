package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;

public interface IRepayPlanBO extends IPaginableBO<RepayPlan> {

    public boolean checkRepayComplete(String repayBizCode);

    public boolean checkPreUnpay(String repayBizCode, int curPeriod);

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public RepayPlan getRepayPlanLast(RepayPlan condition);

    public List<RepayPlan> queryRepayPlanListByRepayBizCode(String repayBizCode);

    public RepayPlan getRepayPlan(String code);

    // 产生还款计划
    public void genereateNewRapayPlan(RepayBiz repayBiz);

    // 支付成功更新
    public void repaySuccess(RepayPlan repayPlan, Long realWithholdAmount);

    // 逾期更新
    public void refreshRepayPlanOverdue(RepayPlan repayPlan);

    // 进入绿名单
    public void refreshToGreen(RepayPlan repayPlan);

    // 产品进入黑名单
    public void refreshToBlackProduct(RepayPlan repayPlan);

    // 部分支付方法
    public void repayPartSuccess(RepayPlan repayPlan, Long realWithholdAmount);

    // 拖车申请
    public void applyTrailer(RepayPlan repayPlan);

    // 财务打款
    public void financialMoney(RepayPlan repayPlan);

    // 清款催收部拖车录入
    public void trailerEntry(RepayPlan repayPlan);

    // 司法诉讼结果录入
    public void judicialLitigationEntry(RepayPlan repayPlan);

    // 清款催收部申请赎回
    public void qkcsbRedeemApply(RepayPlan repayPlan);

    // 财务主管审核
    public void financeApprove(RepayPlan repayPlan);

    public void refreshRepayPlanCurNodeCode(RepayPlan data);
}
