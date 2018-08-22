package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IGpsSupplierAO;
import com.cdkj.loan.bo.IGpsSupplierBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.GpsSupplier;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632780Req;
import com.cdkj.loan.dto.req.XN632781Req;

@Service
public class GpsSupplierAOImpl implements IGpsSupplierAO {

    @Autowired
    private IGpsSupplierBO gpsSupplierBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    @Transactional
    public String addGpsSupplier(XN632780Req req) {
        GpsSupplier data = new GpsSupplier();
        data.setName(req.getName());
        data.setContacts(req.getContacts());
        data.setContactsMobile(req.getContactsMobile());
        data.setAddress(req.getAddress());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return gpsSupplierBO.saveGpsSupplier(data);
    }

    @Override
    @Transactional
    public void editGpsSupplier(XN632781Req req) {
        GpsSupplier data = getGpsSupplier(req.getCode());
        data.setName(req.getName());
        data.setContacts(req.getContacts());
        data.setContactsMobile(req.getContactsMobile());
        data.setAddress(req.getAddress());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        gpsSupplierBO.refreshGpsSupplier(data);
    }

    @Override
    public int dropGpsSupplier(String code) {
        return gpsSupplierBO.removeGpsSupplier(code);
    }

    @Override
    public Paginable<GpsSupplier> queryGpsSupplierPage(int start, int limit,
            GpsSupplier condition) {
        Paginable<GpsSupplier> paginable = gpsSupplierBO.getPaginable(start,
            limit, condition);
        for (GpsSupplier gpsSupplier : paginable.getList()) {
            initGpsSupplier(gpsSupplier);
        }
        return paginable;
    }

    @Override
    public List<GpsSupplier> queryGpsSupplierList(GpsSupplier condition) {
        List<GpsSupplier> queryGpsSupplierList = gpsSupplierBO
            .queryGpsSupplierList(condition);
        for (GpsSupplier gpsSupplier : queryGpsSupplierList) {
            initGpsSupplier(gpsSupplier);
        }
        return queryGpsSupplierList;
    }

    @Override
    public GpsSupplier getGpsSupplier(String code) {
        GpsSupplier gpsSupplier = gpsSupplierBO.getGpsSupplier(code);
        initGpsSupplier(gpsSupplier);
        return gpsSupplier;
    }

    private void initGpsSupplier(GpsSupplier gpsSupplier) {
        if (StringUtils.isNotBlank(gpsSupplier.getUpdater())) {
            SYSUser user = sysUserBO.getUser(gpsSupplier.getUpdater());
            gpsSupplier.setUpdaterName(user.getRealName());
        }
    }

}
