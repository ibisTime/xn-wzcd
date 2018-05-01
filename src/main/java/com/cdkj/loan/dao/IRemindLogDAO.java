package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RemindLog;

public interface IRemindLogDAO extends IBaseDAO<RemindLog> {
    String NAMESPACE = IRemindLogDAO.class.getName().concat(".");

    public int update(RemindLog data);
}
