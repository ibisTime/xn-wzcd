package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;



//CHECK ��鲢��ע�� 
public interface IBudgetOrderFeeDetailBO extends IPaginableBO<BudgetOrderFeeDetail> {


	public boolean isBudgetOrderFeeDetailExist(String code);


	public String saveBudgetOrderFeeDetail(BudgetOrderFeeDetail data);


	public int removeBudgetOrderFeeDetail(String code);


	public int refreshBudgetOrderFeeDetail(BudgetOrderFeeDetail data);


	public List<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailList(BudgetOrderFeeDetail condition);


	public BudgetOrderFeeDetail getBudgetOrderFeeDetail(String code);


}