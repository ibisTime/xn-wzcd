package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarBreak;

//dao层 
public interface ICarBreakDAO extends IBaseDAO<CarBreak> {
    String NAMESPACE = ICarBreakDAO.class.getName().concat(".");

    public void update(CarBreak data);

}
