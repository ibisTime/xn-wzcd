package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ReplaceRepayApply;

//dao层 
public interface IReplaceRepayApplyDAO extends IBaseDAO<ReplaceRepayApply> {
    String NAMESPACE = IReplaceRepayApplyDAO.class.getName().concat(".");

    public void updateFinanceManageApprove(ReplaceRepayApply data);

    public void updateMakeDocument(ReplaceRepayApply data);

}
