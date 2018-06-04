package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICompProductAO;
import com.cdkj.loan.bo.ICompCategoryBO;
import com.cdkj.loan.bo.ICompProductBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CompCategory;
import com.cdkj.loan.domain.CompProduct;
import com.cdkj.loan.dto.req.XN632750Req;
import com.cdkj.loan.dto.req.XN632751Req;
import com.cdkj.loan.exception.BizException;

/**
 * 品名管理
 * @author: silver 
 * @since: 2018年6月4日 下午10:57:17 
 * @history:
 */
@Service
public class CompProductAOImpl implements ICompProductAO {
    @Autowired
    private ICompProductBO compProductBO;

    @Autowired
    private ICompCategoryBO compCategoryBO;

    @Override
    public String addCompProduct(XN632750Req req) {
        if (null == compCategoryBO.getCompCategory(req.getCategoryCode())) {
            throw new BizException("xn0000", "类型不存在！");
        }

        CompProduct data = new CompProduct();
        data.setName(req.getName());
        data.setCategoryCode(req.getCategoryCode());
        data.setModel(req.getModel());
        data.setUnit(req.getUnit());
        data.setRemark(req.getRemark());

        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        return compProductBO.saveCompProduct(data);
    }

    @Override
    public void editCompProduct(XN632751Req req) {
        if (!compProductBO.isCompProductExist(req.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        if (null == compCategoryBO.getCompCategory(req.getCategoryCode())) {
            throw new BizException("xn0000", "类型不存在！");
        }

        CompProduct data = new CompProduct();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setCategoryCode(req.getCategoryCode());
        data.setModel(req.getModel());
        data.setUnit(req.getUnit());

        data.setRemark(req.getRemark());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
    }

    @Override
    public Paginable<CompProduct> queryCompProductPage(int start, int limit,
            CompProduct condition) {
        Paginable<CompProduct> page = compProductBO.getPaginable(start, limit,
            condition);
        List<CompProduct> list = page.getList();
        for (CompProduct compProduct : list) {
            CompCategory compCategory = compCategoryBO
                .getCompCategory(compProduct.getCategoryCode());
            compProduct.setCompCategory(compCategory);
        }
        return page;
    }

    @Override
    public List<CompProduct> queryCompProductList(CompProduct condition) {
        List<CompProduct> list = compProductBO.queryCompProductList(condition);
        for (CompProduct compProduct : list) {
            CompCategory compCategory = compCategoryBO
                .getCompCategory(compProduct.getCategoryCode());
            compProduct.setCompCategory(compCategory);
        }
        return list;
    }

    @Override
    public CompProduct getCompProduct(String code) {
        CompProduct compProduct = compProductBO.getCompProduct(code);
        CompCategory compCategory = compCategoryBO
            .getCompCategory(compProduct.getCategoryCode());
        compProduct.setCompCategory(compCategory);
        return compProduct;
    }
}
