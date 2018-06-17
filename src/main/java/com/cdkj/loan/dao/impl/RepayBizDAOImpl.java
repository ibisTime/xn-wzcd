package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRepayBizDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.RepayBiz;

@Repository("repayBizDAOImpl")
public class RepayBizDAOImpl extends AMybatisTemplate implements IRepayBizDAO {

    @Override
    public int insert(RepayBiz data) {
        return super.insert(NAMESPACE.concat("insert_repayBiz"), data);
    }

    @Override
    public int delete(RepayBiz data) {
        return 0;
    }

    @Override
    public RepayBiz select(RepayBiz condition) {
        return super.select(NAMESPACE.concat("select_repayBiz"), condition,
            RepayBiz.class);
    }

    @Override
    public long selectTotalCount(RepayBiz condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_repayBiz_count"), condition);
    }

    @Override
    public List<RepayBiz> selectList(RepayBiz condition) {
        return super.selectList(NAMESPACE.concat("select_repayBiz"), condition,
            RepayBiz.class);
    }

    @Override
    public List<RepayBiz> selectList(RepayBiz condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_repayBiz"), start,
            count, condition, RepayBiz.class);
    }

    @Override
    public int updateBankcard(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayBiz_bankcard"), data);
    }

    @Override
    public int updateRepayAll(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayAll"), data);
    }

    @Override
    public int updateEnterBlackList(RepayBiz data) {
        return super.update(NAMESPACE.concat("enter_black_list_prd"), data);
    }

    @Override
    public int updateConfirmSettledProduct(RepayBiz data) {
        return super.update(NAMESPACE.concat("confirm_settleProduct"), data);
    }

    @Override
    public int updateRepayBizRestAmount(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayBiz_restAmount"),
            data);
    }

    @Override
    public int updateRepayAllAdvance(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repayAllAdvance"), data);
    }

    @Override
    public int updateTakeCarApply(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_takeCarApply"), data);
    }

    @Override
    public int updateTakeCarRiskManageCheck(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_takeCarRiskManageCheck"),
            data);
    }

    @Override
    public int updateTakeCarCompanyManageCheck(RepayBiz data) {
        return super.update(
            NAMESPACE.concat("update_takeCarCompanyManageCheck"), data);
    }

    @Override
    public int updateTakeCarRiskLeaderCheck(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_takeCarRiskLeaderCheck"),
            data);
    }

    @Override
    public int updateTakeCarFinanceManageCheck(RepayBiz data) {
        return super.update(
            NAMESPACE.concat("update_takeCarFinanceManageCheck"), data);
    }

    @Override
    public int updateTakeCarSureFk(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_takeCarSureFk"), data);
    }

    @Override
    public int updateTakeCarInputResult(RepayBiz data) {
        return super
            .update(NAMESPACE.concat("update_takeCarInputResult"), data);
    }

    @Override
    public int updateTakeCarResultHandle(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_takeCarResultHandle"),
            data);
    }

    @Override
    public long selectTotalCountByRoleCode(RepayBiz condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_repayBiz_count_byRoleCode"), condition);
    }

    @Override
    public List<RepayBiz> selectRepayBizByRoleCode(RepayBiz condition,
            int start, int pageSize) {
        return super.selectList(NAMESPACE.concat("select_repayBiz_byRoleCode"),
            condition, RepayBiz.class);
    }

    @Override
    public int repayOverDue(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_repay_overdue"), data);
    }

    @Override
    public int updateOverdueRedHandle(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_overdueRedHandle"), data);
    }

    @Override
    public int updateJudgeApply(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_judgeApply"), data);
    }

    @Override
    public int updateJudgeFollow(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_judgeFollow"), data);
    }

    @Override
    public int updateJudgeResultInput(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_judgeResultInput"), data);
    }

    @Override
    public int updateFinanceSureReceipt(RepayBiz data) {
        return super.update(NAMESPACE.concat("update_judgeFinanceSureReceipt"),
            data);
    }
}
