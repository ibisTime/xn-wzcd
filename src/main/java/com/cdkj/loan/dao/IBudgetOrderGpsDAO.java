package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BudgetOrderGps;

//dao层 
public interface IBudgetOrderGpsDAO extends IBaseDAO<BudgetOrderGps> {
    String NAMESPACE = IBudgetOrderGpsDAO.class.getName().concat(".");

    int update(BudgetOrderGps data);
}
