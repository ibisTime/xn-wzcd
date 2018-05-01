package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ProductSpecs;

public interface IProductSpecsDAO extends IBaseDAO<ProductSpecs> {
    String NAMESPACE = IProductSpecsDAO.class.getName().concat(".");

    public int update(ProductSpecs data);

    public int deleteByProductCode(ProductSpecs data);

    public int updateQuantity(ProductSpecs data);
}
