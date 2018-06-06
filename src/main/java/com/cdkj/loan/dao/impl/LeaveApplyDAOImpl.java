package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ILeaveApplyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.LeaveApply;

/**
 * 请假管理
 * @author: silver 
 * @since: 2018年6月5日 下午8:20:50 
 * @history:
 */
@Repository("leaveApplyDAOImpl")
public class LeaveApplyDAOImpl extends AMybatisTemplate
        implements ILeaveApplyDAO {

    @Override
    public int insert(LeaveApply data) {
        return super.insert(NAMESPACE.concat("insert_LeaveApply"), data);
    }

    @Override
    public int delete(LeaveApply data) {
        return super.delete(NAMESPACE.concat("delete_LeaveApply"), data);
    }

    @Override
    public void update(LeaveApply data) {
        super.update(NAMESPACE.concat("update_LeaveApply"), data);
    }

    @Override
    public LeaveApply select(LeaveApply condition) {
        return super.select(NAMESPACE.concat("select_LeaveApply"), condition,
            LeaveApply.class);
    }

    @Override
    public long selectTotalCount(LeaveApply condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_LeaveApply_count"), condition);
    }

    @Override
    public List<LeaveApply> selectList(LeaveApply condition) {
        return super.selectList(NAMESPACE.concat("select_LeaveApply"),
            condition, LeaveApply.class);
    }

    @Override
    public List<LeaveApply> selectList(LeaveApply condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_LeaveApply"), start,
            count, condition, LeaveApply.class);
    }

    @Override
    public Long selectTotalHour(LeaveApply data) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_LeaveApply_totalHour"), data);
    }
}
