package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.OvertimeApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 上午8:27:05 
 * @history:
 */
public interface IOvertimeApplyDAO extends IBaseDAO<OvertimeApply> {
    String NAMESPACE = IOvertimeApplyDAO.class.getName().concat(".");

    public int update(OvertimeApply data);

    public Long selectTotalHour(OvertimeApply condition);

}
