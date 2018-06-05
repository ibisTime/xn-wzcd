package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Contract;

//dao层 
public interface IContractDAO extends IBaseDAO<Contract> {
    String NAMESPACE = IContractDAO.class.getName().concat(".");

    int update(Contract data);
}
