package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.EmployApply;

public interface IEmployApplyBO extends IPaginableBO<EmployApply> {

    public String saveEmployApply(EmployApply data);

    public void interview(EmployApply data);

    public List<EmployApply> queryEmployApplyList(EmployApply condition);

    public EmployApply getEmployApply(String code);

}
