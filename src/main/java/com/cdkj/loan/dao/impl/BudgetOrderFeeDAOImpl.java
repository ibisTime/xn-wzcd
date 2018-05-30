package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBudgetOrderFeeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BudgetOrderFee;

@Repository("budgetOrderFeeDAOImpl")
public class BudgetOrderFeeDAOImpl extends AMybatisTemplate implements
        IBudgetOrderFeeDAO {

    @Override
    public int insert(BudgetOrderFee data) {
        return super.insert(NAMESPACE.concat("insert_budgetOrderFee"), data);
    }

    @Override
    public int delete(BudgetOrderFee data) {
        return super.delete(NAMESPACE.concat("delete_budgetOrderFee"), data);
    }

    @Override
    public BudgetOrderFee select(BudgetOrderFee condition) {
        return super.select(NAMESPACE.concat("select_budgetOrderFee"),
            condition, BudgetOrderFee.class);
    }

    @Override
    public long selectTotalCount(BudgetOrderFee condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrderFee_count"), condition);

    }

    @Override
    public List<BudgetOrderFee> selectList(BudgetOrderFee condition) {
        return super.selectList(NAMESPACE.concat("select_budgetOrderFee"),
            condition, BudgetOrderFee.class);
    }

    @Override
    public List<BudgetOrderFee> selectList(BudgetOrderFee condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_budgetOrderFee"),
            start, count, condition, BudgetOrderFee.class);
    }

}
