package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CheckProject;

public interface ICheckProjectDAO extends IBaseDAO<CheckProject> {
    String NAMESPACE = ICheckProjectDAO.class.getName().concat(".");
}
