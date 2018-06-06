package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IAssertUserDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.AssertUser;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 下午7:57:37 
 * @history:
 */
@Repository("assertUserDAOImpl")
public class AssertUserDAOImpl extends AMybatisTemplate implements
        IAssertUserDAO {

    @Override
    public int insert(AssertUser data) {
        return super.insert(NAMESPACE.concat("insert_assertUser"), data);
    }

    @Override
    public int delete(AssertUser data) {
        return super.delete(NAMESPACE.concat("delete_assertUser"), data);
    }

    @Override
    public AssertUser select(AssertUser condition) {
        return super.select(NAMESPACE.concat("select_assertUser"), condition,
            AssertUser.class);
    }

    @Override
    public long selectTotalCount(AssertUser condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_assertUser_count"), condition);
    }

    @Override
    public List<AssertUser> selectList(AssertUser condition) {
        return super.selectList(NAMESPACE.concat("select_assertUser"),
            condition, AssertUser.class);
    }

    @Override
    public List<AssertUser> selectList(AssertUser condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_assertUser"), start,
            count, condition, AssertUser.class);
    }

    @Override
    public int update(AssertUser data) {

        return super.update(NAMESPACE.concat("update_assertUser"), data);
    }

}
