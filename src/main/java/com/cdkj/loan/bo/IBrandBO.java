package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Brand;

public interface IBrandBO extends IPaginableBO<Brand> {

    public String saveBrand(Brand data);

    public Brand getBrand(String code);

    public void removeBrand(Brand data);

    public int editBrand(Brand data);

    public List<Brand> queryBrand(Brand condition);

    public Brand getBrandByBrandId(String brandId);
}
