package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.LoanOrder;



public interface ILoanOrderAO {
	static final String DEFAULT_ORDER_COLUMN = "code";


	public String addLoanOrder(LoanOrder data);

	public int dropLoanOrder(String code);

	public int editLoanOrder(LoanOrder data);

	public Paginable<LoanOrder> queryLoanOrderPage(int start, int limit, LoanOrder condition);

	public List<LoanOrder> queryLoanOrderList(LoanOrder condition);

	public LoanOrder getLoanOrder(String code);

}