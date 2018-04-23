package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CUser;

public interface ICUserDAO extends IBaseDAO<CUser> {
    String NAMESPACE = ICUserDAO.class.getName().concat(".");

}
