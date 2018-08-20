package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.GpsSupplier;
import com.cdkj.loan.dto.req.XN632780Req;
import com.cdkj.loan.dto.req.XN632781Req;

@Component
public interface IGpsSupplierAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addGpsSupplier(XN632780Req req);

    public int dropGpsSupplier(String code);

    public void editGpsSupplier(XN632781Req req);

    public Paginable<GpsSupplier> queryGpsSupplierPage(int start, int limit,
            GpsSupplier condition);

    public List<GpsSupplier> queryGpsSupplierList(GpsSupplier condition);

    public GpsSupplier getGpsSupplier(String code);

}
