package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ICarDealerProtocolDAO;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.exception.BizException;

@Component
public class CarDealerProtocolBOImpl extends PaginableBOImpl<CarDealerProtocol>
        implements ICarDealerProtocolBO {

    @Autowired
    private ICarDealerProtocolDAO carDealerProtocolDAO;

    public void saveCarDealerProtocolList(List<CarDealerProtocol> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            for (CarDealerProtocol carDealerProtocol : list) {
                CarDealerProtocol data = new CarDealerProtocol();
                data.setCarDealerCode(carDealerProtocol.getCarDealerCode());
                data.setBankCode(carDealerProtocol.getBankCode());
                data.setPlatCtRate12(carDealerProtocol.getPlatCtRate12());
                data.setPlatCtRate24(carDealerProtocol.getPlatCtRate24());
                data.setPlatCtRate36(carDealerProtocol.getPlatCtRate36());

                data.setPlatZkRate12(carDealerProtocol.getPlatZkRate12());
                data.setPlatZkRate24(carDealerProtocol.getPlatZkRate24());
                data.setPlatZkRate36(carDealerProtocol.getPlatZkRate36());
                data.setAssureType(carDealerProtocol.getAssureType());
                data.setAssureFee(carDealerProtocol.getAssureFee());

                data.setAssureRate(carDealerProtocol.getAssureRate());
                data.setLyAmountType(carDealerProtocol.getLyAmountType());
                data.setLyAmountFee(carDealerProtocol.getLyAmountFee());
                data.setLyAmountRate(carDealerProtocol.getLyAmountRate());
                data.setGpsType(carDealerProtocol.getGpsType());

                data.setGpsFee(carDealerProtocol.getGpsFee());
                data.setGpsRate(carDealerProtocol.getGpsRate());
                data.setOtherType(carDealerProtocol.getOtherType());
                data.setOtherFee(carDealerProtocol.getOtherFee());
                data.setOtherRate(carDealerProtocol.getOtherRate());

                data.setIntroduceType(carDealerProtocol.getIntroduceType());
                data.setIntroduceFee(carDealerProtocol.getIntroduceFee());
                data.setIntroduceRate(carDealerProtocol.getIntroduceRate());
                data.setReturnPointType(carDealerProtocol.getReturnPointType());
                data.setReturnPointFee(carDealerProtocol.getReturnPointFee());

                data.setReturnPointRate(carDealerProtocol.getReturnPointRate());
                data.setIsDz(carDealerProtocol.getIsDz());
                data.setInsuAgencyYear1Type(
                    carDealerProtocol.getInsuAgencyYear1Type());
                data.setInsuAgencyYear1Fee(
                    carDealerProtocol.getInsuAgencyYear1Fee());
                data.setInsuAgencyYear2Type(
                    carDealerProtocol.getInsuAgencyYear2Type());

                data.setInsuAgencyYear2Fee(
                    carDealerProtocol.getInsuAgencyYear2Fee());
                data.setInsuAgencyYear3Type(
                    carDealerProtocol.getInsuAgencyYear3Type());
                data.setInsuAgencyYear3Fee(
                    carDealerProtocol.getInsuAgencyYear3Fee());

                carDealerProtocolDAO.insert(data);
            }
        }
    }

    public int saveCarDealerProtocol(CarDealerProtocol data) {
        int id = data.getId();
        carDealerProtocolDAO.insert(data);
        return id;
    }

    @Override
    public int removeCarDealerProtocol(int id) {

        return 0;
    }

    @Override
    public int refreshCarDealerProtocol(CarDealerProtocol data) {
        int count = 0;
        if (data.getId() != 0) {
            count = carDealerProtocolDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CarDealerProtocol> queryCarDealerProtocolList(
            CarDealerProtocol condition) {
        return carDealerProtocolDAO.selectList(condition);
    }

    @Override
    public CarDealerProtocol getCarDealerProtocol(int id) {
        CarDealerProtocol data = null;
        if (id != 0) {
            CarDealerProtocol condition = new CarDealerProtocol();
            condition.setId(id);
            data = carDealerProtocolDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "协议不存在！");
            }
        }
        return data;
    }
}
