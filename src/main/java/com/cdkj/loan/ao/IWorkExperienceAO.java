package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.WorkExperience;

@Component
public interface IWorkExperienceAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<WorkExperience> queryWorkExperiencePage(int start,
            int limit, WorkExperience condition);

    public List<WorkExperience> queryWorkExperienceList(WorkExperience condition);

    public WorkExperience getWorkExperience(String code);

}
