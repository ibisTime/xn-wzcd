package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICategoryAO;
import com.cdkj.loan.bo.ICategoryBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.Category;
import com.cdkj.loan.dto.req.XN808000Req;
import com.cdkj.loan.dto.req.XN808002Req;
import com.cdkj.loan.enums.ECategoryStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Service
public class CategoryAOImpl implements ICategoryAO {
    @Autowired
    ICategoryBO categoryBO;

    @Override
    public String addCategory(XN808000Req req) {
        Category data = new Category();
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.CATEGORY.getCode());
        data.setCode(code);
        data.setParentCode(req.getParentCode());
        data.setName(req.getName());
        data.setPic(req.getPic());
        data.setOrderNo(Integer.valueOf(req.getOrderNo()));
        data.setStatus(ECategoryStatus.TO_ON.getCode());
        categoryBO.saveCategory(data);
        return code;
    }

    @Override
    public void editCategory(XN808002Req req) {
        Category data = new Category();
        data.setCode(req.getCode());
        data.setParentCode(req.getParentCode());
        data.setName(req.getName());
        data.setPic(req.getPic());
        data.setOrderNo(Integer.valueOf(req.getOrderNo()));
        categoryBO.refreshCategory(data);
    }

    @Override
    public void putOn(String code) {
        Category category = categoryBO.getCategory(code);
        if (ECategoryStatus.ON.getCode().equals(category.getStatus())) {
            throw new BizException("xn000000", "已上架，不能再次上架");
        }
        categoryBO.putOn(code);

    }

    @Override
    public void putOff(String code) {
        Category category = categoryBO.getCategory(code);
        if (ECategoryStatus.ON.getCode().equals(category.getStatus())) {
            categoryBO.putOff(code);
        } else {
            throw new BizException("xn000000", "不是已上架状态，不能下架");
        }

    }

    @Override
    public Paginable<Category> queryCategoryPage(int start, int limit,
            Category condition) {
        return categoryBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Category> queryCategoryList(Category condition) {
        return categoryBO.queryCategoryList(condition);
    }

    @Override
    public Category getCategory(String code) {
        return categoryBO.getCategory(code);
    }

}
