package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.LoanOrder;

public interface ILoanOrderBO extends IPaginableBO<LoanOrder> {

    public boolean isLoanOrderExist(String code);

    public String saveLoanOrder(LoanOrder data);

    public int refreshLoanOrder(LoanOrder data);

    public int approveSuccess(LoanOrder data, String repayBizCode,
            String userId, String approveUser, String approveNote);

    public int approveFailed(LoanOrder data, String approveUser,
            String approveNote);

    public List<LoanOrder> queryLoanOrderList(LoanOrder condition);

    public LoanOrder getLoanOrder(String code);

    public LoanOrder checkCanAudit(String code);

}
