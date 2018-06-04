package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRecruitApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.RecruitApply;

@Repository("recruitApplyDAOImpl")
public class RecruitApplyDAOImpl extends AMybatisTemplate implements
        IRecruitApplyDAO {

    @Override
    public int insert(RecruitApply data) {
        return super.insert(NAMESPACE.concat("insert_recruitApply"), data);
    }

    @Override
    public int delete(RecruitApply data) {
        return super.delete(NAMESPACE.concat("delete_recruitApply"), data);
    }

    @Override
    public RecruitApply select(RecruitApply condition) {
        return super.select(NAMESPACE.concat("select_recruitApply"), condition,
            RecruitApply.class);
    }

    @Override
    public long selectTotalCount(RecruitApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_recruitApply_count"), condition);
    }

    @Override
    public List<RecruitApply> selectList(RecruitApply condition) {
        return super.selectList(NAMESPACE.concat("select_recruitApply"),
            condition, RecruitApply.class);
    }

    @Override
    public List<RecruitApply> selectList(RecruitApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_recruitApply"), start,
            count, condition, RecruitApply.class);
    }

    /** 
     * @see com.cdkj.loan.dao.IRecruitApplyDAO#updateApprove(com.cdkj.loan.domain.RecruitApply)
     */
    @Override
    public int updateApprove(RecruitApply data) {
        return super.insert(NAMESPACE.concat("update_approve_recruitApply"),
            data);
    }

}
