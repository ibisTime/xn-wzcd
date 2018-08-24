package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CompanyClearance;

//dao层 
public interface ICompanyClearanceDAO extends IBaseDAO<CompanyClearance> {
	String NAMESPACE = ICompanyClearanceDAO.class.getName().concat(".");
}