package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CreditChangeRecord;

//dao层 
public interface ICreditChangeRecordDAO extends IBaseDAO<CreditChangeRecord> {
	String NAMESPACE = ICreditChangeRecordDAO.class.getName().concat(".");
}