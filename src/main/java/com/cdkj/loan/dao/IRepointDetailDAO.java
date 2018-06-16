package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepointDetail;

//dao层 
public interface IRepointDetailDAO extends IBaseDAO<RepointDetail> {
    String NAMESPACE = IRepointDetailDAO.class.getName().concat(".");

    int update(RepointDetail data);
}
