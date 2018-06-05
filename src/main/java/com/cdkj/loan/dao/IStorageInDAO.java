package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.StorageIn;

//dao层 
public interface IStorageInDAO extends IBaseDAO<StorageIn> {
    String NAMESPACE = IStorageInDAO.class.getName().concat(".");

    public void update(StorageIn data);

}
