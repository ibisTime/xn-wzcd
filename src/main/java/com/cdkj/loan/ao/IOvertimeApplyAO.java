package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.OvertimeApply;

@Component
public interface IOvertimeApplyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addOvertimeApply(OvertimeApply data);

    public int dropOvertimeApply(String code);

    public int editOvertimeApply(OvertimeApply data);

    public Paginable<OvertimeApply> queryOvertimeApplyPage(int start,
            int limit, OvertimeApply condition);

    public List<OvertimeApply> queryOvertimeApplyList(OvertimeApply condition);

    public OvertimeApply getOvertimeApply(String code);

}
