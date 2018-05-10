package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.User;

public interface IUserDAO extends IBaseDAO<User> {

    String NAMESPACE = IUserDAO.class.getName().concat(".");

}
