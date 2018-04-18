package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.HLOrder;

public interface IHLOrderDAO extends IBaseDAO<HLOrder> {
    String NAMESPACE = IHLOrderDAO.class.getName().concat(".");

    void approveOrder(HLOrder order);

}
