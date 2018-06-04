package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RecruitApply;

//dao层 
public interface IRecruitApplyDAO extends IBaseDAO<RecruitApply> {
    String NAMESPACE = IRecruitApplyDAO.class.getName().concat(".");

    public int updateApprove(RecruitApply data);
}
