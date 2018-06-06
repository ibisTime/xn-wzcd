package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IAskForApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.AskForApply;

@Repository("askForApplyDAOImpl")
public class AskForApplyDAOImpl extends AMybatisTemplate
        implements IAskForApplyDAO {

    @Override
    public int insert(AskForApply data) {
        return super.insert(NAMESPACE.concat("insert_askForApply"), data);
    }

    @Override
    public int delete(AskForApply data) {
        return super.delete(NAMESPACE.concat("delete_askForApply"), data);
    }

    @Override
    public void updateAskForApplyStatus(AskForApply data) {
        super.update(NAMESPACE.concat("update_askForApplyStatus"), data);
    }

    @Override
    public AskForApply select(AskForApply condition) {
        return super.select(NAMESPACE.concat("select_askForApply"), condition,
            AskForApply.class);
    }

    @Override
    public long selectTotalCount(AskForApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_askForApply_count"), condition);
    }

    @Override
    public List<AskForApply> selectList(AskForApply condition) {
        return super.selectList(NAMESPACE.concat("select_askForApply"),
            condition, AskForApply.class);
    }

    @Override
    public List<AskForApply> selectList(AskForApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_askForApply"), start,
            count, condition, AskForApply.class);
    }

}
