package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBizDayStatisticDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BizDayStatistic;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月6日 下午5:47:47 
 * @history:
 */
@Repository("bizDayStatisticDAOImpl")
public class BizDayStatisticDAOImpl extends AMybatisTemplate implements
        IBizDayStatisticDAO {

    @Override
    public int insert(BizDayStatistic data) {
        return super.insert(NAMESPACE.concat("insert_bizDayStatistic"), data);
    }

    @Override
    public int delete(BizDayStatistic data) {
        return super.delete(NAMESPACE.concat("delete_bizDayStatistic"), data);
    }

    @Override
    public BizDayStatistic select(BizDayStatistic condition) {
        return super.select(NAMESPACE.concat("select_bizDayStatistic"),
            condition, BizDayStatistic.class);
    }

    @Override
    public long selectTotalCount(BizDayStatistic condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bizDayStatistic_count"), condition);
    }

    @Override
    public List<BizDayStatistic> selectList(BizDayStatistic condition) {
        return super.selectList(NAMESPACE.concat("select_bizDayStatistic"),
            condition, BizDayStatistic.class);
    }

    @Override
    public List<BizDayStatistic> selectList(BizDayStatistic condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bizDayStatistic"),
            start, count, condition, BizDayStatistic.class);
    }

    @Override
    public int update(BizDayStatistic data) {
        // TODO Auto-generated method stub
        return 0;
    }

}
