package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Car;

public interface ICarDAO extends IBaseDAO<Car> {
    String NAMESPACE = ICarDAO.class.getName().concat(".");

    public int update(Car data);

    public int updateUp(Car data);

    public int updateDown(Car data);
}
