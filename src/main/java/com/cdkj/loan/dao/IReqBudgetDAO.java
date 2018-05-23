package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ReqBudget;

//dao层 
public interface IReqBudgetDAO extends IBaseDAO<ReqBudget> {
    String NAMESPACE = IReqBudgetDAO.class.getName().concat(".");

    int update(ReqBudget data);

    int updateNode(ReqBudget data);

    int credit(ReqBudget data);

    List<ReqBudget> selectReqBudgetByRoleCodeList(ReqBudget condition,
            int start, int count);

    long selectTotalCountByRoleCode(ReqBudget condition);

    int updateCollection(ReqBudget data);
}
