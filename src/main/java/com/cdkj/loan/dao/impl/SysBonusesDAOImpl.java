package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISysBonusesDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SysBonuses;

@Repository("sysBonusesDAOImpl")
public class SysBonusesDAOImpl extends AMybatisTemplate
        implements ISysBonusesDAO {

    @Override
    public int insert(SysBonuses data) {
        return super.insert(NAMESPACE.concat("insert_sysBonuses"), data);
    }

    @Override
    public int delete(SysBonuses data) {
        return super.delete(NAMESPACE.concat("delete_sysBonuses"), data);
    }

    @Override
    public SysBonuses select(SysBonuses condition) {
        return super.select(NAMESPACE.concat("select_sysBonuses"), condition,
            SysBonuses.class);
    }

    @Override
    public long selectTotalCount(SysBonuses condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_sysBonuses_count"), condition);
    }

    @Override
    public List<SysBonuses> selectList(SysBonuses condition) {
        return super.selectList(NAMESPACE.concat("select_sysBonuses"),
            condition, SysBonuses.class);
    }

    @Override
    public List<SysBonuses> selectList(SysBonuses condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_sysBonuses"), start,
            count, condition, SysBonuses.class);
    }

    @Override
    public void update(SysBonuses data) {
        // TODO Auto-generated method stub

    }

}
