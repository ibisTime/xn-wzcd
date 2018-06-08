package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICNavigateBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICNavigateDAO;
import com.cdkj.loan.domain.CNavigate;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class CNavigateBOImpl extends PaginableBOImpl<CNavigate>
        implements ICNavigateBO {

    @Autowired
    private ICNavigateDAO cNavigateDAO;

    @Override
    public boolean isCNavigateExist(String code) {
        CNavigate condition = new CNavigate();
        condition.setCode(code);
        if (cNavigateDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCNavigate(CNavigate data) {
        String code = null;
        if (data != null) {
            if (data.getCode() == null) {
                code = OrderNoGenerater.generate(EGeneratePrefix.DH.getCode());
                data.setCode(code);
            }
            cNavigateDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCNavigate(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CNavigate data = new CNavigate();
            data.setCode(code);
            count = cNavigateDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCNavigate(CNavigate data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = cNavigateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CNavigate> queryCNavigateList(CNavigate condition) {
        return cNavigateDAO.selectList(condition);
    }

    @Override
    public CNavigate getCNavigate(String code) {
        CNavigate data = null;
        if (StringUtils.isNotBlank(code)) {
            CNavigate condition = new CNavigate();
            condition.setCode(code);
            data = cNavigateDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "导航不存在");
            }
        }
        return data;
    }
}
