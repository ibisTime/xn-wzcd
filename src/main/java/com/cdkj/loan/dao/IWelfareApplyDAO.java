package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.WelfareApply;

//dao层 
public interface IWelfareApplyDAO extends IBaseDAO<WelfareApply> {
    String NAMESPACE = IWelfareApplyDAO.class.getName().concat(".");

    public void update(WelfareApply data);

}
