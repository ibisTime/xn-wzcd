package com.cdkj.loan.bo;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.OvertimeApply;

public interface IOvertimeApplyBO extends IPaginableBO<OvertimeApply> {

    public boolean isOvertimeApplyExist(String code);

    public String saveOvertimeApply(OvertimeApply data);

    public int removeOvertimeApply(String code);

    public int refreshOvertimeApply(OvertimeApply data);

    public List<OvertimeApply> queryOvertimeApplyList(OvertimeApply condition);

    public OvertimeApply getOvertimeApply(String code);

    public Long getOvertimeTotalHour(String applyUser, Date startDatetime,
            Date endDatetime);
}
