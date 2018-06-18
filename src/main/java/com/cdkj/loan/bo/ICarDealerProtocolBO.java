package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.dto.req.XN632060ReqProtocol;

public interface ICarDealerProtocolBO extends IPaginableBO<CarDealerProtocol> {

    public void saveCarDealerProtocolList(List<XN632060ReqProtocol> list,
            String code);

    public int saveCarDealerProtocol(CarDealerProtocol data);

    public int refreshCarDealerProtocol(CarDealerProtocol data);

    public void removeCarDealerProtocolByCarDealerCode(String carDealerCode);

    public List<CarDealerProtocol> queryCarDealerProtocolList(
            CarDealerProtocol condition);

    public CarDealerProtocol getCarDealerProtocol(int id);

    // 根据汽车经销商编号查协议
    public CarDealerProtocol getCarDealerProtocolByCarDealerCode(
            String carDealerCode, String bankCode);

}
