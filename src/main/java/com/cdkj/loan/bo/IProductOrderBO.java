package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.domain.ProductOrder;
import com.cdkj.loan.domain.ProductSpecs;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:23:54 
 * @history:
 */
public interface IProductOrderBO extends IPaginableBO<ProductOrder> {

    public String saveProductOrder(String orderCode, Product product,
            ProductSpecs productSpecs, Integer quantity);

    public List<ProductOrder> queryProductOrderList(ProductOrder data);

    public List<ProductOrder> queryProductOrderList(String orderCode);

    public ProductOrder getProductOrder(String code);
}
