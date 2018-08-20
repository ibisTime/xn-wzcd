package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IGpsSupplierDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.GpsSupplier;

@Repository("gpsSupplierDAOImpl")
public class GpsSupplierDAOImpl extends AMybatisTemplate
        implements IGpsSupplierDAO {

    @Override
    public int insert(GpsSupplier data) {
        return super.insert(NAMESPACE.concat("insert_gpsSupplier"), data);
    }

    @Override
    public int delete(GpsSupplier data) {
        return super.delete(NAMESPACE.concat("delete_gpsSupplier"), data);
    }

    @Override
    public void update(GpsSupplier data) {
        super.update(NAMESPACE.concat("update_gpsSupplier"), data);
    }

    @Override
    public GpsSupplier select(GpsSupplier condition) {
        return super.select(NAMESPACE.concat("select_gpsSupplier"), condition,
            GpsSupplier.class);
    }

    @Override
    public long selectTotalCount(GpsSupplier condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_gpsSupplier_count"), condition);
    }

    @Override
    public List<GpsSupplier> selectList(GpsSupplier condition) {
        return super.selectList(NAMESPACE.concat("select_gpsSupplier"),
            condition, GpsSupplier.class);
    }

    @Override
    public List<GpsSupplier> selectList(GpsSupplier condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_gpsSupplier"), start,
            count, condition, GpsSupplier.class);
    }

}
