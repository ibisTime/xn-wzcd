package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISuppleSignApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SuppleSignApply;

/**
 * 补签
 * @author: silver 
 * @since: 2018年6月5日 下午10:54:40 
 * @history:
 */
@Repository("suppleSignApplyDAOImpl")
public class SuppleSignApplyDAOImpl extends AMybatisTemplate
        implements ISuppleSignApplyDAO {

    @Override
    public int insert(SuppleSignApply data) {
        return super.insert(NAMESPACE.concat("insert_suppleSignApply"), data);
    }

    @Override
    public int delete(SuppleSignApply data) {
        return super.delete(NAMESPACE.concat("delete_suppleSignApply"), data);
    }

    @Override
    public void update(SuppleSignApply data) {
        super.update(NAMESPACE.concat("update_suppleSignApply"), data);
    }

    @Override
    public SuppleSignApply select(SuppleSignApply condition) {
        return super.select(NAMESPACE.concat("select_suppleSignApply"),
            condition, SuppleSignApply.class);
    }

    @Override
    public long selectTotalCount(SuppleSignApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_suppleSignApply_count"), condition);
    }

    @Override
    public List<SuppleSignApply> selectList(SuppleSignApply condition) {
        return super.selectList(NAMESPACE.concat("select_suppleSignApply"),
            condition, SuppleSignApply.class);
    }

    @Override
    public List<SuppleSignApply> selectList(SuppleSignApply condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_suppleSignApply"),
            start, count, condition, SuppleSignApply.class);
    }

}
