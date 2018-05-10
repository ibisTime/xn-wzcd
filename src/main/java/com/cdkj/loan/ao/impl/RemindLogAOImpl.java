package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IRemindLogAO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.IRemindLogBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RemindLog;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.ECollectStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class RemindLogAOImpl implements IRemindLogAO {

    @Autowired
    private IRemindLogBO remindLogBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IUserBO cUserBO;

    @Override
    public String addRemindLog(RemindLog data) {
        return remindLogBO.saveRemindLog(data);
    }

    @Override
    public int editRemindLog(RemindLog data) {
        if (!remindLogBO.isRemindLogExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return remindLogBO.refreshRemindLog(data);
    }

    @Override
    public int dropRemindLog(String code) {
        if (!remindLogBO.isRemindLogExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return remindLogBO.removeRemindLog(code);
    }

    @Override
    public Paginable<RemindLog> queryRemindLogPage(int start, int limit,
            RemindLog condition) {
        return remindLogBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<RemindLog> queryRemindLogList(RemindLog condition) {
        return remindLogBO.queryRemindLogList(condition);
    }

    @Override
    public RemindLog getRemindLog(String code) {
        return remindLogBO.getRemindLog(code);
    }

    // 催款
    @Override
    public void Collect(String code, String way) {
        if (ECollectStatus.MESSAGE_PUSH.getCode().equals(way)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "暂无消息推送！");
        }
        String userId = repayPlanBO.getRepayPlan(code).getUserId();
        String mobile = cUserBO.getUser(userId).getMobile();
        smsOutBO.sendSmsOut(mobile, "短信催收！！！");
        RemindLog remindLog = new RemindLog();
        remindLog.setRepayPlanCode(code);
        remindLog.setWay(way);
        String realName = cUserBO.getUser(userId).getRealName();
        remindLog.setToUser(realName);
        remindLog.setCreateDatetime(new Date());
        remindLogBO.saveRemindLog(remindLog);
    }
}
