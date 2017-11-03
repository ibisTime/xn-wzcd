package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.FieldTimes;

public interface IFieldTimesDAO extends IBaseDAO<FieldTimes> {
    String NAMESPACE = IFieldTimesDAO.class.getName().concat(".");
}
