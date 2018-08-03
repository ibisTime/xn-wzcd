package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632111Req;

public interface ICreditUserAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    // 录入银行征信结果
    public void inputBankCreditResult(XN632111Req req);

    // 查看征信报告详情
    public CreditUser getCreditUserReport(String code);

    public Paginable<CreditUser> queryCreditUserList(int start, int limit,
            CreditUser condition);
}
