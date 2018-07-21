package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Repoint;

//dao层 
public interface IRepointDAO extends IBaseDAO<Repoint> {
    String NAMESPACE = IRepointDAO.class.getName().concat(".");

    void update(Repoint data);

    void confirmLoan(Repoint data);
}
