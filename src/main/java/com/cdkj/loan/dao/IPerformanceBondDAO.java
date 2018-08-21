package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.PerformanceBond;

//dao层 
public interface IPerformanceBondDAO extends IBaseDAO<PerformanceBond> {
    String NAMESPACE = IPerformanceBondDAO.class.getName().concat(".");

    void update(PerformanceBond data);
}
