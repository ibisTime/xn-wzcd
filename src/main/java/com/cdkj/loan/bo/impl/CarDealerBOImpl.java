package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarDealerBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ICarDealerDAO;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class CarDealerBOImpl extends PaginableBOImpl<CarDealer>
        implements ICarDealerBO {

    @Autowired
    private ICarDealerDAO carDealerDAO;

    public String saveCarDealer(CarDealer data) {
        String code = null;
        if (data != null) {

            carDealerDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCarDealer(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CarDealer data = new CarDealer();
            data.setCode(code);
            count = carDealerDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCarDealer(CarDealer data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = carDealerDAO.update(data);
        }
        return count;
    }

    @Override
    public int refreshCarDealerNode(CarDealer data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = carDealerDAO.updateNode(data);
        }
        return count;
    }

    @Override
    public List<CarDealer> queryCarDealerList(CarDealer condition) {
        return carDealerDAO.selectList(condition);
    }

    @Override
    public CarDealer getCarDealer(String code) {
        CarDealer data = null;
        if (StringUtils.isNotBlank(code)) {
            CarDealer condition = new CarDealer();
            condition.setCode(code);
            data = carDealerDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "经销商不存在！");
            }
        }
        return data;
    }

}
