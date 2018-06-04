package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.SocialRelation;

//dao层 
public interface ISocialRelationDAO extends IBaseDAO<SocialRelation> {
    String NAMESPACE = ISocialRelationDAO.class.getName().concat(".");

    public int update(SocialRelation data);
}
