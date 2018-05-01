package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRemindLogBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRemindLogDAO;
import com.cdkj.loan.domain.RemindLog;
import com.cdkj.loan.exception.BizException;

@Component
public class RemindLogBOImpl extends PaginableBOImpl<RemindLog>
        implements IRemindLogBO {

    @Autowired
    private IRemindLogDAO remindLogDAO;

    @Override
    public boolean isRemindLogExist(String code) {
        RemindLog condition = new RemindLog();
        condition.setCode(code);
        if (remindLogDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRemindLog(RemindLog data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate("RL");
            data.setCode(code);
            remindLogDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRemindLog(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            RemindLog data = new RemindLog();
            data.setCode(code);
            count = remindLogDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRemindLog(RemindLog data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = remindLogDAO.update(data);
        }
        return count;
    }

    @Override
    public List<RemindLog> queryRemindLogList(RemindLog condition) {
        return remindLogDAO.selectList(condition);
    }

    @Override
    public RemindLog getRemindLog(String code) {
        RemindLog data = null;
        if (StringUtils.isNotBlank(code)) {
            RemindLog condition = new RemindLog();
            condition.setCode(code);
            data = remindLogDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }
}
