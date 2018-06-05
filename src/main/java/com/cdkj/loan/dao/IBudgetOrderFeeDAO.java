package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BudgetOrderFee;

//dao层 
public interface IBudgetOrderFeeDAO extends IBaseDAO<BudgetOrderFee> {
    String NAMESPACE = IBudgetOrderFeeDAO.class.getName().concat(".");

    public int updateBudgetOrderFeeRealAmount(BudgetOrderFee data);
}
