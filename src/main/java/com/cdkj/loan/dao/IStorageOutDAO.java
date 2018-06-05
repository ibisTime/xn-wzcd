package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.StorageOut;

//dao层 
public interface IStorageOutDAO extends IBaseDAO<StorageOut> {
	String NAMESPACE = IStorageOutDAO.class.getName().concat(".");
}