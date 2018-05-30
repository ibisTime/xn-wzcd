package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.GpsApply;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:10:21 
 * @history:
 */
public interface IGpsApplyDAO extends IBaseDAO<GpsApply> {
    String NAMESPACE = IGpsApplyDAO.class.getName().concat(".");

    public void updateGpsApplyApprove(GpsApply data);
}
