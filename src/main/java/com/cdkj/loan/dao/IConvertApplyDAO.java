package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ConvertApply;

//dao层 
public interface IConvertApplyDAO extends IBaseDAO<ConvertApply> {
    String NAMESPACE = IConvertApplyDAO.class.getName().concat(".");

    int update(ConvertApply data);

    void updateConvertApplyStatus(ConvertApply data);
}
