package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;

/**
 * 
 * @author: jiafr 
 * @since: 2018年5月25日 下午1:46:20 
 * @history:
 */
public interface ICreditUserDAO extends IBaseDAO<Department> {

    String NAMESPACE = ICreditUserDAO.class.getName().concat(".");

    public void insertCreditUserList(List<CreditUser> list);

}
