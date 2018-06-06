package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.AssertApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:53:20 
 * @history:
 */
public interface IAssertApplyDAO extends IBaseDAO<AssertApply> {
    String NAMESPACE = IAssertApplyDAO.class.getName().concat(".");

    public int update(AssertApply data);
}
