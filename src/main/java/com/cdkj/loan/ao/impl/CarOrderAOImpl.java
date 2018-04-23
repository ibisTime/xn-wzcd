package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.bo.ICarOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarOrder;
import com.cdkj.loan.dto.req.XN630422Req;
import com.cdkj.loan.dto.req.XN630430Req;

public class CarOrderAOImpl implements ICarOrderAO {

    @Autowired
    private ICarOrderBO carOrderBO;

    @Override
    public String addCarOrder(XN630430Req req) {
        CarOrder carOrder = new CarOrder();
        carOrder.setUserId(req.getUserId());
        return null;
    }

    @Override
    public void editCarOrder(XN630422Req req) {
        // TODO Auto-generated method stub

    }

    @Override
    public Paginable<CarOrder> queryCarPage(int start, int limit,
            CarOrder condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CarOrder getCarOrder(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CarOrder> queryCarOrderList(CarOrder condition) {
        // TODO Auto-generated method stub
        return null;
    }

}
