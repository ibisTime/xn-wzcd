package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.dto.req.XN630500Req;
import com.cdkj.loan.dto.req.XN630502Req;

public interface ILoanOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addLoanOrder(XN630500Req req);

    public int dropLoanOrder(String code);

    public int editLoanOrder(XN630502Req req);

    public Paginable<LoanOrder> queryLoanOrderPage(int start, int limit,
            LoanOrder condition);

    public List<LoanOrder> queryLoanOrderList(LoanOrder condition);

    public LoanOrder getLoanOrder(String code);

}
