package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Notice;

//dao层 
public interface INoticeDAO extends IBaseDAO<Notice> {
    String NAMESPACE = INoticeDAO.class.getName().concat(".");

    public void update(Notice data);

}
