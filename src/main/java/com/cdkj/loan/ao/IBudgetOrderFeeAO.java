package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderFee;

@Component
public interface IBudgetOrderFeeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBudgetOrderFee(BudgetOrderFee data);

    public int dropBudgetOrderFee(String code);

    public int editBudgetOrderFee(BudgetOrderFee data);

    public Paginable<BudgetOrderFee> queryBudgetOrderFeePage(int start,
            int limit, BudgetOrderFee condition);

    public List<BudgetOrderFee> queryBudgetOrderFeeList(BudgetOrderFee condition);

    public BudgetOrderFee getBudgetOrderFee(String code);

}
