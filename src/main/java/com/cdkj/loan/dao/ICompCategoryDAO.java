package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CompCategory;

//dao层 
public interface ICompCategoryDAO extends IBaseDAO<CompCategory> {
    String NAMESPACE = ICompCategoryDAO.class.getName().concat(".");

    public void update(CompCategory data);
}
