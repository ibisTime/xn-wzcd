package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.WorkExperience;

public interface IWorkExperienceDAO extends IBaseDAO<WorkExperience> {
    String NAMESPACE = IWorkExperienceDAO.class.getName().concat(".");
}
