package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRepayPlanDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.RepayPlan;

@Repository("repayPlanDAOImpl")
public class RepayPlanDAOImpl extends AMybatisTemplate implements IRepayPlanDAO {

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
        return super.selectList(NAMESPACE.concat("select_repayPlan"),
            condition, RepayPlan.class);
    }

    @Override
    public List<RepayPlan> selectList(RepayPlan condition, int start, int count) {
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
    public int repaySuccess(RepayPlan data) {
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
    public int applyTrailer(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_applyTrailer"), data);
    }

    @Override
    public int financialMoney(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_financialMoney"), data);
    }

    @Override
    public int trailerEntry(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_trailerEntry"), data);
    }

    @Override
    public int judicialLitigationEntry(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_judicialLitigationEntry"),
            data);
    }

    @Override
    public int qkcsbRedeemApply(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_qkcsbRedeemApply"), data);
    }

    @Override
    public int riskManagerCheck(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_riskManagerCheck"), data);
    }

    @Override
    public int financeApprove(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_financeApprove"), data);
    }

    @Override
    public long selectTotalCountByRoleCode(RepayPlan condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_repayPlan_count_byRoleCode"), condition);
    }

    @Override
    public List<RepayPlan> selectRepayPlanByRoleCode(RepayPlan condition,
            int start, int pageSize) {
        return super.selectList(
            NAMESPACE.concat("select_repayPlan_byRoleCode"), condition,
            RepayPlan.class);
    }

    @Override
    public int payFee(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_payFee"), data);
    }

    @Override
    public int repayAmount(RepayPlan data) {
        return super.update(NAMESPACE.concat("update_repayAmount"), data);
    }

}
