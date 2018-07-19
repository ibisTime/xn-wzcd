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
        return 0;
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void insertList(List<RepayPlan> dataList) {
        super.insertBatch(NAMESPACE.concat("insert_repayPlanList"),
            (List) dataList);
    }

    @Override
    public int repayResultHandle(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_paySuccess"), data);
    }

    @Override
    public int repayPartSuccess(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_payPartSuccess"), data);
    }

    @Override
    public int updateOverdue(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_overdue"), data);
    }

    @Override
    public int updateOverdueHandle(RepayPlan data) {
        return super.update(NAMESPACE.concat("overdue_handle"), data);
    }

    @Override
    public int payFee(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_payFee"), data);
    }

    @Override
    public int repayAmount(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_repayAmount"), data);
    }

    @Override
    public int updateTakeCarApply(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_takeCarApply"), data);
    }

    @Override
    public int updateTakeCarSureFk(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_takeCarSureFk"), data);
    }

    @Override
    public int updateTakeCarInputResult(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_takeCarInputResult"),
            data);
    }

    @Override
    public int updateTakeCarResultHandle(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_takeCarResultHandle"),
            data);
    }

    @Override
    public int updatePayedDaily(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_payedDaily"), data);
    }

    @Override
    public long selectTotalCountByRoleCode(RepayPlan condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_repayPlan_count_byRoleCode"), condition);
    }

    @Override
    public List<RepayPlan> selectRepayPlanByRoleCode(RepayPlan condition,
            int start, int pageSize) {
        return super.selectList(NAMESPACE.concat("select_repayPlan_byRoleCode"),
            condition, RepayPlan.class);
    }

    @Override
    public void updateRepayPlan(RepayPlan condition) {
        super.update(NAMESPACE.concat("update_repayPlan"), condition);
    }

}
