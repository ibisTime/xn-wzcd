package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.OverdueRepay;

//dao层 
public interface IOverdueRepayDAO extends IBaseDAO<OverdueRepay> {
	String NAMESPACE = IOverdueRepayDAO.class.getName().concat(".");
}