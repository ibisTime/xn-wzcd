package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SuppleSignApplyDetail;

//dao层 
public interface ISuppleSignApplyDetailDAO
        extends IBaseDAO<SuppleSignApplyDetail> {
    String NAMESPACE = ISuppleSignApplyDetailDAO.class.getName().concat(".");
}
