package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ProbationAssess;

//dao层 
public interface IProbationAssessDAO extends IBaseDAO<ProbationAssess> {
    String NAMESPACE = IProbationAssessDAO.class.getName().concat(".");

    int update(ProbationAssess data);
}
