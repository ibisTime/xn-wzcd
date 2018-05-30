package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IGpsDAO;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.enums.EBizErrorCode;
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
    public void refreshUseGps(Gps data) {
        if (data != null) {
            gpsDAO.updateUse(data);
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
}
