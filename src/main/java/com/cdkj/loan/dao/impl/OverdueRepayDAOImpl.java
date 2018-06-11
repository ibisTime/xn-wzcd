package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IOverdueRepayDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.OverdueRepay;

@Repository("overdueRepayDAOImpl")
public class OverdueRepayDAOImpl extends AMybatisTemplate implements
        IOverdueRepayDAO {

    @Override
    public int insert(OverdueRepay data) {
        return super.insert(NAMESPACE.concat("insert_overdueRepay"), data);
    }

    @Override
    public int delete(OverdueRepay data) {
        return 0;
    }

    @Override
    public OverdueRepay select(OverdueRepay condition) {
        return super.select(NAMESPACE.concat("select_overdueRepay"), condition,
            OverdueRepay.class);
    }

    @Override
    public long selectTotalCount(OverdueRepay condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_overdueRepay_count"), condition);
    }

    @Override
    public List<OverdueRepay> selectList(OverdueRepay condition) {
        return super.selectList(NAMESPACE.concat("select_overdueRepay"),
            condition, OverdueRepay.class);
    }

    @Override
    public List<OverdueRepay> selectList(OverdueRepay condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_overdueRepay"), start,
            count, condition, OverdueRepay.class);
    }
}
