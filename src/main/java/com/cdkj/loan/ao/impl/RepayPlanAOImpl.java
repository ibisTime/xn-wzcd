package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.exception.BizException;




@Service
public class RepayPlanAOImpl implements IRepayPlanAO {

	@Autowired
	private IRepayPlanBO repayPlanBO;

	@Override
	public String addRepayPlan(RepayPlan data) {
		return repayPlanBO.saveRepayPlan(data);
	}

	@Override
	public int editRepayPlan(RepayPlan data) {
		if (!repayPlanBO.isRepayPlanExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return repayPlanBO.refreshRepayPlan(data);
	}

	@Override
	public int dropRepayPlan(String code) {
		if (!repayPlanBO.isRepayPlanExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return repayPlanBO.removeRepayPlan(code);
	}

	@Override
	public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
			RepayPlan condition) {
		return repayPlanBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<RepayPlan> queryRepayPlanList(RepayPlan condition) {
		return repayPlanBO.queryRepayPlanList(condition);
	}

	@Override
	public RepayPlan getRepayPlan(String code) {
		return repayPlanBO.getRepayPlan(code);
	}
}