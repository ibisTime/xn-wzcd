package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.LeaveApply;
import com.cdkj.loan.dto.req.XN632890Req;
import com.cdkj.loan.dto.req.XN632891Req;

/**
 * 请假管理
 * @author: silver 
 * @since: 2018年6月5日 下午8:19:42 
 * @history:
 */
@Component
public interface ILeaveApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addLeaveApply(XN632890Req req);

    public void approveLeaveApply(XN632891Req req);

    public Paginable<LeaveApply> queryLeaveApplyPage(int start, int limit,
            LeaveApply condition);

    public List<LeaveApply> queryLeaveApplyList(LeaveApply condition);

    public LeaveApply getLeaveApply(String code);

}
