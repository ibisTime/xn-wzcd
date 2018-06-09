package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IOvertimeApplyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IOvertimeApplyDAO;
import com.cdkj.loan.domain.OvertimeApply;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月6日 上午8:25:05 
 * @history:
 */
@Component
public class OvertimeApplyBOImpl extends PaginableBOImpl<OvertimeApply>
        implements IOvertimeApplyBO {

    @Autowired
    private IOvertimeApplyDAO overtimeApplyDAO;

    @Override
    public boolean isOvertimeApplyExist(String code) {
        OvertimeApply condition = new OvertimeApply();
        condition.setCode(code);
        if (overtimeApplyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveOvertimeApply(OvertimeApply data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.OVERTIME_APPLY.getCode());
            data.setCode(code);
            overtimeApplyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeOvertimeApply(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            OvertimeApply data = new OvertimeApply();
            data.setCode(code);
            count = overtimeApplyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshOvertimeApply(OvertimeApply data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = overtimeApplyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<OvertimeApply> queryOvertimeApplyList(OvertimeApply condition) {
        return overtimeApplyDAO.selectList(condition);
    }

    @Override
    public OvertimeApply getOvertimeApply(String code) {
        OvertimeApply data = null;
        if (StringUtils.isNotBlank(code)) {
            OvertimeApply condition = new OvertimeApply();
            condition.setCode(code);
            data = overtimeApplyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public Long getOvertimeTotalHour(String applyUser, Date startDatetime,
            Date endDatetime) {
        OvertimeApply condition = new OvertimeApply();
        condition.setApplyUser(applyUser);
        condition.setStartDatetime(startDatetime);
        condition.setEndDatetime(endDatetime);
        condition.setStatus("1");
        return overtimeApplyDAO.selectTotalHour(condition);
    }
}
