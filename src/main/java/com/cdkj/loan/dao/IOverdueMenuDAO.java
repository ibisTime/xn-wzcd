package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.OverdueMenu;

//dao层 
public interface IOverdueMenuDAO extends IBaseDAO<OverdueMenu> {
    String NAMESPACE = IOverdueMenuDAO.class.getName().concat(".");

    int update(OverdueMenu data);
}
