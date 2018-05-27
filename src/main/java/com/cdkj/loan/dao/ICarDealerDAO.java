package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarDealer;

//dao层 
public interface ICarDealerDAO extends IBaseDAO<CarDealer> {
    String NAMESPACE = ICarDealerDAO.class.getName().concat(".");

    int update(CarDealer data);

    int updateNode(CarDealer data);
}
