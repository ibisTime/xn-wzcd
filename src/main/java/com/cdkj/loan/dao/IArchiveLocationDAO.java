package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ArchiveLocation;

//dao层 
public interface IArchiveLocationDAO extends IBaseDAO<ArchiveLocation> {
    String NAMESPACE = IArchiveLocationDAO.class.getName().concat(".");

    int update(ArchiveLocation data);
}
