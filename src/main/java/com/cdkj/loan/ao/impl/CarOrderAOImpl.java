package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.bo.ICarOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarOrder;
import com.cdkj.loan.dto.req.XN630430Req;
import com.cdkj.loan.enums.ECarOrderStatus;

public class CarOrderAOImpl implements ICarOrderAO {

    @Autowired
    private ICarOrderBO carOrderBO;

    @Override
    public String addCarOrder(XN630430Req req) {
        CarOrder carOrder = new CarOrder();
        carOrder.setUserId(req.getUserId());
        return carOrderBO.saveCarOrder(carOrder);
    }

    @Override
    public void editCarOrder(String code, String handler, String remark) {
        CarOrder carOrder = carOrderBO.getCarOrder(code);
        carOrder.setStatus(ECarOrderStatus.YCL.getCode());
        carOrder.setHandler(handler);
        carOrder.setHandleDatetime(new Date());
        carOrder.setRemark(remark);
        carOrderBO.editCarOrder(carOrder);
    }

    @Override
    public Paginable<CarOrder> queryCarPage(int start, int limit,
            CarOrder condition) {
        return carOrderBO.getPaginable(start, limit, condition);
    }

    @Override
    public CarOrder getCarOrder(String code) {
        return carOrderBO.getCarOrder(code);
    }

    @Override
    public List<CarOrder> queryCarOrderList(CarOrder condition) {
        return carOrderBO.queryCarOrder(condition);
    }

}
