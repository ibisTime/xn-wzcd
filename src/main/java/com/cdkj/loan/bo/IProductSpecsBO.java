package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.dto.req.XN808030Req;

public interface IProductSpecsBO extends IPaginableBO<ProductSpecs> {

    public boolean isProductSpecsExist(String code);

    public void saveProductSpecsList(List<XN808030Req> productSpecsList,
            String productCode);

    public void saveProductSpecs(ProductSpecs data);

    public int removeProductSpecs(String code);

    public int refreshProductSpecs(ProductSpecs data);

    public List<ProductSpecs> queryProductSpecsList(ProductSpecs condition);

    public ProductSpecs getProductSpecs(String code);

    public List<ProductSpecs> queryProductSpecsList(String productCode);

    public int removeProductSpecsByProductCode(String code);

    public int refreshQuantity(String code, Integer quantity);

}
