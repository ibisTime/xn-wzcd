package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.TotalAdvanceFund;

//dao层 
public interface ITotalAdvanceFundDAO extends IBaseDAO<TotalAdvanceFund> {
    String NAMESPACE = ITotalAdvanceFundDAO.class.getName().concat(".");

    int update(TotalAdvanceFund data);
}
