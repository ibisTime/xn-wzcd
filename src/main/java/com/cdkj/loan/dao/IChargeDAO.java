package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Charge;

public interface IChargeDAO extends IBaseDAO<Charge> {
    String NAMESPACE = IChargeDAO.class.getName().concat(".");

    void payOrder(Charge data);
}
