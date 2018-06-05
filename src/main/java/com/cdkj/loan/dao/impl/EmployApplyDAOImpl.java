package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IEmployApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.EmployApply;

@Repository("employApplyDAOImpl")
public class EmployApplyDAOImpl extends AMybatisTemplate implements
        IEmployApplyDAO {

    @Override
    public int insert(EmployApply data) {
        return super.insert(NAMESPACE.concat("insert_employApply"), data);
    }

    @Override
    public int delete(EmployApply data) {
        return super.delete(NAMESPACE.concat("delete_employApply"), data);
    }

    @Override
    public int updateInterview(EmployApply data) {
        return super.delete(NAMESPACE.concat("update_employApplyInterview"),
            data);
    }

    @Override
    public EmployApply select(EmployApply condition) {
        return super.select(NAMESPACE.concat("select_employApply"), condition,
            EmployApply.class);
    }

    @Override
    public long selectTotalCount(EmployApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_employApply_count"), condition);
    }

    @Override
    public List<EmployApply> selectList(EmployApply condition) {
        return super.selectList(NAMESPACE.concat("select_employApply"),
            condition, EmployApply.class);
    }

    @Override
    public List<EmployApply> selectList(EmployApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_employApply"), start,
            count, condition, EmployApply.class);
    }
}
