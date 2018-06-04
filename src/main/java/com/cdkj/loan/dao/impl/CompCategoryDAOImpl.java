package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICompCategoryDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CompCategory;

/**
 * 库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午9:49:02 
 * @history:
 */
@Repository("compCategoryDAOImpl")
public class CompCategoryDAOImpl extends AMybatisTemplate
        implements ICompCategoryDAO {

    @Override
    public int insert(CompCategory data) {
        return super.insert(NAMESPACE.concat("insert_CompCategory"), data);
    }

    @Override
    public int delete(CompCategory data) {
        return super.delete(NAMESPACE.concat("delete_CompCategory"), data);
    }

    @Override
    public void update(CompCategory data) {
        super.update(NAMESPACE.concat("update_CompCategory"), data);
    }

    @Override
    public CompCategory select(CompCategory condition) {
        return super.select(NAMESPACE.concat("select_CompCategory"), condition,
            CompCategory.class);
    }

    @Override
    public long selectTotalCount(CompCategory condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_CompCategory_count"), condition);
    }

    @Override
    public List<CompCategory> selectList(CompCategory condition) {
        return super.selectList(NAMESPACE.concat("select_CompCategory"),
            condition, CompCategory.class);
    }

    @Override
    public List<CompCategory> selectList(CompCategory condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_CompCategory"), start,
            count, condition, CompCategory.class);
    }
}
