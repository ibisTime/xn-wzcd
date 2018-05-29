package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632120Req;

@Component
public interface IBudgetOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBudgetOrder(XN632120Req req);

    public int dropBudgetOrder(String code);

    public int editBudgetOrder(BudgetOrder data);

    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    public String audit(String code, String approveResult, String approveNote,
            String operator);

}
