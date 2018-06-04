package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICompCategoryBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICompCategoryDAO;
import com.cdkj.loan.domain.CompCategory;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午9:50:03 
 * @history:
 */
@Component
public class CompCategoryBOImpl extends PaginableBOImpl<CompCategory>
        implements ICompCategoryBO {

    @Autowired
    private ICompCategoryDAO compCategoryDAO;

    @Override
    public boolean isCompCategoryExist(String code) {
        CompCategory condition = new CompCategory();
        condition.setCode(code);
        if (compCategoryDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCompCategory(CompCategory data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.CompCategory.getCode());
            data.setCode(code);
            compCategoryDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshCompCategory(CompCategory data) {
        if (data != null) {
            compCategoryDAO.update(data);
        }
    }

    @Override
    public List<CompCategory> queryCompCategoryList(CompCategory condition) {
        return compCategoryDAO.selectList(condition);
    }

    @Override
    public CompCategory getCompCategory(String code) {
        CompCategory data = null;
        if (StringUtils.isNotBlank(code)) {
            CompCategory condition = new CompCategory();
            condition.setCode(code);
            data = compCategoryDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "库存类别不存在！");
            }
        }
        return data;
    }
}
