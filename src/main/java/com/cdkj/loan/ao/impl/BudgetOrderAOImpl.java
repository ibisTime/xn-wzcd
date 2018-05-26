package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;

@Service
public class BudgetOrderAOImpl implements IBudgetOrderAO {

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Override
    public String addBudgetOrder(BudgetOrder data) {
        return budgetOrderBO.saveBudgetOrder(data);
    }

    @Override
    public void approveAreaManager(String code, String operator,
            String approveResult, String approveNote) {

    }

    @Override
    public void approveBranchCompany(String code, String operator,
            String approveResult, String approveNote) {

    }

    @Override
    public void approveGlobalManager(String code, String operator,
            String approveResult, String approveNote) {

    }

    @Override
    public void canceOrder(String code, String operator, String cancelNote) {
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition) {
        return budgetOrderBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition) {
        return budgetOrderBO.queryBudgetOrderList(condition);
    }

    @Override
    public BudgetOrder getBudgetOrder(String code) {
        return budgetOrderBO.getBudgetOrder(code);
    }
}
