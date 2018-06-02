package com.cdkj.loan.dto.req;

import java.util.List;

public class XN632300Req {

    private String loanBankCode;// 贷款银行编号

    private List<XN632300ReqOverdue> overdueList;// 逾期名单

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public List<XN632300ReqOverdue> getOverdueList() {
        return overdueList;
    }

    public void setOverdueList(List<XN632300ReqOverdue> overdueList) {
        this.overdueList = overdueList;
    }

}
