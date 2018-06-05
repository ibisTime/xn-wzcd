package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILeaveApplyAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.ILeaveApplyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.LeaveApply;
import com.cdkj.loan.dto.req.XN632890Req;
import com.cdkj.loan.dto.req.XN632891Req;
import com.cdkj.loan.enums.ELeaveApplyStatus;
import com.cdkj.loan.exception.BizException;

/**
 * 请假管理
 * @author: silver 
 * @since: 2018年6月5日 下午8:27:05 
 * @history:
 */
@Service
public class LeaveApplyAOImpl implements ILeaveApplyAO {
    @Autowired
    private ILeaveApplyBO leaveApplyBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Override
    public String addLeaveApply(XN632890Req req) {
        LeaveApply data = new LeaveApply();
        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        data.setType(req.getType());
        data.setReason(req.getReason());
        data.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setTotalHour(StringValidater.toInteger(req.getTotalHour()));
        data.setPdf(req.getPdf());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setStatus(ELeaveApplyStatus.TO_APPROVE.getCode());

        return leaveApplyBO.saveLeaveApply(data);
    }

    @Override
    public void approveLeaveApply(XN632891Req req) {
        if (!leaveApplyBO.isLeaveApplyExist(req.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        LeaveApply leaveApply = leaveApplyBO.getLeaveApply(req.getCode());
        if (!ELeaveApplyStatus.TO_APPROVE.getCode()
            .equals(leaveApply.getStatus())) {
            throw new BizException("xn0000", "申请单不在待审核状态!");
        }

        LeaveApply data = new LeaveApply();
        if (req.getResult().equals(ELeaveApplyStatus.APPROVE_PASS.getCode())) {
            data.setStatus(ELeaveApplyStatus.APPROVE_PASS.getCode());
        } else if (req.getResult()
            .equals(ELeaveApplyStatus.APPROVE_FAIL.getCode())) {
            data.setStatus(ELeaveApplyStatus.APPROVE_FAIL.getCode());
        }
        data.setCode(req.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());

        leaveApplyBO.approveLeaveApply(data);
    }

    @Override
    public Paginable<LeaveApply> queryLeaveApplyPage(int start, int limit,
            LeaveApply condition) {
        Paginable<LeaveApply> page = leaveApplyBO.getPaginable(start, limit,
            condition);
        List<LeaveApply> leaveApplyList = page.getList();
        for (LeaveApply leaveApply : leaveApplyList) {
            Archive archive = new Archive();
            leaveApply.setApplyUserArchive(
                archiveBO.getArchive(leaveApply.getApplyUser()));
        }
        return page;
    }

    @Override
    public List<LeaveApply> queryLeaveApplyList(LeaveApply condition) {
        return leaveApplyBO.queryLeaveApplyList(condition);
    }

    @Override
    public LeaveApply getLeaveApply(String code) {
        LeaveApply leaveApply = leaveApplyBO.getLeaveApply(code);
        leaveApply.setApplyUserArchive(
            archiveBO.getArchive(leaveApply.getApplyUser()));
        return leaveApply;
    }
}
