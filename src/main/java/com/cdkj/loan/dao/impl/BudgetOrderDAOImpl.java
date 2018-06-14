package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBudgetOrderDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BudgetOrder;

@Repository("budgetOrderDAOImpl")
public class BudgetOrderDAOImpl extends AMybatisTemplate
        implements IBudgetOrderDAO {

    @Override
    public int insert(BudgetOrder data) {
        return super.insert(NAMESPACE.concat("insert_budgetOrder"), data);
    }

    @Override
    public int delete(BudgetOrder data) {
        return super.delete(NAMESPACE.concat("delete_budgetOrder"), data);
    }

    @Override
    public int updateAreaManagerApprove(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_areaManagerApprove"),
            data);
    }

    @Override
    public int updateBranchCompanyApprove(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_branchCompanyApprove"),
            data);

    }

    @Override
    public int updateGlobalManagerApprove(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_globalCompanyApprove"),
            data);
    }

    @Override
    public int updateCancelOrder(BudgetOrder data) {
        return super.update(NAMESPACE.concat("update_cancelOrder"), data);
    }

    @Override
    public BudgetOrder select(BudgetOrder condition) {
        return super.select(NAMESPACE.concat("select_budgetOrder"), condition,
            BudgetOrder.class);
    }

    @Override
    public long selectTotalCount(BudgetOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_budgetOrder_count"), condition);
    }

    @Override
    public List<BudgetOrder> selectList(BudgetOrder condition) {
        return super.selectList(NAMESPACE.concat("select_budgetOrderList"),
            condition, BudgetOrder.class);
    }

    @Override
    public List<BudgetOrder> selectList(BudgetOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_budgetOrderList"),
            start, count, condition, BudgetOrder.class);
    }

    @Override
    public void updateBankLoanCommit(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_bankLoanCommit"), data);
    }

    @Override
    public void updateBankLoanConfirm(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_bankLoanConfirm"), data);
    }

    @Override
    public void updateCarPledgeCommit(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_carPledgeCommit"), data);
    }

    @Override
    public void updateCarPledgeConfirm(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_carPledgeConfirm"), data);
    }

    @Override
    public void updateCarLoanArchive(BudgetOrder data) {
        super.update(NAMESPACE.concat("update_carLoanArchive"), data);
    }

}
