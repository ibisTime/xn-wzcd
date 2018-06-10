package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ILeaveApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ILeaveApplyDAO;
import com.cdkj.loan.domain.LeaveApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 请假管理
 * @author: silver 
 * @since: 2018年6月5日 下午8:22:47 
 * @history:
 */
@Component
public class LeaveApplyBOImpl extends PaginableBOImpl<LeaveApply>
        implements ILeaveApplyBO {
    @Autowired
    private ILeaveApplyDAO leaveApplyDAO;

    @Override
    public boolean isLeaveApplyExist(String code) {
        LeaveApply condition = new LeaveApply();
        condition.setCode(code);
        if (leaveApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveLeaveApply(LeaveApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.LEAVE_APPLY.getCode());
            data.setCode(code);
            leaveApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public void approveLeaveApply(LeaveApply data) {
        if (null != data) {
            leaveApplyDAO.update(data);
        }
    }

    @Override
    public List<LeaveApply> queryLeaveApplyList(LeaveApply condition) {
        return leaveApplyDAO.selectList(condition);
    }

    @Override
    public LeaveApply getLeaveApply(String code) {
        LeaveApply data = null;
        if (StringUtils.isNotBlank(code)) {
            LeaveApply condition = new LeaveApply();
            condition.setCode(code);
            data = leaveApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "请假申请不存在");
            }
        }
        return data;
    }

    @Override
    public Long getTotalHour(String applyUser) {
        LeaveApply data = new LeaveApply();
        data.setApplyUser(applyUser);
        return leaveApplyDAO.selectTotalHour(data);
    }

    @Override
    public Long getTotalHour(String applyUser, String type, Date startDatetime,
            Date endDatetime) {
        LeaveApply data = new LeaveApply();
        data.setApplyUser(applyUser);
        data.setStartDatetime(startDatetime);
        data.setEndDatetime(endDatetime);
        data.setType(type);
        return leaveApplyDAO.selectTotalHour(data);
    }
}
