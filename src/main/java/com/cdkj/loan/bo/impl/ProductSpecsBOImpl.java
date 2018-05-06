package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IProductSpecsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IProductSpecsDAO;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.dto.req.XN808030Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class ProductSpecsBOImpl extends PaginableBOImpl<ProductSpecs>
        implements IProductSpecsBO {

    @Autowired
    private IProductSpecsDAO productSpecsDAO;

    @Override
    public boolean isProductSpecsExist(String code) {
        ProductSpecs condition = new ProductSpecs();
        condition.setCode(code);
        if (productSpecsDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveProductSpecsList(List<XN808030Req> productSpecsList,
            String productCode) {
        if (CollectionUtils.isNotEmpty(productSpecsList)) {
            for (XN808030Req xn808030Req : productSpecsList) {

                String psCode = OrderNoGenerater
                    .generate(EGeneratePrefix.PRODUCT_SPECS.getCode());

                ProductSpecs productSpecs = new ProductSpecs();

                productSpecs.setCode(psCode);
                productSpecs.setName(xn808030Req.getName());
                productSpecs.setPic(xn808030Req.getPic());
                productSpecs.setProductCode(productCode);
                productSpecs.setOriginalPrice(
                    StringValidater.toLong(xn808030Req.getOriginalPrice()));

                productSpecs
                    .setPrice(StringValidater.toLong(xn808030Req.getPrice()));
                productSpecs.setSfRate(
                    StringValidater.toDouble(xn808030Req.getSfRate()));
                productSpecs.setBankRate(
                    StringValidater.toDouble(xn808030Req.getBankRate()));
                productSpecs.setPeriods(
                    StringValidater.toInteger(xn808030Req.getPeriods()));
                productSpecs.setQuantity(
                    StringValidater.toInteger(xn808030Req.getQuantity()));

                productSpecs.setProvince(xn808030Req.getProvince());
                productSpecs.setWeight(
                    StringValidater.toDouble(xn808030Req.getWeight()));
                productSpecs.setOrderNo(
                    StringValidater.toInteger(xn808030Req.getOrderNo()));

                productSpecsDAO.insert(productSpecs);
            }
        } else {
            throw new BizException("xn000000", "请至少填写一个产品规格");
        }
    }

    @Override
    public int removeProductSpecs(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ProductSpecs data = new ProductSpecs();
            data.setCode(code);
            count = productSpecsDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshProductSpecs(ProductSpecs data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = productSpecsDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ProductSpecs> queryProductSpecsList(ProductSpecs condition) {
        condition.setOrder("order_no", "asc");
        return productSpecsDAO.selectList(condition);
    }

    @Override
    public ProductSpecs getProductSpecs(String code) {
        ProductSpecs data = null;
        if (StringUtils.isNotBlank(code)) {
            ProductSpecs condition = new ProductSpecs();
            condition.setCode(code);
            data = productSpecsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "规格参数不存在");
            }
        }
        return data;
    }

    @Override
    public List<ProductSpecs> queryProductSpecsList(String productCode) {
        ProductSpecs condition = new ProductSpecs();
        condition.setProductCode(productCode);
        condition.setOrder("order_no", "asc");
        return productSpecsDAO.selectList(condition);
    }

    @Override
    public int removeProductSpecsByProductCode(String productCode) {
        ProductSpecs condition = new ProductSpecs();
        condition.setProductCode(productCode);
        return productSpecsDAO.deleteByProductCode(condition);
    }

    @Override
    public int refreshQuantity(String code, Integer quantity) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ProductSpecs data = new ProductSpecs();
            data.setCode(code);
            data.setQuantity(quantity);
            count = productSpecsDAO.updateQuantity(data);
        }
        return count;
    }

    @Override
    public void saveProductSpecs(ProductSpecs data) {
        if (null != data) {
            productSpecsDAO.insert(data);
        }
    }
}
