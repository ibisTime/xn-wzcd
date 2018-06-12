package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Cost;

public interface ICostDAO extends IBaseDAO<Cost> {
    String NAMESPACE = ICostDAO.class.getName().concat(".");

    public int updateRepay(Cost data);

}
