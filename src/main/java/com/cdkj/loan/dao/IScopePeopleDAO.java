package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ScopePeople;

//dao层 
public interface IScopePeopleDAO extends IBaseDAO<ScopePeople> {
    String NAMESPACE = IScopePeopleDAO.class.getName().concat(".");

    public void insertScopePeopleList(List<ScopePeople> dataList);

}
