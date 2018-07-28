package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarDealer;

public interface ICarDealerBO extends IPaginableBO<CarDealer> {

    public String saveCarDealer(CarDealer data);

    public int removeCarDealer(String code);

    public int refreshCarDealer(CarDealer data);

    public List<CarDealer> queryCarDealerList(CarDealer condition);

    public CarDealer getCarDealer(String code);

    // 更新节点（ 包括审核说明）
    public int refreshCarDealerNode(CarDealer data);

}
