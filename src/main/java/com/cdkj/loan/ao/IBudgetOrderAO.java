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

    // 区域总经理审核
    public void approveAreaManager(String code, String operator,
            String approveResult, String approveNote);

    // 省分公司总经理审核
    public void approveBranchCompany(String code, String operator,
            String approveResult, String approveNote);

    // 二审
    public void approveGlobalManager(String code, String operator,
            String approveResult, String approveNote);

    // 申请撤销
    public void canceOrder(String code, String operator, String cancelNote);

    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

}
