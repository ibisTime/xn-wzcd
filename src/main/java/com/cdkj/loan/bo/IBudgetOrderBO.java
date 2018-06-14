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

    // 银行放款确认提交
    public void refreshBankLoanCommit(BudgetOrder data);

    // 确认银行放款
    public void refreshBankLoanConfirm(BudgetOrder data);

    // 车辆抵押确认提交银行
    public void refreshCarPledgeCommit(BudgetOrder data);

    // 确认抵押完成
    public void refreshCarPledgeConfirm(BudgetOrder data);

    // 车贷入档补录
    public void refreshCarLoanArchive(BudgetOrder data);

    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition);

    public BudgetOrder getBudgetOrder(String code);

}
