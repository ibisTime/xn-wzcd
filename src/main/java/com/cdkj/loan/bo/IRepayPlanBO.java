package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RepayPlan;



public interface IRepayPlanBO extends IPaginableBO<RepayPlan> {


	public boolean isRepayPlanExist(String code);


	public String saveRepayPlan(RepayPlan data);


	public int removeRepayPlan(String code);


	public int refreshRepayPlan(RepayPlan data);


	public List<RepayPlan> queryRepayPlanList(RepayPlan condition);


	public RepayPlan getRepayPlan(String code);


}