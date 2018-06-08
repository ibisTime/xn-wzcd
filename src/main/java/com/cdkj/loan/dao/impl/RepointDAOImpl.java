package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRepointDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Repoint;

//CHECK 。。。 
@Repository("repointDAOImpl")
public class RepointDAOImpl extends AMybatisTemplate implements IRepointDAO {

    @Override
    public int insert(Repoint data) {
        return super.insert(NAMESPACE.concat("insert_repoint"), data);
    }

    @Override
    public int delete(Repoint data) {
        return super.delete(NAMESPACE.concat("delete_repoint"), data);
    }

    @Override
    public Repoint select(Repoint condition) {
        return super.select(NAMESPACE.concat("select_repoint"), condition,
            Repoint.class);
    }

    @Override
    public long selectTotalCount(Repoint condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_repoint_count"),
            condition);
    }

    @Override
    public List<Repoint> selectList(Repoint condition) {
        return super.selectList(NAMESPACE.concat("select_repoint"), condition,
            Repoint.class);
    }

    @Override
    public List<Repoint> selectList(Repoint condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_repoint"), start,
            count, condition, Repoint.class);
    }

    @Override
    public int update(Repoint data) {
        // TODO Auto-generated method stub
        return 0;
    }

}
