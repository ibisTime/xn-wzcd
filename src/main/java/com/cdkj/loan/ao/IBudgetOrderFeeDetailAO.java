package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrderFeeDetail;

@Component
public interface IBudgetOrderFeeDetailAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBudgetOrderFeeDetail(BudgetOrderFeeDetail data);

    public int dropBudgetOrderFeeDetail(String code);

    public int editBudgetOrderFeeDetail(BudgetOrderFeeDetail data);

    public Paginable<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailPage(
            int start, int limit, BudgetOrderFeeDetail condition);

    public List<BudgetOrderFeeDetail> queryBudgetOrderFeeDetailList(
            BudgetOrderFeeDetail condition);

    public BudgetOrderFeeDetail getBudgetOrderFeeDetail(String code);

}
