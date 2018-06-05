package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.EntryApply;

//dao层 
public interface IEntryApplyDAO extends IBaseDAO<EntryApply> {
    String NAMESPACE = IEntryApplyDAO.class.getName().concat(".");

    void updateEntryApplyStatus(EntryApply entryApply);
}
