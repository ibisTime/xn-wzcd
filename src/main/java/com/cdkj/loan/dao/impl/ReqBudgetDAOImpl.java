package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IReqBudgetDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.ReqBudget;

@Repository("reqBudgetDAOImpl")
public class ReqBudgetDAOImpl extends AMybatisTemplate
        implements IReqBudgetDAO {

    @Override
    public int insert(ReqBudget data) {
        return super.insert(NAMESPACE.concat("insert_reqBudget"), data);
    }

    @Override
    public int delete(ReqBudget data) {
        return super.delete(NAMESPACE.concat("delete_reqBudget"), data);
    }

    @Override
    public ReqBudget select(ReqBudget condition) {
        return super.select(NAMESPACE.concat("select_reqBudget"), condition,
            ReqBudget.class);
    }

    @Override
    public long selectTotalCount(ReqBudget condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_reqBudget_count"), condition);
    }

    @Override
    public List<ReqBudget> selectList(ReqBudget condition) {
        return super.selectList(NAMESPACE.concat("select_reqBudget"), condition,
            ReqBudget.class);
    }

    @Override
    public List<ReqBudget> selectList(ReqBudget condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_reqBudget"), start,
            count, condition, ReqBudget.class);
    }

    @Override
    public int update(ReqBudget data) {
        return super.update(NAMESPACE.concat("update_reqBudget"), data);
    }

    @Override
    public int collectionReqBudget(ReqBudget data) {
        return super.update(NAMESPACE.concat("update_collection"), data);
    }

    @Override
    public int updateNode(ReqBudget data) {
        return super.update(NAMESPACE.concat("update_node"), data);
    }

    @Override
    public void backRecord(ReqBudget data) {
        super.update(NAMESPACE.concat("update_backRecord"), data);
    }

    @Override
    public int loan(ReqBudget data) {
        return super.update(NAMESPACE.concat("loan"), data);
    }

    @Override
    public List<ReqBudget> selectReqBudgetByRoleCodeList(ReqBudget condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_reqBudget_roleCode"),
            start, count, condition, ReqBudget.class);
    }

    @Override
    public long selectTotalCountByRoleCode(ReqBudget condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_reqBudget_count_byRoleCode"), condition);
    }

    @Override
    public ReqBudget selectTodayReqBudget(ReqBudget condition) {
        return super.select(NAMESPACE.concat("select_today_reqBudget"),
            condition, ReqBudget.class);
    }

}
