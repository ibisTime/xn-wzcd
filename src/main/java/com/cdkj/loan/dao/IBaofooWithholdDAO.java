package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BaofooWithhold;

public interface IBaofooWithholdDAO extends IBaseDAO<BaofooWithhold> {
    String NAMESPACE = IBaofooWithholdDAO.class.getName().concat(".");
}
