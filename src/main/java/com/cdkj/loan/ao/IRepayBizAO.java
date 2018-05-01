package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;



public interface IRepayBizAO {
	static final String DEFAULT_ORDER_COLUMN = "code";


	public String addRepayBiz(RepayBiz data);

	public int dropRepayBiz(String code);

	public int editRepayBiz(RepayBiz data);

	public Paginable<RepayBiz> queryRepayBizPage(int start, int limit, RepayBiz condition);

	public List<RepayBiz> queryRepayBizList(RepayBiz condition);

	public RepayBiz getRepayBiz(String code);

}