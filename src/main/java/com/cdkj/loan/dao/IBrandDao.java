package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Brand;

public interface IBrandDao extends IBaseDAO<Brand> {
    String NAMESPACE = IBrandDao.class.getName().concat(".");

    public int update(Brand data);

    public int updateUp(Brand data);

    public int updateDown(Brand data);
}
