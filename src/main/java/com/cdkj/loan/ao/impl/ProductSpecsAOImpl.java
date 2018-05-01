package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IProductSpecsAO;
import com.cdkj.loan.bo.IProductBO;
import com.cdkj.loan.bo.IProductSpecsBO;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.dto.req.XN808030Req;
import com.cdkj.loan.dto.req.XN808032Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Service
public class ProductSpecsAOImpl implements IProductSpecsAO {

    @Autowired
    private IProductSpecsBO productSpecsBO;

    @Autowired
    private IProductBO productBO;

    @Override
    public String addProductSpecs(XN808030Req req) {
        Integer quantity = StringValidater.toInteger(req.getQuantity());
        if (quantity <= 0) {
            throw new BizException("xn000000", "库存数量必须大于0");
        }
        Product product = productBO.getProduct(req.getProductCode());
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.PRODUCT_SPECS.getCode());
        ProductSpecs productSpecs = new ProductSpecs();
        productSpecs.setCode(code);
        productSpecs.setName(req.getName());
        productSpecs.setProductCode(product.getCode());
        productSpecs
            .setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        productSpecs.setPrice(StringValidater.toLong(req.getPrice()));
        productSpecs.setQuantity(StringValidater.toInteger(req.getQuantity()));
        productSpecs.setOrderNo(StringValidater.toInteger(req.getOrderNo()));
        productSpecsBO.saveProductSpecs(productSpecs);

        return code;
    }

    @Override
    public void editProductSpecs(XN808032Req req) {
        Integer quantity = StringValidater.toInteger(req.getQuantity());
        if (quantity <= 0) {
            throw new BizException("xn000000", "库存数量必须大于0");
        }
        ProductSpecs data = new ProductSpecs();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setOriginalPrice(StringValidater.toLong(req.getOriginalPrice()));
        data.setPrice(StringValidater.toLong(req.getPrice()));
        data.setQuantity(StringValidater.toInteger(req.getQuantity()));
        data.setOrderNo(StringValidater.toInteger(req.getOrderNo()));
        productSpecsBO.refreshProductSpecs(data);
    }

    @Override
    public void dropProductSpecs(String code) {
        productSpecsBO.removeProductSpecs(code);
    }

    @Override
    public ProductSpecs getProductSpecs(String code) {
        return productSpecsBO.getProductSpecs(code);
    }

    @Override
    public List<ProductSpecs> queryProductSpecsList(ProductSpecs condition) {
        return productSpecsBO.queryProductSpecsList(condition);
    }

}
