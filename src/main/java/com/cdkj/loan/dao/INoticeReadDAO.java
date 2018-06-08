package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.NoticeRead;

//dao层 
public interface INoticeReadDAO extends IBaseDAO<NoticeRead> {
    String NAMESPACE = INoticeReadDAO.class.getName().concat(".");

    public void update(NoticeRead data);

    public void insertNoticeReadList(List<NoticeRead> dataList);

    public void deleteNoticeReadByRef(NoticeRead condition);
}
