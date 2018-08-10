package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BankRepoint;

//dao层 
public interface IBankRepointDAO extends IBaseDAO<BankRepoint> {
    String NAMESPACE = IBankRepointDAO.class.getName().concat(".");

    int update(BankRepoint data);
}
