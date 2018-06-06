package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IWelfareApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.WelfareApply;

/**
 * 福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午6:55:52 
 * @history:
 */
@Repository("welfareApplyDAOImpl")
public class WelfareApplyDAOImpl extends AMybatisTemplate
        implements IWelfareApplyDAO {

    @Override
    public int insert(WelfareApply data) {
        return super.insert(NAMESPACE.concat("insert_WelfareApply"), data);
    }

    @Override
    public int delete(WelfareApply data) {
        return super.delete(NAMESPACE.concat("delete_WelfareApply"), data);
    }

    @Override
    public void update(WelfareApply data) {
        super.update(NAMESPACE.concat("update_WelfareApply"), data);
    }

    @Override
    public WelfareApply select(WelfareApply condition) {
        return super.select(NAMESPACE.concat("select_WelfareApply"), condition,
            WelfareApply.class);
    }

    @Override
    public long selectTotalCount(WelfareApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_WelfareApply_count"), condition);
    }

    @Override
    public List<WelfareApply> selectList(WelfareApply condition) {
        return super.selectList(NAMESPACE.concat("select_WelfareApply"),
            condition, WelfareApply.class);
    }

    @Override
    public List<WelfareApply> selectList(WelfareApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_WelfareApply"), start,
            count, condition, WelfareApply.class);
    }

}
