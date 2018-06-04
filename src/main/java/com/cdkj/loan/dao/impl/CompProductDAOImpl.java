package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICompProductDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CompProduct;

/**
 * 品名管理
 * @author: silver 
 * @since: 2018年6月4日 下午10:52:12 
 * @history:
 */
@Repository("compProductDAOImpl")
public class CompProductDAOImpl extends AMybatisTemplate
        implements ICompProductDAO {

    @Override
    public int insert(CompProduct data) {
        return super.insert(NAMESPACE.concat("insert_CompProduct"), data);
    }

    @Override
    public int delete(CompProduct data) {
        return super.delete(NAMESPACE.concat("delete_CompProduct"), data);
    }

    @Override
    public void update(CompProduct data) {
        super.update(NAMESPACE.concat("update_CompProduct"), data);
    }

    @Override
    public CompProduct select(CompProduct condition) {
        return super.select(NAMESPACE.concat("select_CompProduct"), condition,
            CompProduct.class);
    }

    @Override
    public long selectTotalCount(CompProduct condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_CompProduct_count"), condition);
    }

    @Override
    public List<CompProduct> selectList(CompProduct condition) {
        return super.selectList(NAMESPACE.concat("select_CompProduct"),
            condition, CompProduct.class);
    }

    @Override
    public List<CompProduct> selectList(CompProduct condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_CompProduct"), start,
            count, condition, CompProduct.class);
    }
}
