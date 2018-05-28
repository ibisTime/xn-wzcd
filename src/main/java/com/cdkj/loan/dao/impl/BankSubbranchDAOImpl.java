package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBankSubbranchDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BankSubbranch;

/**
 * 支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:50:36 
 * @history:
 */
@Repository("bankSubbranchDAOImpl")
public class BankSubbranchDAOImpl extends AMybatisTemplate
        implements IBankSubbranchDAO {

    @Override
    public int insert(BankSubbranch data) {
        return super.insert(NAMESPACE.concat("insert_bankSubbranch"), data);
    }

    @Override
    public int delete(BankSubbranch data) {
        return super.delete(NAMESPACE.concat("delete_bankSubbranch"), data);
    }

    @Override
    public BankSubbranch select(BankSubbranch condition) {
        return super.select(NAMESPACE.concat("select_bankSubbranch"), condition,
            BankSubbranch.class);
    }

    @Override
    public long selectTotalCount(BankSubbranch condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bankSubbranch_count"), condition);
    }

    @Override
    public List<BankSubbranch> selectList(BankSubbranch condition) {
        return super.selectList(NAMESPACE.concat("select_bankSubbranch"),
            condition, BankSubbranch.class);
    }

    @Override
    public List<BankSubbranch> selectList(BankSubbranch condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_bankSubbranch"), start,
            count, condition, BankSubbranch.class);
    }

    @Override
    public int updateBankSubbranch(BankSubbranch data) {
        return super.update(NAMESPACE.concat("update_bankSubbranch"), data);
    }

    @Override
    public long selectBankSubbranchMaxid(BankSubbranch condition) {
        return super.select(NAMESPACE.concat("select_bankSubbranch_maxId"),
            condition, Long.class);
    }
}
