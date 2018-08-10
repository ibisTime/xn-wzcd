package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBankRepointDetailDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BankRepointDetail;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月10日 下午2:33:06 
 * @history:
 */
@Repository("bankRepointDetailDAOImpl")
public class BankRepointDetailDAOImpl extends AMybatisTemplate implements
        IBankRepointDetailDAO {

    @Override
    public int insert(BankRepointDetail data) {
        return super.insert(NAMESPACE.concat("insert_bankRepointDetail"), data);
    }

    @Override
    public int delete(BankRepointDetail data) {
        return super.delete(NAMESPACE.concat("delete_bankRepointDetail"), data);
    }

    @Override
    public BankRepointDetail select(BankRepointDetail condition) {
        return super.select(NAMESPACE.concat("select_bankRepointDetail"),
            condition, BankRepointDetail.class);
    }

    @Override
    public long selectTotalCount(BankRepointDetail condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bankRepointDetail_count"), condition);
    }

    @Override
    public List<BankRepointDetail> selectList(BankRepointDetail condition) {
        return super.selectList(NAMESPACE.concat("select_bankRepointDetail"),
            condition, BankRepointDetail.class);
    }

    @Override
    public List<BankRepointDetail> selectList(BankRepointDetail condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bankRepointDetail"),
            start, count, condition, BankRepointDetail.class);
    }

    @Override
    public int update(BankRepointDetail data) {
        // TODO Auto-generated method stub
        return 0;
    }

}
