package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IWorkExperienceAO;
import com.cdkj.loan.bo.IWorkExperienceBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.WorkExperience;

@Service
public class WorkExperienceAOImpl implements IWorkExperienceAO {

    @Autowired
    private IWorkExperienceBO workExperienceBO;

    @Override
    public Paginable<WorkExperience> queryWorkExperiencePage(int start,
            int limit, WorkExperience condition) {
        return workExperienceBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<WorkExperience> queryWorkExperienceList(WorkExperience condition) {
        return workExperienceBO.queryWorkExperienceList(condition);
    }

    @Override
    public WorkExperience getWorkExperience(String code) {
        return workExperienceBO.getWorkExperience(code);
    }
}
