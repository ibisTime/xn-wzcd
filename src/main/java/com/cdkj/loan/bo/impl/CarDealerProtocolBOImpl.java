package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarDealerProtocolBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
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
