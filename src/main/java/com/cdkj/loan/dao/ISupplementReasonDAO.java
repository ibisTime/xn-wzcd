package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SupplementReason;

//dao层 
public interface ISupplementReasonDAO extends IBaseDAO<SupplementReason> {
    String NAMESPACE = ISupplementReasonDAO.class.getName().concat(".");

    void updateSupplementReason(SupplementReason reason);

    // 改变原来的补件原因的物流单编号
    void updateLogisticsCode(SupplementReason reason);

}
