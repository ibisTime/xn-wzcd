package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBudgetOrderFeeDetailDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;

@Repository("budgetOrderFeeDetailDAOImpl")
public class BudgetOrderFeeDetailDAOImpl extends AMybatisTemplate implements
        IBudgetOrderFeeDetailDAO {

    @Override
    public int insert(BudgetOrderFeeDetail data) {
        return super.insert(NAMESPACE.concat("insert_budgetOrderFeeDetail"),
            data);
    }

    @Override
    public int delete(BudgetOrderFeeDetail data) {
        return super.delete(NAMESPACE.concat("delete_budgetOrderFeeDetail"),
            data);
    }

    @Override
    public BudgetOrderFeeDetail select(BudgetOrderFeeDetail condition) {
        return super.select(NAMESPACE.concat("select_budgetOrderFeeDetail"),
            condition, BudgetOrderFeeDetail.class);
    }

    @Override
    public long selectTotalCount(BudgetOrderFeeDetail condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrderFeeDetail_count"), condition);
    }

    @Override
    public List<BudgetOrderFeeDetail> selectList(BudgetOrderFeeDetail condition) {
        return super.selectList(
            NAMESPACE.concat("select_budgetOrderFeeDetail"), condition,
            BudgetOrderFeeDetail.class);
    }

    @Override
    public List<BudgetOrderFeeDetail> selectList(
            BudgetOrderFeeDetail condition, int start, int count) {
        return super.selectList(
            NAMESPACE.concat("select_budgetOrderFeeDetail"), start, count,
            condition, BudgetOrderFeeDetail.class);
    }

}
