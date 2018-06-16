package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BudgetOrder;

public interface IBudgetOrderBO extends IPaginableBO<BudgetOrder> {

    // 征信结果生成的预算单
    public String saveBudgetOrder(BudgetOrder data);

    // 预算单页面新增预算单
    public void refresh(BudgetOrder data);

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

    public BudgetOrder getBudgetOrderByRepayBizCode(String repayBizCode);

    public void logicOrder(String code, String operator);

    // 发件，改变节点
    public void updateCurNodeCode(BudgetOrder budgetOrder);

    // 根据角色分页查
    public Object getPaginableByRoleCode(int start, int limit,
            BudgetOrder condition);

    // 制卡录入
    public void refreshCardMaking(BudgetOrder condition);

    // 发保合录入
    public void entryPreservation(BudgetOrder budgetOrder);

    // 发票不匹配申请
    public void invoiceMismatchApply(BudgetOrder budgetOrder);

    // 审核
    public void approveApply(BudgetOrder budgetOrder);

    // 二审
    public void twoApproveApply(BudgetOrder budgetOrder);

    // 应退按揭款
    public void mortgageRefund(BudgetOrder budgetOrder);

    // 作废申请
    public void applyCancel(BudgetOrder budgetOrder);

    // 作废审核
    public void cancelBizAudit(BudgetOrder budgetOrder);

}
