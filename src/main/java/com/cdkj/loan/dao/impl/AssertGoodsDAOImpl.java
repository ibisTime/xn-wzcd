package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IAssertGoodsDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.AssertGoods;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:55:31 
 * @history:
 */
@Repository("assertGoodsDAOImpl")
public class AssertGoodsDAOImpl extends AMybatisTemplate implements
        IAssertGoodsDAO {

    @Override
    public int insert(AssertGoods data) {
        return super.insert(NAMESPACE.concat("insert_assertGoods"), data);
    }

    @Override
    public int delete(AssertGoods data) {
        return super.delete(NAMESPACE.concat("delete_assertGoods"), data);
    }

    @Override
    public AssertGoods select(AssertGoods condition) {
        return super.select(NAMESPACE.concat("select_assertGoods"), condition,
            AssertGoods.class);
    }

    @Override
    public long selectTotalCount(AssertGoods condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_assertGoods_count"), condition);
    }

    @Override
    public List<AssertGoods> selectList(AssertGoods condition) {
        return super.selectList(NAMESPACE.concat("select_assertGoods"),
            condition, AssertGoods.class);
    }

    @Override
    public List<AssertGoods> selectList(AssertGoods condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_assertGoods"), start,
            count, condition, AssertGoods.class);
    }

    @Override
    public int update(AssertGoods data) {

        return super.update(NAMESPACE.concat("update_assertGoods"), data);
    }

}
