package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SuppleSignApply;

public interface ISuppleSignApplyDAO extends IBaseDAO<SuppleSignApply> {
    String NAMESPACE = ISuppleSignApplyDAO.class.getName().concat(".");

    public void update(SuppleSignApply data);

}
