package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ISuppleSignApplyDetailDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.SuppleSignApplyDetail;

/**
 * 补签细节
 * @author: silver 
 * @since: 2018年6月6日 下午1:58:48 
 * @history:
 */
@Repository("suppleSignApplyDetailDAOImpl")
public class SuppleSignApplyDetailDAOImpl extends AMybatisTemplate
        implements ISuppleSignApplyDetailDAO {

    @Override
    public int insert(SuppleSignApplyDetail data) {
        return super.insert(NAMESPACE.concat("insert_suppleSignApplyDetail"),
            data);
    }

    @Override
    public int delete(SuppleSignApplyDetail data) {
        return super.delete(NAMESPACE.concat("delete_suppleSignApplyDetail"),
            data);
    }

    @Override
    public SuppleSignApplyDetail select(SuppleSignApplyDetail condition) {
        return super.select(NAMESPACE.concat("select_suppleSignApplyDetail"),
            condition, SuppleSignApplyDetail.class);
    }

    @Override
    public long selectTotalCount(SuppleSignApplyDetail condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_suppleSignApplyDetail_count"), condition);
    }

    @Override
    public List<SuppleSignApplyDetail> selectList(
            SuppleSignApplyDetail condition) {
        return super.selectList(
            NAMESPACE.concat("select_suppleSignApplyDetail"), condition,
            SuppleSignApplyDetail.class);
    }

    @Override
    public List<SuppleSignApplyDetail> selectList(
            SuppleSignApplyDetail condition, int start, int count) {
        return super.selectList(
            NAMESPACE.concat("select_suppleSignApplyDetail"), start, count,
            condition, SuppleSignApplyDetail.class);
    }
}
