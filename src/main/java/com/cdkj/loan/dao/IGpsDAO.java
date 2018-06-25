package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Gps;

public interface IGpsDAO extends IBaseDAO<Gps> {
    String NAMESPACE = IGpsDAO.class.getName().concat(".");

    public int updateCompanyApprove(Gps data);

    public int updateCompanyReceive(Gps data);

    public int updateUserApply(Gps data);

    public int updateUserApprove(Gps data);

    public int updateUseStatus(Gps data);
}
