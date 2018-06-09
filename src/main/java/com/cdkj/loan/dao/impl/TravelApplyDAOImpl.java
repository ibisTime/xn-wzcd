package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ITravelApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.TravelApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:29:25 
 * @history:
 */
@Repository("travelApplyDAOImpl")
public class TravelApplyDAOImpl extends AMybatisTemplate
        implements ITravelApplyDAO {

    @Override
    public int insert(TravelApply data) {
        return super.insert(NAMESPACE.concat("insert_travelApply"), data);
    }

    @Override
    public int delete(TravelApply data) {
        return super.delete(NAMESPACE.concat("delete_travelApply"), data);
    }

    @Override
    public TravelApply select(TravelApply condition) {
        return super.select(NAMESPACE.concat("select_travelApply"), condition,
            TravelApply.class);
    }

    @Override
    public long selectTotalCount(TravelApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_travelApply_count"), condition);
    }

    @Override
    public List<TravelApply> selectList(TravelApply condition) {
        return super.selectList(NAMESPACE.concat("select_travelApply"),
            condition, TravelApply.class);
    }

    @Override
    public List<TravelApply> selectList(TravelApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_travelApply"), start,
            count, condition, TravelApply.class);
    }

    @Override
    public int update(TravelApply data) {

        return super.update(NAMESPACE.concat("update_travelApply"), data);
    }

    @Override
    public Long selectTotalHour(TravelApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_travelApply_totalHour"), condition);
    }

}
