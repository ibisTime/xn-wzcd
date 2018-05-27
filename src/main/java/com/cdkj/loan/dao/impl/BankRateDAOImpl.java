package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBankRateDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BankRate;

@Repository("bankRateDAOImpl")
public class BankRateDAOImpl extends AMybatisTemplate implements IBankRateDAO {

    @Override
    public int insert(BankRate data) {
        return super.insert(NAMESPACE.concat("insert_bankRate"), data);
    }

    @Override
    public int delete(BankRate data) {
        return super.delete(NAMESPACE.concat("delete_bankRate"), data);
    }

    @Override
    public BankRate select(BankRate condition) {
        return super.select(NAMESPACE.concat("select_bankRate"), condition,
            BankRate.class);
    }

    @Override
    public long selectTotalCount(BankRate condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_bankRate_count"),
            condition);
    }

    @Override
    public List<BankRate> selectList(BankRate condition) {
        return super.selectList(NAMESPACE.concat("select_bankRate"), condition,
            BankRate.class);
    }

    @Override
    public List<BankRate> selectList(BankRate condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bankRate"), start,
            count, condition, BankRate.class);
    }

    @Override
    public int updateBankRate(BankRate data) {
        return super.update(NAMESPACE.concat("update_bankRate"), data);
    }
}
