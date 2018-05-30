package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBankDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Bank;

@Repository("bankDAOImpl")
public class BankDAOImpl extends AMybatisTemplate implements IBankDAO {

    @Override
    public int insert(Bank data) {
        return super.insert(NAMESPACE.concat("insert_bank"), data);
    }

    @Override
    public int delete(Bank data) {
        return super.delete(NAMESPACE.concat("delete_bank"), data);
    }

    @Override
    public Bank select(Bank condition) {
        return super.select(NAMESPACE.concat("select_bank"), condition,
            Bank.class);
    }

    @Override
    public long selectTotalCount(Bank condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_bank_count"),
            condition);
    }

    @Override
    public List<Bank> selectList(Bank condition) {
        return super.selectList(NAMESPACE.concat("select_bank"), condition,
            Bank.class);
    }

    @Override
    public List<Bank> selectList(Bank condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bank"), start, count,
            condition, Bank.class);
    }

    @Override
    public int updateBank(Bank data) {
        return super.update(NAMESPACE.concat("update_bank"), data);
    }

}
