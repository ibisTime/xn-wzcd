package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ITotalAdvanceFundDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.TotalAdvanceFund;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月17日 下午2:45:23 
 * @history:
 */
@Repository("totalAdvanceFundDAOImpl")
public class TotalAdvanceFundDAOImpl extends AMybatisTemplate implements
        ITotalAdvanceFundDAO {

    @Override
    public int insert(TotalAdvanceFund data) {
        return super.insert(NAMESPACE.concat("insert_totalAdvanceFund"), data);
    }

    @Override
    public int delete(TotalAdvanceFund data) {
        return super.delete(NAMESPACE.concat("delete_totalAdvanceFund"), data);
    }

    @Override
    public TotalAdvanceFund select(TotalAdvanceFund condition) {
        return super.select(NAMESPACE.concat("select_totalAdvanceFund"),
            condition, TotalAdvanceFund.class);
    }

    @Override
    public long selectTotalCount(TotalAdvanceFund condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_totalAdvanceFund_count"), condition);
    }

    @Override
    public List<TotalAdvanceFund> selectList(TotalAdvanceFund condition) {
        return super.selectList(NAMESPACE.concat("select_totalAdvanceFund"),
            condition, TotalAdvanceFund.class);
    }

    @Override
    public List<TotalAdvanceFund> selectList(TotalAdvanceFund condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_totalAdvanceFund"),
            start, count, condition, TotalAdvanceFund.class);
    }

    @Override
    public int update(TotalAdvanceFund data) {
        // TODO Auto-generated method stub
        return 0;
    }

}
