package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrder;

public interface IBudgetOrderBO extends IPaginableBO<BudgetOrder> {

    public String saveBudgetOrder(BudgetOrder data);

    public void refreshAreaManagerApprove(BudgetOrder data);

    public void refreshBranchCompanyApprove(BudgetOrder data);

    public void refreshGlobalManagerApprove(BudgetOrder data);

    public void refreshCanceOrder(BudgetOrder data);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

}
