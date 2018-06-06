package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IFeeAdvanceApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.FeeAdvanceApply;

@Repository("feeAdvanceApplyDAOImpl")
public class FeeAdvanceApplyDAOImpl extends AMybatisTemplate implements
        IFeeAdvanceApplyDAO {

    @Override
    public int insert(FeeAdvanceApply data) {
        return super.insert(NAMESPACE.concat("insert_feeAdvanceApply"), data);
    }

    @Override
    public int delete(FeeAdvanceApply data) {
        return 0;
    }

    @Override
    public int updateApprove(FeeAdvanceApply data) {
        return super.update(NAMESPACE.concat("update_feeAdvanceApplyApprove"),
            data);
    }

    @Override
    public int updateFinanceApprove(FeeAdvanceApply data) {
        return super.update(
            NAMESPACE.concat("update_feeAdvanceApplyFinanceApprove"), data);
    }

    @Override
    public int updateFk(FeeAdvanceApply data) {
        return super.update(NAMESPACE.concat("update_feeAdvanceApplyFk"), data);
    }

    @Override
    public FeeAdvanceApply select(FeeAdvanceApply condition) {
        return super.select(NAMESPACE.concat("select_feeAdvanceApply"),
            condition, FeeAdvanceApply.class);
    }

    @Override
    public long selectTotalCount(FeeAdvanceApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_feeAdvanceApply_count"), condition);
    }

    @Override
    public List<FeeAdvanceApply> selectList(FeeAdvanceApply condition) {
        return super.selectList(NAMESPACE.concat("select_feeAdvanceApply"),
            condition, FeeAdvanceApply.class);
    }

    @Override
    public List<FeeAdvanceApply> selectList(FeeAdvanceApply condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_feeAdvanceApply"),
            start, count, condition, FeeAdvanceApply.class);
    }
}
