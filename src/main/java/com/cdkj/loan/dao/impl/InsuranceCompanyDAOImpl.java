package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IInsuranceCompanyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.InsuranceCompany;

@Repository("insuranceCompanyDAOImpl")
public class InsuranceCompanyDAOImpl extends AMybatisTemplate
        implements IInsuranceCompanyDAO {

    @Override
    public int insert(InsuranceCompany data) {
        return super.insert(NAMESPACE.concat("insert_insuranceCompany"), data);
    }

    @Override
    public int delete(InsuranceCompany data) {
        return super.delete(NAMESPACE.concat("delete_insuranceCompany"), data);
    }

    @Override
    public int update(InsuranceCompany data) {
        return super.delete(NAMESPACE.concat("update_insuranceCompany"), data);
    }

    @Override
    public InsuranceCompany select(InsuranceCompany condition) {
        return super.select(NAMESPACE.concat("select_insuranceCompany"),
            condition, InsuranceCompany.class);
    }

    @Override
    public long selectTotalCount(InsuranceCompany condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_insuranceCompany_count"), condition);
    }

    @Override
    public List<InsuranceCompany> selectList(InsuranceCompany condition) {
        return super.selectList(NAMESPACE.concat("select_insuranceCompany"),
            condition, InsuranceCompany.class);
    }

    @Override
    public List<InsuranceCompany> selectList(InsuranceCompany condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_insuranceCompany"),
            start, count, condition, InsuranceCompany.class);
    }

}
