package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrderFee;



//CHECK ��鲢��ע�� 
public interface IBudgetOrderFeeBO extends IPaginableBO<BudgetOrderFee> {


	public boolean isBudgetOrderFeeExist(String code);


	public String saveBudgetOrderFee(BudgetOrderFee data);


	public int removeBudgetOrderFee(String code);


	public int refreshBudgetOrderFee(BudgetOrderFee data);


	public List<BudgetOrderFee> queryBudgetOrderFeeList(BudgetOrderFee condition);


	public BudgetOrderFee getBudgetOrderFee(String code);


}