package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Province;

/**
 * 省份编号
 * @author: silver 
 * @since: 2018年5月26日 下午5:15:01 
 * @history:
 */
public interface IProvinceDAO extends IBaseDAO<Province> {
    String NAMESPACE = IProvinceDAO.class.getName().concat(".");

    public int updateProvince(Province data);
}
