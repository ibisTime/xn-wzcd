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

}
