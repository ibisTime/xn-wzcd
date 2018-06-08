package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.DayRest;

//dao层 
public interface IDayRestDAO extends IBaseDAO<DayRest> {
    String NAMESPACE = IDayRestDAO.class.getName().concat(".");

    public void insertDayRestList(List<DayRest> dayRestList);
}
