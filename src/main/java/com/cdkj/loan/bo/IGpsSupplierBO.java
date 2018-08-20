package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.GpsSupplier;

public interface IGpsSupplierBO extends IPaginableBO<GpsSupplier> {

    public String saveGpsSupplier(GpsSupplier data);

    public int removeGpsSupplier(String code);

    public void refreshGpsSupplier(GpsSupplier data);

    public List<GpsSupplier> queryGpsSupplierList(GpsSupplier condition);

    public GpsSupplier getGpsSupplier(String code);

}
