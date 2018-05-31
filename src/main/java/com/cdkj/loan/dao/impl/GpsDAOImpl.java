package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IGpsDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Gps;

@Repository("gpsDAOImpl")
public class GpsDAOImpl extends AMybatisTemplate implements IGpsDAO {

    @Override
    public int insert(Gps data) {
        return super.insert(NAMESPACE.concat("insert_gps"), data);
    }

    @Override
    public int delete(Gps data) {
        return super.delete(NAMESPACE.concat("delete_gps"), data);
    }

    @Override
    public int updateApply(Gps data) {
        return super.update(NAMESPACE.concat("update_gps_apply"), data);
    }

    @Override
    public int updateApplyStatus(Gps data) {
        return super.update(NAMESPACE.concat("update_gps_applyStatus"), data);
    }

    @Override
    public int updateUseStatus(Gps data) {
        return super.insert(NAMESPACE.concat("update_gps_useStatus"), data);
    }

    @Override
    public Gps select(Gps condition) {
        return super.select(NAMESPACE.concat("select_gps"), condition,
            Gps.class);
    }

    @Override
    public long selectTotalCount(Gps condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_gps_count"),
            condition);
    }

    @Override
    public List<Gps> selectList(Gps condition) {
        return super.selectList(NAMESPACE.concat("select_gps"), condition,
            Gps.class);
    }

    @Override
    public List<Gps> selectList(Gps condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_gps"), start, count,
            condition, Gps.class);
    }
}
