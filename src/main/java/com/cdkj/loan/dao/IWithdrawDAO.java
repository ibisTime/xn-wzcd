package com.cdkj.loan.dao;

import java.math.BigDecimal;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Withdraw;

public interface IWithdrawDAO extends IBaseDAO<Withdraw> {
    String NAMESPACE = IWithdrawDAO.class.getName().concat(".");

    void approveOrder(Withdraw data);

    void payOrder(Withdraw data);

    public BigDecimal selectTotalWithdraw();

}
