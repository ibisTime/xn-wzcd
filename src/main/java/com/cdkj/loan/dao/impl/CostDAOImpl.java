package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICostDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Cost;

@Repository("costDAOImpl")
public class CostDAOImpl extends AMybatisTemplate implements ICostDAO {

    @Override
    public int insert(Cost data) {
        return super.insert(NAMESPACE.concat("insert_cost"), data);
    }

    @Override
    public int delete(Cost data) {
        return super.delete(NAMESPACE.concat("delete_cost"), data);
    }

    @Override
    public Cost select(Cost condition) {
        return super.select(NAMESPACE.concat("select_cost"), condition,
            Cost.class);
    }

    @Override
    public long selectTotalCount(Cost condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_cost_count"),
            condition);
    }

    @Override
    public List<Cost> selectList(Cost condition) {
        return super.selectList(NAMESPACE.concat("select_cost"), condition,
            Cost.class);
    }

    @Override
    public List<Cost> selectList(Cost condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_cost"), start, count,
            condition, Cost.class);
    }

    @Override
    public int updateRepay(Cost data) {
        return super.update(NAMESPACE.concat("update_cost_repay"), data);
    }
}
