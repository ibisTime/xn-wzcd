package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IDayRestDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.DayRest;

/**
 * 休息日
 * @author: silver 
 * @since: 2018年6月8日 下午2:48:30 
 * @history:
 */
@Repository("dayRestDAOImpl")
public class DayRestDAOImpl extends AMybatisTemplate implements IDayRestDAO {

    @Override
    public int insert(DayRest data) {
        return super.insert(NAMESPACE.concat("insert_dayRest"), data);
    }

    @Override
    public int delete(DayRest data) {
        return super.delete(NAMESPACE.concat("delete_dayRest"), data);
    }

    @Override
    public DayRest select(DayRest condition) {
        return super.select(NAMESPACE.concat("select_dayRest"), condition,
            DayRest.class);
    }

    @Override
    public long selectTotalCount(DayRest condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_dayRest_count"),
            condition);
    }

    @Override
    public List<DayRest> selectList(DayRest condition) {
        return super.selectList(NAMESPACE.concat("select_dayRest"), condition,
            DayRest.class);
    }

    @Override
    public List<DayRest> selectList(DayRest condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_dayRest"), start,
            count, condition, DayRest.class);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void insertDayRestList(List<DayRest> dayRestList) {
        super.insertBatch(NAMESPACE.concat("insert_dayRestList"),
            (List) dayRestList);
    }

}
