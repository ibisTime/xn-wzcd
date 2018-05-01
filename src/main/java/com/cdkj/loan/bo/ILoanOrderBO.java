package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.LoanOrder;



public interface ILoanOrderBO extends IPaginableBO<LoanOrder> {


	public boolean isLoanOrderExist(String code);


	public String saveLoanOrder(LoanOrder data);


	public int removeLoanOrder(String code);


	public int refreshLoanOrder(LoanOrder data);


	public List<LoanOrder> queryLoanOrderList(LoanOrder condition);


	public LoanOrder getLoanOrder(String code);


}