package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBankRepointDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BankRepoint;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月10日 下午2:23:36 
 * @history:
 */
@Repository("bankRepointDAOImpl")
public class BankRepointDAOImpl extends AMybatisTemplate implements
        IBankRepointDAO {

    @Override
    public int insert(BankRepoint data) {
        return super.insert(NAMESPACE.concat("insert_bankRepoint"), data);
    }

    @Override
    public int delete(BankRepoint data) {
        return super.delete(NAMESPACE.concat("delete_bankRepoint"), data);
    }

    @Override
    public BankRepoint select(BankRepoint condition) {
        return super.select(NAMESPACE.concat("select_bankRepoint"), condition,
            BankRepoint.class);
    }

    @Override
    public long selectTotalCount(BankRepoint condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bankRepoint_count"), condition);
    }

    @Override
    public List<BankRepoint> selectList(BankRepoint condition) {
        return super.selectList(NAMESPACE.concat("select_bankRepoint"),
            condition, BankRepoint.class);
    }

    @Override
    public List<BankRepoint> selectList(BankRepoint condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_bankRepoint"), start,
            count, condition, BankRepoint.class);
    }

    @Override
    public int update(BankRepoint data) {
        return super.update(NAMESPACE.concat("update_bankRepoint"), data);
    }

}
