package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IAssertApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.AssertApply;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:52:14 
 * @history:
 */
@Repository("assertApplyDAOImpl")
public class AssertApplyDAOImpl extends AMybatisTemplate implements
        IAssertApplyDAO {

    @Override
    public int insert(AssertApply data) {
        return super.insert(NAMESPACE.concat("insert_assertApply"), data);
    }

    @Override
    public int delete(AssertApply data) {
        return super.delete(NAMESPACE.concat("delete_assertApply"), data);
    }

    @Override
    public AssertApply select(AssertApply condition) {
        return super.select(NAMESPACE.concat("select_assertApply"), condition,
            AssertApply.class);
    }

    @Override
    public long selectTotalCount(AssertApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_assertApply_count"), condition);
    }

    @Override
    public List<AssertApply> selectList(AssertApply condition) {
        return super.selectList(NAMESPACE.concat("select_assertApply"),
            condition, AssertApply.class);
    }

    @Override
    public List<AssertApply> selectList(AssertApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_assertApply"), start,
            count, condition, AssertApply.class);
    }

    @Override
    public int update(AssertApply data) {

        return super.update(NAMESPACE.concat("update_assertApply"), data);
    }

}
