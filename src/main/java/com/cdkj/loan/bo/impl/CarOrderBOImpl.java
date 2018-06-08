package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarOrderBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarOrderDAO;
import com.cdkj.loan.domain.CarOrder;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class CarOrderBOImpl extends PaginableBOImpl<CarOrder>
        implements ICarOrderBO {

    @Autowired
    private ICarOrderDAO carOrderDAO;

    @Override
    public long getTotalCount(CarOrder condition) {
        return carOrderDAO.selectTotalCount(condition);
    }

    @Override
    public String saveCarOrder(CarOrder data) {
        String code = null;
        if (data != null) {
            if (data.getCode() == null) {
                code = OrderNoGenerater
                    .generate(EGeneratePrefix.Car_Order.getCode());
                data.setCode(code);
            }
            carOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public int editCarOrder(CarOrder data) {

        return carOrderDAO.update(data);
    }

    @Override
    public CarOrder getCarOrder(String code) {
        CarOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            CarOrder condition = new CarOrder();
            condition.setCode(code);
            data = carOrderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "汽车订单不存在");
            }
        }
        return data;
    }

    @Override
    public List<CarOrder> queryCarOrder(CarOrder condition) {

        return carOrderDAO.selectList(condition);
    }

}
