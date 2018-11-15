package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CityList;

//dao层 
public interface ICityListDAO extends IBaseDAO<CityList> {
	String NAMESPACE = ICityListDAO.class.getName().concat(".");
}