package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.OverdueRecord;

//dao层 
public interface IOverdueRecordDAO extends IBaseDAO<OverdueRecord> {
	String NAMESPACE = IOverdueRecordDAO.class.getName().concat(".");
}