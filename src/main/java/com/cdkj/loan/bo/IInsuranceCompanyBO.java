package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.InsuranceCompany;




public interface IInsuranceCompanyBO extends IPaginableBO<InsuranceCompany> {


	public String saveInsuranceCompany(InsuranceCompany data);


	public int removeInsuranceCompany(String code);


	public int refreshInsuranceCompany(InsuranceCompany data);


	public List<InsuranceCompany> queryInsuranceCompanyList(InsuranceCompany condition);


	public InsuranceCompany getInsuranceCompany(String code);


}