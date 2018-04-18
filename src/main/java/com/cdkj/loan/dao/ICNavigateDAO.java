package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CNavigate;

public interface ICNavigateDAO extends IBaseDAO<CNavigate> {
    String NAMESPACE = ICNavigateDAO.class.getName().concat(".");

    public int update(CNavigate data);

}
