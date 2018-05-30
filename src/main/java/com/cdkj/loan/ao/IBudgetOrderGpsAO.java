package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderGps;

@Component
public interface IBudgetOrderGpsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBudgetOrderGps(BudgetOrderGps data);

    public int dropBudgetOrderGps(String code);

    public int editBudgetOrderGps(BudgetOrderGps data);

    public Paginable<BudgetOrderGps> queryBudgetOrderGpsPage(int start,
            int limit, BudgetOrderGps condition);

    public List<BudgetOrderGps> queryBudgetOrderGpsList(
            BudgetOrderGps condition);

    public BudgetOrderGps getBudgetOrderGps(String code);

}
