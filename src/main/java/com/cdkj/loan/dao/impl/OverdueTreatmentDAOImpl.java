package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IOverdueTreatmentDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.OverdueTreatment;

@Repository("overdueTreatmentDAOImpl")
public class OverdueTreatmentDAOImpl extends AMybatisTemplate
        implements IOverdueTreatmentDAO {

    @Override
    public int insert(OverdueTreatment data) {
        return super.insert(NAMESPACE.concat("insert_overdueTreatment"), data);
    }

    @Override
    public int delete(OverdueTreatment data) {
        return super.delete(NAMESPACE.concat("delete_overdueTreatment"), data);
    }

    @Override
    public OverdueTreatment select(OverdueTreatment condition) {
        return super.select(NAMESPACE.concat("select_overdueTreatment"),
            condition, OverdueTreatment.class);
    }

    @Override
    public long selectTotalCount(OverdueTreatment condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_overdueTreatment_count"), condition);
    }

    @Override
    public List<OverdueTreatment> selectList(OverdueTreatment condition) {
        return super.selectList(NAMESPACE.concat("select_overdueTreatment"),
            condition, OverdueTreatment.class);
    }

    @Override
    public List<OverdueTreatment> selectList(OverdueTreatment condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_overdueTreatment"),
            start, count, condition, OverdueTreatment.class);
    }

}
