package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.enums.EGeneratePrefix;

@Service
public class GpsAOImpl implements IGpsAO {

    @Autowired
    private IGpsBO gpsBO;

    @Override
    public String addGps(String gpsNo, String gpsType) {
        Gps data = new Gps();
        String code = OrderNoGenerater.generate(EGeneratePrefix.GPS.getCode());
        data.setCode(code);
        data.setGpsNo(gpsNo);
        data.setGpsType(gpsType);
        gpsBO.saveGps(data);
        return code;
    }

    @Override
    public Paginable<Gps> queryGpsPage(int start, int limit, Gps condition) {
        return gpsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Gps> queryGpsList(Gps condition) {
        return gpsBO.queryGpsList(condition);
    }

    @Override
    public Gps getGps(String code) {
        return gpsBO.getGps(code);
    }
}
