package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IScopePeopleDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.ScopePeople;

/**
 * 公告范围
 * @author: silver 
 * @since: 2018年6月7日 下午1:58:01 
 * @history:
 */
@Repository("scopePeopleDAOImpl")
public class ScopePeopleDAOImpl extends AMybatisTemplate
        implements IScopePeopleDAO {

    @Override
    public int insert(ScopePeople data) {
        return super.insert(NAMESPACE.concat("insert_scopePeople"), data);
    }

    @Override
    public int delete(ScopePeople data) {
        return super.delete(NAMESPACE.concat("delete_scopePeople"), data);
    }

    @Override
    public ScopePeople select(ScopePeople condition) {
        return super.select(NAMESPACE.concat("select_scopePeople"), condition,
            ScopePeople.class);
    }

    @Override
    public long selectTotalCount(ScopePeople condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_scopePeople_count"), condition);
    }

    @Override
    public List<ScopePeople> selectList(ScopePeople condition) {
        return super.selectList(NAMESPACE.concat("select_scopePeople"),
            condition, ScopePeople.class);
    }

    @Override
    public List<ScopePeople> selectList(ScopePeople condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_scopePeople"), start,
            count, condition, ScopePeople.class);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void insertScopePeopleList(List<ScopePeople> dataList) {
        super.insertBatch(NAMESPACE.concat("insert_scopePeopleList"),
            (List) dataList);
    }
}
