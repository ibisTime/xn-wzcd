package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.enums.ERepayPlanNode;

public interface IRepayPlanBO extends IPaginableBO<RepayPlan> {

    public boolean checkRepayComplete(String repayBizCode, String repayPlanCode);

    public boolean checkPreUnpay(String repayBizCode, int curPeriod);

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public RepayPlan getRepayPlanCurMonth(String repayBizCode);

    public List<RepayPlan> queryRepayPlanListByRepayBizCode(String repayBizCode);

    public RepayPlan getRepayPlanListByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode);

    public RepayPlan getRepayPlan(String code);

    // 产生还款计划
    public void genereateNewRapayPlan(RepayBiz repayBiz);

    // 支付成功更新
    public void repaySuccess(RepayPlan repayPlan, Long realWithholdAmount);

    // 进入逾期
    public void refreshRepayPlanOverdue(RepayPlan repayPlan);

    // 逾期后更新
    public void refreshRepayPlanOverdueHandle(RepayPlan repayPlan);

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

    public void riskManagerCheck(RepayPlan repayPlan);

    public Paginable<RepayPlan> getPaginableByRoleCode(int start, int limit,
            RepayPlan condition);

    public void refreshRepayPlanCurNodeCode(RepayPlan repayPlan);

    // 财务经理审核
    public void financeApprove(RepayPlan repayPlan);

    public int getTotalCount(String repayPlanCode, ERepayPlanNode repayPlanNode);
}
