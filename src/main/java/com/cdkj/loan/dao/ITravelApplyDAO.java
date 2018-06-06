package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.TravelApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:28:55 
 * @history:
 */
public interface ITravelApplyDAO extends IBaseDAO<TravelApply> {
    String NAMESPACE = ITravelApplyDAO.class.getName().concat(".");

    public int update(TravelApply data);
}
