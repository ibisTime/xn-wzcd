package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.InsuranceCompany;

//dao层 
public interface IInsuranceCompanyDAO extends IBaseDAO<InsuranceCompany> {
    String NAMESPACE = IInsuranceCompanyDAO.class.getName().concat(".");

    int update(InsuranceCompany data);
}
