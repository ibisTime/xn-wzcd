package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarOrder;

public interface ICarOrderBO extends IPaginableBO<CarOrder> {

    public String saveCarOrder(CarOrder data);

    public CarOrder getCarOrder(String code);

    public int editCarOrder(CarOrder data);

    public List<CarOrder> queryCarOrder(CarOrder condition);
}
