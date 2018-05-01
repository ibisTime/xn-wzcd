package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Cost;



public interface ICostAO {
	static final String DEFAULT_ORDER_COLUMN = "code";


	public String addCost(Cost data);

	public int dropCost(String code);

	public int editCost(Cost data);

	public Paginable<Cost> queryCostPage(int start, int limit, Cost condition);

	public List<Cost> queryCostList(Cost condition);

	public Cost getCost(String code);

}