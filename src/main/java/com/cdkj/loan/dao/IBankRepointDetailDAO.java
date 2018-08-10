package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BankRepointDetail;

//dao层 
public interface IBankRepointDetailDAO extends IBaseDAO<BankRepointDetail> {
    String NAMESPACE = IBankRepointDetailDAO.class.getName().concat(".");

    int update(BankRepointDetail data);
}
