package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.GpsSupplier;

//dao层 
public interface IGpsSupplierDAO extends IBaseDAO<GpsSupplier> {
    String NAMESPACE = IGpsSupplierDAO.class.getName().concat(".");

    void update(GpsSupplier data);
}
