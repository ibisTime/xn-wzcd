package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarOrder;
import com.cdkj.loan.dto.req.XN630430Req;
import com.cdkj.loan.dto.req.XN630431Req;

public interface ICarOrderAO {
    String DEFAULT_ORDER_COLUMN = "code";

    // 申请
    public String addCarOrder(XN630430Req req);

    // 处理
    public void editCarOrder(String code,String handler,String remark);

    // 分页查询
    public Paginable<CarOrder> queryCarPage(int start, int limit,
            CarOrder condition);

    // 详情查询
    public CarOrder getCarOrder(String code);

    // 列表查询
    public List<CarOrder> queryCarOrderList(CarOrder condition);

}
