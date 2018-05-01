package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRepayPlanDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.RepayPlan;

@Repository("repayPlanDAOImpl")
public class RepayPlanDAOImpl extends AMybatisTemplate
        implements IRepayPlanDAO {

    @Override
    public int insert(RepayPlan data) {
        return super.insert(NAMESPACE.concat("insert_repayPlan"), data);
    }

    @Override
    public int delete(RepayPlan data) {
        return super.delete(NAMESPACE.concat("delete_repayPlan"), data);
    }

    @Override
    public RepayPlan select(RepayPlan condition) {
        return super.select(NAMESPACE.concat("select_repayPlan"), condition,
            RepayPlan.class);
    }

    @Override
    public long selectTotalCount(RepayPlan condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_repayPlan_count"), condition);
    }

    @Override
    public List<RepayPlan> selectList(RepayPlan condition) {
        return super.selectList(NAMESPACE.concat("select_repayPlan"), condition,
            RepayPlan.class);
    }

    @Override
    public List<RepayPlan> selectList(RepayPlan condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_repayPlan"), start,
            count, condition, RepayPlan.class);
    }

    @Override
    public int update(RepayPlan data) {
        // TODO Auto-generated method stub
        return 0;
    }

}
