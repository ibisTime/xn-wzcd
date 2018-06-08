package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Repoint;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月8日 下午10:11:23 
 * @history:
 */
public interface IRepointDAO extends IBaseDAO<Repoint> {
    String NAMESPACE = IRepointDAO.class.getName().concat(".");

    int update(Repoint data);
}
