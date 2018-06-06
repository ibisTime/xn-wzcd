package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.FeeAdvanceApply;

public interface IFeeAdvanceApplyDAO extends IBaseDAO<FeeAdvanceApply> {
    String NAMESPACE = IFeeAdvanceApplyDAO.class.getName().concat(".");

    public int updateApprove(FeeAdvanceApply data);

    public int updateFinanceApprove(FeeAdvanceApply data);

    public int updateFk(FeeAdvanceApply data);

}
