package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BasicValuation;

//dao层 
public interface IBasicValuationDAO extends IBaseDAO<BasicValuation> {
	String NAMESPACE = IBasicValuationDAO.class.getName().concat(".");
}