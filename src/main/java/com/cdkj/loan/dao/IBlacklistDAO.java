package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Blacklist;

public interface IBlacklistDAO extends IBaseDAO<Blacklist> {
    String NAMESPACE = IBlacklistDAO.class.getName().concat(".");
}
