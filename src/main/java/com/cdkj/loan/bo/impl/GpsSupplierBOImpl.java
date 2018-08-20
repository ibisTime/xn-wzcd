package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IGpsSupplierBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IGpsSupplierDAO;
import com.cdkj.loan.domain.GpsSupplier;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class GpsSupplierBOImpl extends PaginableBOImpl<GpsSupplier>
        implements IGpsSupplierBO {

    @Autowired
    private IGpsSupplierDAO gpsSupplierDAO;

    public String saveGpsSupplier(GpsSupplier data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.GPS_SUPPLIER.getCode());
            data.setCode(code);
            gpsSupplierDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeGpsSupplier(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            GpsSupplier data = new GpsSupplier();
            data.setCode(code);
            count = gpsSupplierDAO.delete(data);
        }
        return count;
    }

    @Override
    public void refreshGpsSupplier(GpsSupplier data) {
        gpsSupplierDAO.update(data);
    }

    @Override
    public List<GpsSupplier> queryGpsSupplierList(GpsSupplier condition) {
        return gpsSupplierDAO.selectList(condition);
    }

    @Override
    public GpsSupplier getGpsSupplier(String code) {
        GpsSupplier data = null;
        if (StringUtils.isNotBlank(code)) {
            GpsSupplier condition = new GpsSupplier();
            condition.setCode(code);
            data = gpsSupplierDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在！");
            }
        }
        return data;
    }
}
