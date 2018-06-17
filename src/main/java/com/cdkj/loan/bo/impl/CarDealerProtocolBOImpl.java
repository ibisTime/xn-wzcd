package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.ICarDealerProtocolDAO;
import com.cdkj.loan.domain.CarDealerProtocol;
import com.cdkj.loan.dto.req.XN632060ReqProtocol;
import com.cdkj.loan.exception.BizException;

@Component
public class CarDealerProtocolBOImpl extends PaginableBOImpl<CarDealerProtocol>
        implements ICarDealerProtocolBO {

    @Autowired
    private ICarDealerProtocolDAO carDealerProtocolDAO;

    public void saveCarDealerProtocolList(List<XN632060ReqProtocol> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            for (XN632060ReqProtocol req : list) {
                CarDealerProtocol data = new CarDealerProtocol();
                data.setCarDealerCode(req.getCarDealerCode());
                data.setBankCode(req.getBankCode());
                data.setPlatCtRate12(
                    StringValidater.toDouble(req.getPlatCtRate12()));
                data.setPlatCtRate24(
                    StringValidater.toDouble(req.getPlatCtRate24()));
                data.setPlatCtRate36(
                    StringValidater.toDouble(req.getPlatCtRate36()));

                data.setPlatZkRate12(
                    StringValidater.toDouble(req.getPlatZkRate12()));
                data.setPlatZkRate24(
                    StringValidater.toDouble(req.getPlatZkRate24()));
                data.setPlatZkRate36(
                    StringValidater.toDouble(req.getPlatZkRate36()));
                data.setAssureType(req.getAssureType());
                data.setAssureFee(StringValidater.toLong(req.getAssureFee()));

                data.setAssureRate(
                    StringValidater.toDouble(req.getAssureRate()));
                data.setLyAmountType(req.getLyAmountType());
                data.setLyAmountFee(
                    StringValidater.toLong(req.getLyAmountFee()));
                data.setLyAmountRate(
                    StringValidater.toDouble(req.getLyAmountRate()));
                data.setGpsType(req.getGpsType());

                data.setGpsFee(StringValidater.toLong(req.getGpsFee()));
                data.setGpsRate(StringValidater.toDouble(req.getGpsRate()));
                data.setOtherType(req.getOtherType());
                data.setOtherFee(StringValidater.toLong(req.getOtherFee()));
                data.setOtherRate(StringValidater.toDouble(req.getOtherRate()));

                data.setIntroduceType(req.getIntroduceType());
                data.setIntroduceFee(
                    StringValidater.toLong(req.getIntroduceFee()));
                data.setIntroduceRate(
                    StringValidater.toDouble(req.getIntroduceRate()));
                data.setReturnPointType(req.getReturnPointType());
                data.setReturnPointFee(
                    StringValidater.toLong(req.getReturnPointFee()));

                data.setReturnPointRate(
                    StringValidater.toDouble(req.getReturnPointRate()));
                data.setIsDz(req.getIsDz());
                data.setInsuAgencyYear1Type(req.getInsuAgencyYear1Type());
                data.setInsuAgencyYear1Fee(
                    StringValidater.toLong(req.getInsuAgencyYear1Fee()));
                data.setInsuAgencyYear2Type(req.getInsuAgencyYear2Type());

                data.setInsuAgencyYear2Fee(
                    StringValidater.toLong(req.getInsuAgencyYear2Fee()));
                data.setInsuAgencyYear3Type(req.getInsuAgencyYear3Type());
                data.setInsuAgencyYear3Fee(
                    StringValidater.toLong(req.getInsuAgencyYear3Fee()));

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

    @Override
    public CarDealerProtocol getCarDealerProtocolByCarDealerCode(
            String carDealerCode) {
        CarDealerProtocol data = null;
        if (StringUtils.isNotBlank(carDealerCode)) {
            CarDealerProtocol condition = new CarDealerProtocol();
            condition.setCarDealerCode(carDealerCode);
            data = carDealerProtocolDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "根据汽车经销商查询协议不存在！");
            }
        }
        return data;

    }
}
