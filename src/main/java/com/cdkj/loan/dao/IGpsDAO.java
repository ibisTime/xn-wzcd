package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Gps;

public interface IGpsDAO extends IBaseDAO<Gps> {
    String NAMESPACE = IGpsDAO.class.getName().concat(".");

    int updateApply(Gps data);

    int updateApplyStatus(Gps data);

    int updateUseStatus(Gps data);
}
