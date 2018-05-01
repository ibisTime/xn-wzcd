/**
 * @Title ProductAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:37:38 
 * @version V1.0   
 */
package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IProductAO;
import com.cdkj.loan.bo.ICategoryBO;
import com.cdkj.loan.bo.IProductBO;
import com.cdkj.loan.bo.IProductSpecsBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Category;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.domain.ProductSpecs;
import com.cdkj.loan.dto.req.XN808010Req;
import com.cdkj.loan.dto.req.XN808012Req;
import com.cdkj.loan.dto.req.XN808013Req;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EProductStatus;
import com.cdkj.loan.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:37:38 
 * @history:
 */
@Service
public class ProductAOImpl implements IProductAO {

    @Autowired
    private ICategoryBO categoryBO;

    @Autowired
    private IProductBO productBO;

    @Autowired
    private IProductSpecsBO productSpecsBO;

    @Override
    @Transactional
    public String addProduct(XN808010Req req) {

        Product data = new Product();
        // 根据小类获取大类
        if (StringUtils.isNotBlank(req.getType())) {
            Category category = categoryBO.getCategory(req.getType());
            data.setCategory(category.getParentCode());
            data.setType(req.getType());
        }
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.PRODUCT.getCode());
        data.setCode(code);
        data.setName(req.getName());
        data.setSlogan(req.getSlogan());
        data.setAdvPic(req.getAdvPic());
        data.setPic(req.getPic());
        data.setDescription(req.getDescription());

        data.setStatus(EProductStatus.TO_PUBLISH.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        data.setBoughtCount(0);
        productBO.saveProduct(data);

        // 保存规格参数
        productSpecsBO.saveProductSpecsList(req.getProductSpecsList(), code);
        return code;
    }

    @Override
    @Transactional
    public void dropProduct(String code) {
        if (StringUtils.isNotBlank(code)) {
            Product product = productBO.getProduct(code);
            if (EProductStatus.TO_PUBLISH.getCode()
                .equals(product.getStatus())) {
                productBO.removeProduct(code);
                productSpecsBO.removeProductSpecsByProductCode(code);
            } else {
                throw new BizException("xn000000", "产品已上架过，不能删除");
            }
        }
    }

    @Override
    @Transactional
    public void editProduct(XN808012Req req) {
        Product data = productBO.getProduct(req.getCode());
        if (EProductStatus.PUBLISH_YES.getCode().equals(data.getStatus())) {
            throw new BizException("xn000000", "该产品已上架，请先下架");
        }
        // 根据小类获取大类
        if (StringUtils.isNotBlank(req.getType())) {
            Category category = categoryBO.getCategory(req.getType());
            data.setCategory(category.getParentCode());
            data.setType(req.getType());
        }
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setSlogan(req.getSlogan());
        data.setAdvPic(req.getAdvPic());
        data.setPic(req.getPic());
        data.setDescription(req.getDescription());

        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        productBO.refreshProduct(data);

        // 删除原来的规格参数，重新插入
        productSpecsBO.removeProductSpecsByProductCode(req.getCode());

        // 保存规格参数
        productSpecsBO.saveProductSpecsList(req.getProductSpecsList(),
            data.getCode());
    }

    @Override
    public void putOn(XN808013Req req) {
        String code = req.getCode();
        Product dbProduct = productBO.getProduct(code);
        // 已提交，审核通过，已下架状态可上架；
        if (EProductStatus.TO_PUBLISH.getCode().equals(dbProduct.getStatus())
                || EProductStatus.PUBLISH_NO.getCode()
                    .equals(dbProduct.getStatus())) {
            List<ProductSpecs> productSpecsList = productSpecsBO
                .queryProductSpecsList(code);
            if (CollectionUtils.isEmpty(productSpecsList)) {
                throw new BizException("xn000000", "产品规格为空，请先添加");
            }
            Product product = new Product();
            product.setCode(code);
            product.setLocation(req.getLocation());
            product.setOrderNo(StringValidater.toInteger(req.getOrderNo()));
            product.setUpdater(req.getUpdater());
            product.setUpdateDatetime(new Date());
            product.setStatus(EProductStatus.PUBLISH_YES.getCode());
            product.setRemark(req.getRemark());
            productBO.putOn(product);
        } else {
            throw new BizException("xn000000", "该产品状态不符合上架条件，无法上架");
        }

    }

    @Override
    public void putOff(String code, String updater, String remark) {
        Product dbProduct = productBO.getProduct(code);
        if (EProductStatus.PUBLISH_YES.getCode()
            .equals(dbProduct.getStatus())) {
            productBO.putOff(code, updater, remark);
        } else {
            throw new BizException("xn000000", "该产品不是上架状态，无法下架");
        }
    }

    @Override
    public void inRecyle(String code, String updater, String remark) {
        Product dbProduct = productBO.getProduct(code);
        if (EProductStatus.TO_PUBLISH.getCode().equals(dbProduct.getStatus())
                || EProductStatus.PUBLISH_NO.getCode()
                    .equals(dbProduct.getStatus())) {
            Product product = new Product();
            product.setCode(code);
            product.setStatus(EProductStatus.RECYCLE.getCode());
            product.setUpdater(updater);
            product.setUpdateDatetime(new Date());
            product.setRemark(remark);
            productBO.putRecycleOnOff(product);
        } else {
            throw new BizException("xn000000", "该产品不是下架状态，不能进回收站");
        }
    }

    @Override
    public void outRecyle(String code, String updater, String remark) {
        Product dbProduct = productBO.getProduct(code);
        if (EProductStatus.RECYCLE.getCode().equals(dbProduct.getStatus())) {
            Product product = new Product();
            product.setCode(code);
            product.setStatus(EProductStatus.TO_PUBLISH.getCode());
            product.setUpdater(updater);
            product.setUpdateDatetime(new Date());
            product.setRemark(remark);
            productBO.putRecycleOnOff(product);
        } else {
            throw new BizException("xn000000", "该产品不是回收状态，不能还原");
        }
    }

    @Override
    public Paginable<Product> queryProductPage(int start, int limit,
            Product condition, String userId) {
        Paginable<Product> results = productBO.getPaginable(start, limit,
            condition);
        if (CollectionUtils.isNotEmpty(results.getList())) {
            for (Product product : results.getList()) {
                List<ProductSpecs> productSpecsList = productSpecsBO
                    .queryProductSpecsList(product.getCode());
                product.setProductSpecsList(productSpecsList);
            }
        }
        return results;
    }

    @Override
    public List<Product> queryProductList(Product condition) {
        return productBO.queryProductList(condition);
    }

    @Override
    public Product getProduct(String code, String userId) {
        Product product = productBO.getProduct(code);
        if (null != product) {
            List<ProductSpecs> productSpecsList = productSpecsBO
                .queryProductSpecsList(code);
            product.setProductSpecsList(productSpecsList);
        }
        return product;
    }
}
