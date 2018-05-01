package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayPlan;

public interface IRepayPlanDAO extends IBaseDAO<RepayPlan> {
    String NAMESPACE = IRepayPlanDAO.class.getName().concat(".");

    public int update(RepayPlan data);
}
