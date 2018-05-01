package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.exception.BizException;




@Service
public class RepayBizAOImpl implements IRepayBizAO {

	@Autowired
	private IRepayBizBO repayBizBO;

	@Override
	public String addRepayBiz(RepayBiz data) {
		return repayBizBO.saveRepayBiz(data);
	}

	@Override
	public int editRepayBiz(RepayBiz data) {
		if (!repayBizBO.isRepayBizExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return repayBizBO.refreshRepayBiz(data);
	}

	@Override
	public int dropRepayBiz(String code) {
		if (!repayBizBO.isRepayBizExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return repayBizBO.removeRepayBiz(code);
	}

	@Override
	public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
			RepayBiz condition) {
		return repayBizBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
		return repayBizBO.queryRepayBizList(condition);
	}

	@Override
	public RepayBiz getRepayBiz(String code) {
		return repayBizBO.getRepayBiz(code);
	}
}