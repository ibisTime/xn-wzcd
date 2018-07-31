package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.dto.req.XN632060ReqProtocol;

@Component
public interface ICarDealerProtocolAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public int addCarDealerProtocol(XN632060ReqProtocol req);

    public Paginable<CarDealerProtocol> queryCarDealerProtocolPage(int start,
            int limit, CarDealerProtocol condition);

    public List<CarDealerProtocol> queryCarDealerProtocolList(
            CarDealerProtocol condition);

    public CarDealerProtocol getCarDealerProtocol(int id);
}
