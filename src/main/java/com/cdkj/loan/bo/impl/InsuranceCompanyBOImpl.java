package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IInsuranceCompanyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IInsuranceCompanyDAO;
import com.cdkj.loan.domain.InsuranceCompany;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class InsuranceCompanyBOImpl extends PaginableBOImpl<InsuranceCompany>
        implements IInsuranceCompanyBO {

    @Autowired
    private IInsuranceCompanyDAO insuranceCompanyDAO;

    public String saveInsuranceCompany(InsuranceCompany data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.INSURANCECOMPANY.getCode());
            data.setCode(code);
            insuranceCompanyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeInsuranceCompany(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            InsuranceCompany data = new InsuranceCompany();
            data.setCode(code);
            count = insuranceCompanyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshInsuranceCompany(InsuranceCompany data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = insuranceCompanyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<InsuranceCompany> queryInsuranceCompanyList(
            InsuranceCompany condition) {
        return insuranceCompanyDAO.selectList(condition);
    }

    @Override
    public InsuranceCompany getInsuranceCompany(String code) {
        InsuranceCompany data = null;
        if (StringUtils.isNotBlank(code)) {
            InsuranceCompany condition = new InsuranceCompany();
            condition.setCode(code);
            data = insuranceCompanyDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "保险公司不存在");
            }
        }
        return data;
    }
}
