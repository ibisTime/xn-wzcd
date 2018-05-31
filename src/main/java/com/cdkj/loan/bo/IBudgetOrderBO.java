package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrder;

public interface IBudgetOrderBO extends IPaginableBO<BudgetOrder> {

    public String saveBudgetOrder(BudgetOrder data);

    public int removeBudgetOrder(String code);

    public void refreshBudgetOrder(BudgetOrder data);

    public void refreshriskApprove(BudgetOrder budgetOrder);

    public void interview(BudgetOrder budgetOrder);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

    public void refreshriskChargeApprove(BudgetOrder budgetOrder);

    public void refreshbizChargeApprove(BudgetOrder budgetOrder);

    public void advancefund(BudgetOrder budgetOrder);

    public void refreshGpsManagerApprove(BudgetOrder budgetOrder);

    public void installGps(BudgetOrder budgetOrder);

    public void carSettle(BudgetOrder data);

    // 确认提交银行
    public void refreshCommitBank(BudgetOrder budgetOrder);

    // 录入放款信息
    public void refreshEntryFk(BudgetOrder budgetOrder);

    // 确认放款
    public void refreshConfirmReceipt(BudgetOrder budgetOrder);

    // 录入抵押信息(寄送材料)
    public void entryMortgage(BudgetOrder data);

    // 抵押确认提交银行
    public void refreshMortgageCommitBank(BudgetOrder budgetOrder);

    // 抵押完成
    public void refreshMortgageFinish(BudgetOrder budgetOrder);

    // 确认入档
    public int archiveSuccess(BudgetOrder budgetOrder, String repayBizCode,
            String userId);

    // 物流流转
    public void logicOrder(String code);
}
