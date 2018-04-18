package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IFieldTimesDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.FieldTimes;

@Repository("fieldTimesDAOImpl")
public class FieldTimesDAOImpl extends AMybatisTemplate implements
        IFieldTimesDAO {

    @Override
    public int insert(FieldTimes data) {
        return super.insert(NAMESPACE.concat("insert_fieldTimes"), data);
    }

    @Override
    public int delete(FieldTimes data) {
        return super.delete(NAMESPACE.concat("delete_fieldTimes"), data);
    }

    @Override
    public FieldTimes select(FieldTimes condition) {
        return super.select(NAMESPACE.concat("select_fieldTimes"), condition,
            FieldTimes.class);
    }

    @Override
    public long selectTotalCount(FieldTimes condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fieldTimes_count"), condition);
    }

    @Override
    public List<FieldTimes> selectList(FieldTimes condition) {
        return super.selectList(NAMESPACE.concat("select_fieldTimes"),
            condition, FieldTimes.class);
    }

    @Override
    public List<FieldTimes> selectList(FieldTimes condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fieldTimes"), start,
            count, condition, FieldTimes.class);
    }

}
