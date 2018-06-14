package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.LoanCs;

//dao层 
public interface ILoanCsDAO extends IBaseDAO<LoanCs> {
    String NAMESPACE = ILoanCsDAO.class.getName().concat(".");

    public void update(LoanCs data);

}
