package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICompanyClearanceDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CompanyClearance;

@Repository("companyClearanceDAOImpl")
public class CompanyClearanceDAOImpl extends AMybatisTemplate
        implements ICompanyClearanceDAO {

    @Override
    public int insert(CompanyClearance data) {
        return super.insert(NAMESPACE.concat("insert_companyClearance"), data);
    }

    @Override
    public int delete(CompanyClearance data) {
        return 0;
    }

    @Override
    public CompanyClearance select(CompanyClearance condition) {
        return super.select(NAMESPACE.concat("select_companyClearance"),
            condition, CompanyClearance.class);
    }

    @Override
    public long selectTotalCount(CompanyClearance condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_companyClearance_count"), condition);
    }

    @Override
    public List<CompanyClearance> selectList(CompanyClearance condition) {
        return super.selectList(NAMESPACE.concat("select_companyClearance"),
            condition, CompanyClearance.class);
    }

    @Override
    public List<CompanyClearance> selectList(CompanyClearance condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_companyClearance"),
            start, count, condition, CompanyClearance.class);
    }

}
