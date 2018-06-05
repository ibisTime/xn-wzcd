package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.WorkExperience;

public interface IWorkExperienceBO extends IPaginableBO<WorkExperience> {

    public String saveWorkExperience(WorkExperience data);

    public List<WorkExperience> queryWorkExperienceList(WorkExperience condition);

    public WorkExperience getWorkExperience(String code);

}
