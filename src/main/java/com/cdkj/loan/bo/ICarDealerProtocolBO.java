package com.cdkj.loan.bo;

import java.util.List;
import java.util.Map;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.dto.req.XN632060ReqProtocol;
import com.cdkj.loan.dto.res.XN632291Res;

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

    // 根据协议计算各种费用
    public XN632291Res calProtocolFee(Long loanAmount, String bankCode,
            String carDealerCode);

    // 计算油补和GPS提成
    public Map<String, Long> calculateOilSubsidyGpsDeduct(Long loanAmount);

}
