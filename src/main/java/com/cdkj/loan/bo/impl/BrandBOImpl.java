package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBrandBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBrandDAO;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BrandBOImpl extends PaginableBOImpl<Brand> implements IBrandBO {

    @Autowired
    private IBrandDAO brandDAO;

    @Override
    public long getTotalCount(Brand condition) {
        return brandDAO.selectTotalCount(condition);
    }

    @Override
    public String saveBrand(Brand data) {
        String code = null;
        if (data != null) {
            if (data.getCode() == null) {
                code = OrderNoGenerater
                    .generate(EGeneratePrefix.Brand.getCode());
                data.setCode(code);
            }
            brandDAO.insert(data);
        }
        return code;
    }

    @Override
    public int editBrand(Brand data) {

        return brandDAO.update(data);
    }

    @Override
    public Brand getBrand(String code) {
        Brand data = null;
        if (StringUtils.isNotBlank(code)) {
            Brand condition = new Brand();
            condition.setCode(code);
            data = brandDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该编号不存在");
            }
        }
        return data;
    }

    @Override
    public List<Brand> queryBrand(Brand condition) {
        return brandDAO.selectList(condition);
    }

}
