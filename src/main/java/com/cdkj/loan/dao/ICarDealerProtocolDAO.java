package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarDealerProtocol;

//dao层 
public interface ICarDealerProtocolDAO extends IBaseDAO<CarDealerProtocol> {
    String NAMESPACE = ICarDealerProtocolDAO.class.getName().concat(".");

    int update(CarDealerProtocol data);
}
