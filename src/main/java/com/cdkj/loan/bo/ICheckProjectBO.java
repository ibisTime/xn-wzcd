package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CheckProject;

public interface ICheckProjectBO extends IPaginableBO<CheckProject> {

    public String saveCheckProject(CheckProject data);

    public List<CheckProject> queryCheckProjectList(CheckProject condition);

    public CheckProject getCheckProject(String code);

}
