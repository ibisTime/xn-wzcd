package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IReplaceRepayApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.ReplaceRepayApply;

/**
 * 代偿预算单
 * @author: silver 
 * @since: 2018年6月14日 下午9:31:45 
 * @history:
 */
@Repository("replaceRepayApplyDAOImpl")
public class ReplaceRepayApplyDAOImpl extends AMybatisTemplate
        implements IReplaceRepayApplyDAO {

    @Override
    public int insert(ReplaceRepayApply data) {
        return super.insert(NAMESPACE.concat("insert_replaceRepayApply"), data);
    }

    @Override
    public int delete(ReplaceRepayApply data) {
        return super.delete(NAMESPACE.concat("delete_replaceRepayApply"), data);
    }

    @Override
    public ReplaceRepayApply select(ReplaceRepayApply condition) {
        return super.select(NAMESPACE.concat("select_replaceRepayApply"),
            condition, ReplaceRepayApply.class);
    }

    @Override
    public long selectTotalCount(ReplaceRepayApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_replaceRepayApply_count"), condition);
    }

    @Override
    public List<ReplaceRepayApply> selectList(ReplaceRepayApply condition) {
        return super.selectList(NAMESPACE.concat("select_replaceRepayApply"),
            condition, ReplaceRepayApply.class);
    }

    @Override
    public List<ReplaceRepayApply> selectList(ReplaceRepayApply condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_replaceRepayApply"),
            start, count, condition, ReplaceRepayApply.class);
    }

    @Override
    public void updateFinanceManageApprove(ReplaceRepayApply data) {
        super.update(NAMESPACE.concat("update_financeManageApprove"), data);
    }

    @Override
    public void updateMakeDocument(ReplaceRepayApply data) {
        super.update(NAMESPACE.concat("update_makeDocument"), data);
    }

}
