package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.LeaveApply;

//dao层 
public interface ILeaveApplyDAO extends IBaseDAO<LeaveApply> {
    String NAMESPACE = ILeaveApplyDAO.class.getName().concat(".");

    public void update(LeaveApply data);

    public Long selectTotalHour(LeaveApply data);
}
