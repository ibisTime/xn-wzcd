package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.EmployApply;

public interface IEmployApplyDAO extends IBaseDAO<EmployApply> {
    String NAMESPACE = IEmployApplyDAO.class.getName().concat(".");

    public int updateInterview(EmployApply data);
}
