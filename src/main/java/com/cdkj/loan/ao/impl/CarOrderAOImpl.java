package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICarOrderBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.CarOrder;
import com.cdkj.loan.domain.SYSConfig;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN630430Req;
import com.cdkj.loan.enums.ECarOrderStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class CarOrderAOImpl implements ICarOrderAO {

    @Autowired
    private ICarOrderBO carOrderBO;

    @Autowired
    private ICarBO carBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Override
    public String addCarOrder(XN630430Req req) {
        CarOrder carOrder = new CarOrder();
        carOrder.setUserId(req.getUserId());
        carOrder.setUserMobile(req.getUserMobile());
        carOrder.setBrandCode(req.getBrandCode());
        carOrder.setBrandName(req.getBrandName());
        carOrder.setSeriesCode(req.getSeriesCode());
        carOrder.setSeriesName(req.getSeriesName());
        carOrder.setCarCode(req.getCarCode());
        carOrder.setCarName(req.getCarName());
        carOrder.setPrice(StringValidater.toLong(req.getPrice()));
        carOrder.setSfRate(StringValidater.toDouble(req.getSfRate()));
        carOrder.setSfAmount(StringValidater.toLong(req.getSfAmount()));
        carOrder.setPeriods(StringValidater.toInteger(req.getPeriods()));
        carOrder.setCreateDatetime(new Date());
        carOrder.setSaleDesc(req.getSaleDesc());
        carOrder.setStatus(ECarOrderStatus.DCL.getCode());
        carOrder.setRemark(req.getRemark());
        return carOrderBO.saveCarOrder(carOrder);
    }

    @Override
    public void editCarOrder(String code, String result, String handler,
            String remark) {
        CarOrder carOrder = carOrderBO.getCarOrder(code);
        if (ECarOrderStatus.DCL.getCode().equals(carOrder.getStatus())) {
            if (result.equals("0")) {
                carOrder.setStatus(ECarOrderStatus.YCL.getCode());
            } else {
                carOrder.setStatus(ECarOrderStatus.YZF.getCode());
            }
            carOrder.setHandler(handler);
            carOrder.setHandleDatetime(new Date());
            carOrder.setRemark(remark);
            carOrderBO.editCarOrder(carOrder);
        } else {
            throw new BizException("mag", "该申请已被处理，请重新选择");
        }

    }

    @Override
    public Paginable<CarOrder> queryCarPage(int start, int limit,
            CarOrder condition) {
        Paginable<CarOrder> results = carOrderBO.getPaginable(start, limit,
            condition);
        List<CarOrder> list = results.getList();
        for (CarOrder carOrder : list) {
            Car car = carBO.getCar(carOrder.getCarCode());
            carOrder.setCar(car);
            User user = userBO.getUser(carOrder.getUserId());
            carOrder.setUser(user);
            if (carOrder.getPeriods() != null) {
                SYSConfig config = sysConfigBO.getSYSConfig("car_periods",
                    carOrder.getPeriods());
                carOrder.setRate(StringValidater.toDouble(config.getCvalue()));
            }
        }
        return results;
    }

    @Override
    public CarOrder getCarOrder(String code) {
        CarOrder carOrder = carOrderBO.getCarOrder(code);
        Car car = carBO.getCar(carOrder.getCarCode());
        carOrder.setCar(car);
        User user = userBO.getUser(carOrder.getUserId());
        carOrder.setUser(user);
        return carOrder;
    }

    @Override
    public List<CarOrder> queryCarOrderList(CarOrder condition) {
        List<CarOrder> carOrderList = carOrderBO.queryCarOrder(condition);
        for (CarOrder carOrder : carOrderList) {
            Car car = carBO.getCar(carOrder.getCarCode());
            carOrder.setCar(car);
            User user = userBO.getUser(carOrder.getUserId());
            carOrder.setUser(user);
        }
        return carOrderList;
    }

}
