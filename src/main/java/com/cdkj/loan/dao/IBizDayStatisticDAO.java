package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BizDayStatistic;

//dao层 
public interface IBizDayStatisticDAO extends IBaseDAO<BizDayStatistic> {
    String NAMESPACE = IBizDayStatisticDAO.class.getName().concat(".");

    int update(BizDayStatistic data);
}
