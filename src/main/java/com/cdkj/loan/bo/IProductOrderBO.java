package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.ProductOrder;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:23:54 
 * @history:
 */
public interface IProductOrderBO extends IPaginableBO<ProductOrder> {

    public String saveProductOrder(String orderCode, String productCode,
            String productSpecsCode, Integer quantity, Long price,
            String systemCode);

    public List<ProductOrder> queryProductOrderList(ProductOrder data);

    public List<ProductOrder> queryProductOrderList(String orderCode);

    public ProductOrder getProductOrder(String code);
}
