package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BudgetOrder;

//dao层 
public interface IBudgetOrderDAO extends IBaseDAO<BudgetOrder> {
    String NAMESPACE = IBudgetOrderDAO.class.getName().concat(".");

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
}
