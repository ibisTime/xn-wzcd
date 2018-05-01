package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.LoanOrder;

public interface ILoanOrderDAO extends IBaseDAO<LoanOrder> {
    String NAMESPACE = ILoanOrderDAO.class.getName().concat(".");

    public int update(LoanOrder data);
}
