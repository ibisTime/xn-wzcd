package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.dto.req.XN808030Req;
import com.cdkj.loan.dto.req.XN808032Req;

public interface IProductSpecsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addProductSpecs(XN808030Req req);

    public void dropProductSpecs(String code);

    public void editProductSpecs(XN808032Req req);

    public ProductSpecs getProductSpecs(String code);

    public List<ProductSpecs> queryProductSpecsList(ProductSpecs condition);

}
