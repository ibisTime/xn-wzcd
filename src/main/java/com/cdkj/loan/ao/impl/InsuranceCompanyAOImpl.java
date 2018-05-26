package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IInsuranceCompanyAO;
import com.cdkj.loan.bo.IInsuranceCompanyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InsuranceCompany;
import com.cdkj.loan.dto.req.XN632040Req;
import com.cdkj.loan.dto.req.XN632042Req;

@Service
public class InsuranceCompanyAOImpl implements IInsuranceCompanyAO {

    @Autowired
    private IInsuranceCompanyBO insuranceCompanyBO;

    @Override
    public String addInsuranceCompany(XN632040Req req) {
        InsuranceCompany data = new InsuranceCompany();
        data.setName(req.getName());
        data.setContact(req.getContact());
        data.setMobile(req.getMobile());
        data.setRemark(req.getRemark());
        return insuranceCompanyBO.saveInsuranceCompany(data);
    }

    @Override
    public int editInsuranceCompany(XN632042Req req) {
        InsuranceCompany data = insuranceCompanyBO
            .getInsuranceCompany(req.getCode());
        data.setName(req.getName());
        data.setContact(req.getContact());
        data.setMobile(req.getMobile());
        data.setRemark(req.getRemark());
        return insuranceCompanyBO.refreshInsuranceCompany(data);
    }

    @Override
    public int dropInsuranceCompany(String code) {
        return insuranceCompanyBO.removeInsuranceCompany(code);
    }

    @Override
    public Paginable<InsuranceCompany> queryInsuranceCompanyPage(int start,
            int limit, InsuranceCompany condition) {
        return insuranceCompanyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<InsuranceCompany> queryInsuranceCompanyList(
            InsuranceCompany condition) {
        return insuranceCompanyBO.queryInsuranceCompanyList(condition);
    }

    @Override
    public InsuranceCompany getInsuranceCompany(String code) {
        return insuranceCompanyBO.getInsuranceCompany(code);
    }
}
