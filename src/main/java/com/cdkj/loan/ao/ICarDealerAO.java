package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.dto.req.XN632060Req;
import com.cdkj.loan.dto.req.XN632062Req;

@Component
public interface ICarDealerAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCarDealer(XN632060Req req);

    public int dropCarDealer(String code);

    public void editCarDealer(XN632062Req req);

    public Paginable<CarDealer> queryCarDealerPage(int start, int limit,
            CarDealer condition);

    public List<CarDealer> queryCarDealerList(CarDealer condition);

    public CarDealer getCarDealer(String code);

    public void audit(String code, String auditResult, String auditor,
            String approveNote);

}
