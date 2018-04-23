package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarOrder;

public interface ICarOrderDAO extends IBaseDAO<CarOrder> {
    String NAMESPACE = ICarOrderDAO.class.getName().concat(".");

    public int update(CarOrder data);
}
