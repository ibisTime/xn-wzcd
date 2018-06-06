package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.AskForApply;

//dao层 
public interface IAskForApplyDAO extends IBaseDAO<AskForApply> {
    String NAMESPACE = IAskForApplyDAO.class.getName().concat(".");

    void updateAskForApplyStatus(AskForApply askForApply);
}
