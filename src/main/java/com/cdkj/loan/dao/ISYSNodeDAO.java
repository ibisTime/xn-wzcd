package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SYSNode;

//dao层 
public interface ISYSNodeDAO extends IBaseDAO<SYSNode> {
	String NAMESPACE = ISYSNodeDAO.class.getName().concat(".");
}