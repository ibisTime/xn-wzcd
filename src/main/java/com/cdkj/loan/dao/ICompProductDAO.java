package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CompProduct;

//dao层 
public interface ICompProductDAO extends IBaseDAO<CompProduct> {
    String NAMESPACE = ICompProductDAO.class.getName().concat(".");

    public void update(CompProduct data);
}
