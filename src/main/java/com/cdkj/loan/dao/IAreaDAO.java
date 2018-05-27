package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Area;

/**
 * 身份证区域
 * @author: silver 
 * @since: 2018年5月26日 下午5:15:01 
 * @history:
 */
public interface IAreaDAO extends IBaseDAO<Area> {
    String NAMESPACE = IAreaDAO.class.getName().concat(".");

    public int updateArea(Area data);
}
