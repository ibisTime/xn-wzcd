package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Archive;

//dao层 
public interface IArchiveDAO extends IBaseDAO<Archive> {
    String NAMESPACE = IArchiveDAO.class.getName().concat(".");

    public int update(Archive data);

    public int updateLeaveArchive(Archive data);

}
