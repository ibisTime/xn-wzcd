package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.dto.req.XN630420Req;
import com.cdkj.loan.dto.req.XN630422Req;
import com.cdkj.loan.dto.req.XN630428Req;

public interface ICarAO {
    String DEFAULT_ORDER_COLUMN = "code";

    // 新增品牌
    public void addCar(XN630420Req req);

    // 修改品牌
    public void editCar(XN630422Req req);

    // 上架品牌
    public void upCar(String code, String location, String orderNo,
            String updater, String remark);

    // 下架品牌
    public void downCar(String code, String updater, String remark);

    // 分页查询
    public Paginable<Car> queryCarPage(int start, int limit, Car condition);

    // 详情查询
    public Car getCar(String code);

    // 列表查询
    public List<Car> queryCarList(Car condition);

    // 车型刷新
    public void refreshCar(XN630428Req req);

}
