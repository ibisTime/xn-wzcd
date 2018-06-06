package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBudgetOrderGpsAO;
import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderGps;

@Service
public class BudgetOrderGpsAOImpl implements IBudgetOrderGpsAO {

    @Autowired
    private IBudgetOrderGpsBO budgetOrderGpsBO;

    @Override
    public Paginable<BudgetOrderGps> queryBudgetOrderGpsPage(int start,
            int limit, BudgetOrderGps condition) {
        return budgetOrderGpsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BudgetOrderGps> queryBudgetOrderGpsList(BudgetOrderGps condition) {
        return budgetOrderGpsBO.queryBudgetOrderGpsList(condition);
    }

    @Override
    public BudgetOrderGps getBudgetOrderGps(String code) {
        return budgetOrderGpsBO.getBudgetOrderGps(code);
    }
}
