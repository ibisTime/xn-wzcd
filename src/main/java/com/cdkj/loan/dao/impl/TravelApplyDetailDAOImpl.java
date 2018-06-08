package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ITravelApplyDetailDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.TravelApplyDetail;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:56:27 
 * @history:
 */
@Repository("travelApplyDetailDAOImpl")
public class TravelApplyDetailDAOImpl extends AMybatisTemplate
        implements ITravelApplyDetailDAO {

    @Override
    public int insert(TravelApplyDetail data) {
        return super.insert(NAMESPACE.concat("insert_travelApplyDetail"), data);
    }

    @Override
    public int delete(TravelApplyDetail data) {
        return 0;
    }

    @Override
    public TravelApplyDetail select(TravelApplyDetail condition) {
        return super.select(NAMESPACE.concat("select_travelApplyDetail"),
            condition, TravelApplyDetail.class);
    }

    @Override
    public long selectTotalCount(TravelApplyDetail condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_travelApplyDetail_count"), condition);
    }

    @Override
    public List<TravelApplyDetail> selectList(TravelApplyDetail condition) {
        return super.selectList(NAMESPACE.concat("select_travelApplyDetail"),
            condition, TravelApplyDetail.class);
    }

    @Override
    public List<TravelApplyDetail> selectList(TravelApplyDetail condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_travelApplyDetail"),
            start, count, condition, TravelApplyDetail.class);
    }

}
