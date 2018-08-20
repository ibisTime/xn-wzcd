package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SysBonuses;

//dao层 
public interface ISysBonusesDAO extends IBaseDAO<SysBonuses> {
    String NAMESPACE = ISysBonusesDAO.class.getName().concat(".");

    void update(SysBonuses data);
}
