package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SYSRole;

public interface ISYSRoleDAO extends IBaseDAO<SYSRole> {
    String NAMESPACE = ISYSRoleDAO.class.getName().concat(".");

    public int update(SYSRole data);
}
