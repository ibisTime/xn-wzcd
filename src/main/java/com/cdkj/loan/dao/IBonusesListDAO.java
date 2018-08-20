package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BonusesList;

//dao层 
public interface IBonusesListDAO extends IBaseDAO<BonusesList> {
	String NAMESPACE = IBonusesListDAO.class.getName().concat(".");
}