package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.AssertUser;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:57:19 
 * @history:
 */
public interface IAssertUserDAO extends IBaseDAO<AssertUser> {
    String NAMESPACE = IAssertUserDAO.class.getName().concat(".");

    public int update(AssertUser data);
}
