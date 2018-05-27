package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarDealerProtocolAO;
import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.dto.req.XN632060ReqProtocol;

@Service
public class CarDealerProtocolAOImpl implements ICarDealerProtocolAO {

    @Autowired
    private ICarDealerProtocolBO carDealerProtocolBO;

    @Override
    public int addCarDealerProtocol(XN632060ReqProtocol req) {
        CarDealerProtocol data = new CarDealerProtocol();

        data.setCarDealerCode(req.getCarDealerCode());
        data.setBankCode(req.getBankCode());
        data.setPlatCtRate12(req.getPlatCtRate12());
        data.setPlatCtRate24(req.getPlatCtRate24());
        data.setPlatCtRate36(req.getPlatCtRate36());

        data.setPlatZkRate12(req.getPlatZkRate12());
        data.setPlatZkRate24(req.getPlatZkRate24());
        data.setPlatZkRate36(req.getPlatZkRate36());
        data.setAssureType(req.getAssureType());
        data.setAssureFee(req.getAssureFee());

        data.setAssureRate(req.getAssureRate());
        data.setLyAmountType(req.getLyAmountType());
        data.setLyAmountFee(req.getLyAmountFee());
        data.setLyAmountRate(req.getLyAmountRate());
        data.setGpsType(req.getGpsType());

        data.setGpsFee(req.getGpsFee());
        data.setGpsRate(req.getGpsRate());
        data.setOtherType(req.getOtherType());
        data.setOtherFee(req.getOtherFee());
        data.setOtherRate(req.getOtherRate());

        data.setIntroduceType(req.getIntroduceType());
        data.setIntroduceFee(req.getIntroduceFee());
        data.setIntroduceRate(req.getIntroduceRate());
        data.setReturnPointType(req.getReturnPointType());
        data.setReturnPointFee(req.getReturnPointFee());

        data.setReturnPointRate(req.getReturnPointRate());
        data.setIsDz(req.getIsDz());
        data.setInsuAgencyYear1Type(req.getInsuAgencyYear1Type());
        data.setInsuAgencyYear1Fee(req.getInsuAgencyYear1Fee());
        data.setInsuAgencyYear2Type(req.getInsuAgencyYear2Type());

        data.setInsuAgencyYear2Fee(req.getInsuAgencyYear2Fee());
        data.setInsuAgencyYear3Type(req.getInsuAgencyYear3Type());
        data.setInsuAgencyYear3Fee(req.getInsuAgencyYear3Fee());

        return carDealerProtocolBO.saveCarDealerProtocol(data);
    }

    @Override
    public int editCarDealerProtocol(CarDealerProtocol data) {
        return carDealerProtocolBO.refreshCarDealerProtocol(data);
    }

    @Override
    public int dropCarDealerProtocol(int id) {
        return carDealerProtocolBO.removeCarDealerProtocol(id);
    }

    @Override
    public Paginable<CarDealerProtocol> queryCarDealerProtocolPage(int start,
            int limit, CarDealerProtocol condition) {
        return carDealerProtocolBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CarDealerProtocol> queryCarDealerProtocolList(
            CarDealerProtocol condition) {
        return carDealerProtocolBO.queryCarDealerProtocolList(condition);
    }

    @Override
    public CarDealerProtocol getCarDealerProtocol(int id) {
        return carDealerProtocolBO.getCarDealerProtocol(id);
    }
}
