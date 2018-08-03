package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.OverdueTreatment;

//dao层 
public interface IOverdueTreatmentDAO extends IBaseDAO<OverdueTreatment> {
	String NAMESPACE = IOverdueTreatmentDAO.class.getName().concat(".");
}