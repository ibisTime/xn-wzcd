package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICheckProjectDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CheckProject;

@Repository("checkProjectDAOImpl")
public class CheckProjectDAOImpl extends AMybatisTemplate implements
        ICheckProjectDAO {

    @Override
    public int insert(CheckProject data) {
        return super.insert(NAMESPACE.concat("insert_checkProject"), data);
    }

    @Override
    public int delete(CheckProject data) {
        return super.delete(NAMESPACE.concat("delete_checkProject"), data);
    }

    @Override
    public CheckProject select(CheckProject condition) {
        return super.select(NAMESPACE.concat("select_checkProject"), condition,
            CheckProject.class);
    }

    @Override
    public long selectTotalCount(CheckProject condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_checkProject_count"), condition);
    }

    @Override
    public List<CheckProject> selectList(CheckProject condition) {
        return super.selectList(NAMESPACE.concat("select_checkProject"),
            condition, CheckProject.class);
    }

    @Override
    public List<CheckProject> selectList(CheckProject condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_checkProject"), start,
            count, condition, CheckProject.class);
    }

}
