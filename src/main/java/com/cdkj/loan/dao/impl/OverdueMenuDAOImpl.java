package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IOverdueMenuDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.OverdueMenu;

@Repository("overdueMenuDAOImpl")
public class OverdueMenuDAOImpl extends AMybatisTemplate
        implements IOverdueMenuDAO {

    @Override
    public int insert(OverdueMenu data) {
        return super.insert(NAMESPACE.concat("insert_overdueMenu"), data);
    }

    @Override
    public int delete(OverdueMenu data) {
        return super.delete(NAMESPACE.concat("delete_overdueMenu"), data);
    }

    @Override
    public int update(OverdueMenu data) {
        return super.update(NAMESPACE.concat("update_overdueMenu"), data);
    }

    @Override
    public OverdueMenu select(OverdueMenu condition) {
        return super.select(NAMESPACE.concat("select_overdueMenu"), condition,
            OverdueMenu.class);
    }

    @Override
    public long selectTotalCount(OverdueMenu condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_overdueMenu_count"), condition);
    }

    @Override
    public List<OverdueMenu> selectList(OverdueMenu condition) {
        return super.selectList(NAMESPACE.concat("select_overdueMenu"),
            condition, OverdueMenu.class);
    }

    @Override
    public List<OverdueMenu> selectList(OverdueMenu condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_overdueMenu"), start,
            count, condition, OverdueMenu.class);
    }

}
