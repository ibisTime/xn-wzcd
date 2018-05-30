package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IGpsApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.GpsApply;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:11:29 
 * @history:
 */
@Repository("gpsApplyDAOImpl")
public class GpsApplyDAOImpl extends AMybatisTemplate implements IGpsApplyDAO {

    @Override
    public int insert(GpsApply data) {
        return super.insert(NAMESPACE.concat("insert_gpsApply"), data);
    }

    @Override
    public int delete(GpsApply data) {
        return super.delete(NAMESPACE.concat("delete_gpsApply"), data);
    }

    @Override
    public GpsApply select(GpsApply condition) {
        return super.select(NAMESPACE.concat("select_gpsApply"), condition,
            GpsApply.class);
    }

    @Override
    public long selectTotalCount(GpsApply condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_gpsApply_count"),
            condition);
    }

    @Override
    public List<GpsApply> selectList(GpsApply condition) {
        return super.selectList(NAMESPACE.concat("select_gpsApply"), condition,
            GpsApply.class);
    }

    @Override
    public List<GpsApply> selectList(GpsApply condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_gpsApply"), start,
            count, condition, GpsApply.class);
    }

    @Override
    public void updateGpsApplyApprove(GpsApply data) {
        super.update(NAMESPACE.concat("update_gpsApply_approve"), data);
    }

}
