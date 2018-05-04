package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Bankcard;

//dao层 
public interface IBankcardDAO extends IBaseDAO<Bankcard> {
    String NAMESPACE = IBankcardDAO.class.getName().concat(".");

    public int update(Bankcard data);
}
