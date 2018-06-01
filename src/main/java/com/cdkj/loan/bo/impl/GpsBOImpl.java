package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IGpsDAO;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGpsApplyStatus;
import com.cdkj.loan.enums.EGpsUseStatus;
import com.cdkj.loan.exception.BizException;

@Component
public class GpsBOImpl extends PaginableBOImpl<Gps> implements IGpsBO {

    @Autowired
    private IGpsDAO gpsDAO;

    @Override
    public void saveGps(Gps data) {
        if (data != null) {
            gpsDAO.insert(data);
        }
    }

    @Override
    public void applyGps(Gps data) {
        if (data != null) {
            gpsDAO.updateApply(data);
        }
    }

    @Override
    public void refreshApplyGps(String code, String applyUser) {
        if (StringUtils.isNotBlank(code)) {
            Gps data = new Gps();
            data.setCode(code);
            data.setApplyUser(applyUser);
            data.setApplyStatus(EBoolean.YES.getCode());
            gpsDAO.updateApplyStatus(data);
        }
    }

    @Override
    public void refreshUseGps(String code, String budgetOrder) {
        if (StringUtils.isNotBlank(code)) {
            Gps data = new Gps();
            data.setCode(code);
            data.setUseStatus(EGpsUseStatus.USED.getCode());
            data.setUseDatetime(new Date());
            data.setBizCode(budgetOrder);
            gpsDAO.updateUseStatus(data);
        }
    }

    @Override
    public List<Gps> queryGpsList(Gps condition) {
        return gpsDAO.selectList(condition);
    }

    @Override
    public Gps getGps(String code) {
        Gps data = null;
        if (StringUtils.isNotBlank(code)) {
            Gps condition = new Gps();
            condition.setCode(code);
            data = gpsDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "GPS编号不存在");
            }
        }
        return data;
    }

    @Override
    public Gps getGpsByDevNo(String gpsDevNo) {
        Gps data = null;
        if (StringUtils.isNotBlank(gpsDevNo)) {
            Gps condition = new Gps();
            condition.setGpsDevNo(gpsDevNo);
            List<Gps> gpsList = gpsDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(gpsList)) {
                data = gpsList.get(0);
            } else {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "GPS编号不存在");
            }
        }
        return data;
    }

    /** 
     * @see com.cdkj.loan.bo.IGpsBO#applyLqGps(com.cdkj.loan.domain.Gps)
     */
    @Override
    public void applyLqGps(String code) {
        Gps data = new Gps();
        data.setCode(code);
        data.setApplyStatus(EGpsApplyStatus.RECEIVED.getCode());
        gpsDAO.updateApplyStatus(data);
    }
}
