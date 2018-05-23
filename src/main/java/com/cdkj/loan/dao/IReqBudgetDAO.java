package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ReqBudget;

//dao层 
public interface IReqBudgetDAO extends IBaseDAO<ReqBudget> {
    String NAMESPACE = IReqBudgetDAO.class.getName().concat(".");

    int update(ReqBudget data);

    int updateNode(ReqBudget data);

    int credit(ReqBudget data);
}
