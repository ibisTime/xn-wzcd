package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BudgetOrder;

//dao层 
public interface IBudgetOrderDAO extends IBaseDAO<BudgetOrder> {
    String NAMESPACE = IBudgetOrderDAO.class.getName().concat(".");

    void update(BudgetOrder data);

    void updaterIskApprove(BudgetOrder data);

    void updaterInterview(BudgetOrder data);

    void updaterIskChargeApprove(BudgetOrder data);

    void updaterBizChargeApprove(BudgetOrder data);

    void updaterAdvancefund(BudgetOrder data);

    void updaterGpsManagerApprove(BudgetOrder data);

    void updaterInstallGps(BudgetOrder data);

    void updaterCarSettle(BudgetOrder data);

    int updateArchiveSuccess(BudgetOrder data);

    void updaterCommitBank(BudgetOrder data);

    void updaterConfirmLoan(BudgetOrder data);

    void updaterEntryLoan(BudgetOrder data);

    void updaterEntryMortgage(BudgetOrder data);

    void updaterMortgageCommitBank(BudgetOrder data);

    void updaterMortgageFinish(BudgetOrder data);

    void updaterLogicNode(BudgetOrder data);
}
