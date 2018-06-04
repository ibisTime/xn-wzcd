package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICompProductBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICompProductDAO;
import com.cdkj.loan.domain.CompProduct;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 品名管理
 * @author: silver 
 * @since: 2018年6月4日 下午10:56:30 
 * @history:
 */
@Component
public class CompProductBOImpl extends PaginableBOImpl<CompProduct>
        implements ICompProductBO {

    @Autowired
    private ICompProductDAO CompProductDAO;

    @Override
    public boolean isCompProductExist(String code) {
        CompProduct condition = new CompProduct();
        condition.setCode(code);
        if (CompProductDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCompProduct(CompProduct data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.CompProduct.getCode());
            data.setCode(code);
            CompProductDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshCompProduct(CompProduct data) {
        if (null != data) {
            CompProductDAO.update(data);
        }
    }

    @Override
    public List<CompProduct> queryCompProductList(CompProduct condition) {
        return CompProductDAO.selectList(condition);
    }

    @Override
    public CompProduct getCompProduct(String code) {
        CompProduct data = null;
        if (StringUtils.isNotBlank(code)) {
            CompProduct condition = new CompProduct();
            condition.setCode(code);
            data = CompProductDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "品名不存在！");
            }
        }
        return data;
    }
}
