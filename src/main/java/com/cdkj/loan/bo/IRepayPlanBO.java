package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;

public interface IRepayPlanBO extends IPaginableBO<RepayPlan> {

    public boolean isRepayPlanExist(String code);

    public String saveRepayPlan(RepayPlan data);

    public int removeRepayPlan(String code);

    public int refreshRepayPlan(RepayPlan data);

    public int refreshRepayPlanStatus(RepayPlan data);

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public List<RepayPlan> queryRepayPlanListByRepayBizCode(
            String repayBizCode);

    public RepayPlan getRepayPlan(String code);

    public void genereateNewRapayPlan(RepayBiz repayBiz);

    public void repaySuccess(RepayPlan repayPlan, Long realWithholdAmount);

    public boolean checkRepayComplete(String repayBizCode);

    public boolean checkPreUnpay(String repayBizCode, int curPeriod);

    public int refreshRepayPlanOverdue(RepayPlan repayPlan);

    public int refreshToGreen(RepayPlan repayPlan);

    public int refreshToBlack(RepayPlan repayPlan);

    public void repayPartSuccess(RepayPlan repayPlan, Long realWithholdAmount);

}
