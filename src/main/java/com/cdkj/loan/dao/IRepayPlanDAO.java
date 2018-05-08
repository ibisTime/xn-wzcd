package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayPlan;

public interface IRepayPlanDAO extends IBaseDAO<RepayPlan> {
    String NAMESPACE = IRepayPlanDAO.class.getName().concat(".");

    public int update(RepayPlan data);

    public int updateStatus(RepayPlan data);

    public void insertList(List<RepayPlan> dataList);

    public int repaySuccess(RepayPlan data);

}
