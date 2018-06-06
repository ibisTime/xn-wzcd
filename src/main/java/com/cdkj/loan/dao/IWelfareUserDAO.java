package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.WelfareUser;

//dao层 
public interface IWelfareUserDAO extends IBaseDAO<WelfareUser> {
	String NAMESPACE = IWelfareUserDAO.class.getName().concat(".");
}