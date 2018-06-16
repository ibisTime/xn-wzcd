package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BudgetOrder;

//dao层 
public interface IBudgetOrderDAO extends IBaseDAO<BudgetOrder> {
    String NAMESPACE = IBudgetOrderDAO.class.getName().concat(".");

    // 预算单页面新增预算单
    void update(BudgetOrder data);

    int updateAreaManagerApprove(BudgetOrder data);

    int updateBranchCompanyApprove(BudgetOrder data);

    int updateGlobalManagerApprove(BudgetOrder data);

    int updateCancelOrder(BudgetOrder data);

    // 银行放款确认提交
    public void updateBankLoanCommit(BudgetOrder data);

    // 确认银行放款
    public void updateBankLoanConfirm(BudgetOrder data);

    // 车辆抵押确认提交银行
    public void updateCarPledgeCommit(BudgetOrder data);

    // 确认抵押完成
    public void updateCarPledgeConfirm(BudgetOrder data);

    // 车贷入档补录
    public void updateCarLoanArchive(BudgetOrder data);

    // 收件审核通过，改变预算单状态
    void updaterLogicNode(BudgetOrder budgetOrder);

    // 改变节点
    void updateCurNodeCode(BudgetOrder budgetOrder);

    long selectTotalCountByRoleCode(BudgetOrder condition);

    List<BudgetOrder> selectBudgetOrderByRoleCodeList(BudgetOrder condition,
            int start, int pageSize);

    // 制卡录入
    void refreshCardMaking(BudgetOrder condition);

    // 发保合录入
    void entryPreservation(BudgetOrder budgetOrder);

    // 发票不匹配申请
    void invoiceMismatchApply(BudgetOrder budgetOrder);

    // 审核
    void approveApply(BudgetOrder budgetOrder);

    // 二审
    void twoApproveApply(BudgetOrder budgetOrder);

    // 应退按揭款
    void mortgageRefund(BudgetOrder budgetOrder);

    // 作废申请
    void applyCancel(BudgetOrder budgetOrder);
}
