package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.bo.IBrandBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.dto.req.XN630400Req;
import com.cdkj.loan.dto.req.XN630402Req;
import com.cdkj.loan.enums.EBrandStatus;
import com.cdkj.loan.exception.BizException;

public class BrandAOImpl implements IBrandAO {

    @Autowired
    private IBrandBO brandBO;

    @Override
    public String addBrand(XN630400Req req) {
        Brand brand = new Brand();
        brand.setDescript(req.getDescription());
        brand.setLetter(req.getLetter());
        brand.setLogo(req.getLogo());
        brand.setName(req.getName());
        brand.setRemark(req.getRemark());
        brand.setUpdater(req.getUpdater());
        brand.setUpdaterDatetime(new Date());
        brand.setStatus(EBrandStatus.TO_UP.getCode());
        return brandBO.saveBrand(brand);
    }

    @Override
    public void editBrand(XN630402Req req) {
        Brand brand = brandBO.getBrand(req.getCode());
        if (EBrandStatus.UP.getCode().equals(brand.getStatus())) {
            throw new BizException("xn0000", "品牌已上架，请在下架后修改");
        }
        brand.setLogo(req.getLogo());
        brand.setName(req.getName());
        brand.setDescript(req.getDescription());
        brand.setUpdater(req.getUpdater());
        brand.setRemark(req.getRemark());

    }

    @Override
    public void upBrand(String code, String updater, String remark) {
        Brand brand = brandBO.getBrand(code);
        brand.setStatus(EBrandStatus.UP.getCode());
    }

    @Override
    public void downBrand(String code, String updater, String remark) {
        Brand brand = brandBO.getBrand(code);
        brand.setStatus(EBrandStatus.DOWN.getCode());
    }

    @Override
    public Paginable<Brand> queryBrandPage(int start, int limit,
            Brand condition) {
        return brandBO.getPaginable(start, limit, condition);
    }

    @Override
    public Brand queryBranddeta(String code) {
        return brandBO.getBrand(code);
    }

    @Override
    public List<Brand> queryBrandList(Brand condition) {
        return brandBO.queryBrand(condition);
    }

}
