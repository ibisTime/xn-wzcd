package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.FieldTimes;

public interface IFieldTimesDAO extends IBaseDAO<FieldTimes> {
    String NAMESPACE = IFieldTimesDAO.class.getName().concat(".");
}
