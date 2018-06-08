/**
 * @Title OrderBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:15:46 
 * @version V1.0   
 */
package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IProductOrderBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IProductOrderDAO;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.domain.ProductOrder;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:15:46 
 * @history:
 */
@Component
public class ProductOrderBOImpl extends PaginableBOImpl<ProductOrder>
        implements IProductOrderBO {

    @Autowired
    private IProductOrderDAO productOrderDAO;

    @Override
    public String saveProductOrder(String orderCode, Product product,
            ProductSpecs productSpecs, Integer quantity) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCode(
            OrderNoGenerater.generate(EGeneratePrefix.PRODUCT_ORDER.getCode()));
        productOrder.setOrderCode(orderCode);
        productOrder.setProductCode(product.getCode());
        productOrder.setProductName(product.getName());
        productOrder.setProductSpecsCode(productSpecs.getCode());
        productOrder.setProductSpecsName(productSpecs.getName());
        productOrder.setQuantity(quantity);
        productOrder.setPrice(productSpecs.getPrice());
        productOrder.setSfRate(productSpecs.getSfRate());
        productOrder.setBankRate(productSpecs.getBankRate());
        productOrder.setPeriods(productSpecs.getPeriods());
        productOrderDAO.insert(productOrder);
        return productOrder.getCode();
    }

    @Override
    public List<ProductOrder> queryProductOrderList(ProductOrder condition) {
        return productOrderDAO.selectList(condition);
    }

    @Override
    public ProductOrder getProductOrder(String code) {
        ProductOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            ProductOrder condition = new ProductOrder();
            condition.setCode(code);
            data = productOrderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "产品关联订单不存在");
            }
        }
        return data;
    }

    @Override
    public List<ProductOrder> queryProductOrderList(String orderCode) {
        ProductOrder condition = new ProductOrder();
        condition.setOrderCode(orderCode);
        return productOrderDAO.selectList(condition);
    }

}
