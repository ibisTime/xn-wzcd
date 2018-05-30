package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;

//dao层 
public interface IBudgetOrderFeeDetailDAO extends IBaseDAO<BudgetOrderFeeDetail> {
	String NAMESPACE = IBudgetOrderFeeDetailDAO.class.getName().concat(".");
}