package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InsuranceCompany;
import com.cdkj.loan.dto.req.XN632040Req;
import com.cdkj.loan.dto.req.XN632042Req;

@Component
public interface IInsuranceCompanyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addInsuranceCompany(XN632040Req req);

    public int dropInsuranceCompany(String code);

    public int editInsuranceCompany(XN632042Req req);

    public Paginable<InsuranceCompany> queryInsuranceCompanyPage(int start,
            int limit, InsuranceCompany condition);

    public List<InsuranceCompany> queryInsuranceCompanyList(
            InsuranceCompany condition);

    public InsuranceCompany getInsuranceCompany(String code);

}
