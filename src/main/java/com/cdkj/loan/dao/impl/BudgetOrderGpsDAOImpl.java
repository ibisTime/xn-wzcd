package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBudgetOrderGpsDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BudgetOrderGps;

//CHECK 。。。 
@Repository("budgetOrderGpsDAOImpl")
public class BudgetOrderGpsDAOImpl extends AMybatisTemplate
        implements IBudgetOrderGpsDAO {

    @Override
    public int insert(BudgetOrderGps data) {
        return super.insert(NAMESPACE.concat("insert_budgetOrderGps"), data);
    }

    @Override
    public int delete(BudgetOrderGps data) {
        return super.delete(NAMESPACE.concat("delete_budgetOrderGps"), data);
    }

    @Override
    public int updateAbandonBudgetOrderGps(BudgetOrderGps data) {
        return super.update(NAMESPACE.concat("update_abandonBudgetOrderGps"),
            data);
    }

    @Override
    public BudgetOrderGps select(BudgetOrderGps condition) {
        return super.select(NAMESPACE.concat("select_budgetOrderGps"),
            condition, BudgetOrderGps.class);
    }

    @Override
    public long selectTotalCount(BudgetOrderGps condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrderGps_count"), condition);
    }

    @Override
    public List<BudgetOrderGps> selectList(BudgetOrderGps condition) {
        return super.selectList(NAMESPACE.concat("select_budgetOrderGps"),
            condition, BudgetOrderGps.class);
    }

    @Override
    public List<BudgetOrderGps> selectList(BudgetOrderGps condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_budgetOrderGps"),
            start, count, condition, BudgetOrderGps.class);
    }

}
