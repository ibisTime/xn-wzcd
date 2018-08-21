package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IPerformanceBondDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.PerformanceBond;

@Repository("performanceBondDAOImpl")
public class PerformanceBondDAOImpl extends AMybatisTemplate
        implements IPerformanceBondDAO {

    @Override
    public int insert(PerformanceBond data) {
        return super.insert(NAMESPACE.concat("insert_performanceBond"), data);
    }

    @Override
    public int delete(PerformanceBond data) {
        return 0;
    }

    @Override
    public void update(PerformanceBond data) {
        super.update(NAMESPACE.concat("update_performanceBond"), data);
    }

    @Override
    public PerformanceBond select(PerformanceBond condition) {
        return super.select(NAMESPACE.concat("select_performanceBond"),
            condition, PerformanceBond.class);
    }

    @Override
    public long selectTotalCount(PerformanceBond condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_performanceBond_count"), condition);
    }

    @Override
    public List<PerformanceBond> selectList(PerformanceBond condition) {
        return super.selectList(NAMESPACE.concat("select_performanceBond"),
            condition, PerformanceBond.class);
    }

    @Override
    public List<PerformanceBond> selectList(PerformanceBond condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_performanceBond"),
            start, count, condition, PerformanceBond.class);
    }

}
