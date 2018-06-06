package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.LeaveApply;

/**
 * 请假管理
 * @author: silver 
 * @since: 2018年6月5日 下午8:22:18 
 * @history:
 */
public interface ILeaveApplyBO extends IPaginableBO<LeaveApply> {

    public boolean isLeaveApplyExist(String code);

    public String saveLeaveApply(LeaveApply data);

    public void approveLeaveApply(LeaveApply data);

    public List<LeaveApply> queryLeaveApplyList(LeaveApply condition);

    public LeaveApply getLeaveApply(String code);

    public Long getTotalHour(String applyUser);
}
