package com.cdkj.loan.dto.req;

public class XN632905Req extends APageReq {

    private static final long serialVersionUID = 8087436020806949630L;

    // 预算单编号
    private String budgetCode;

    // 客户姓名
    private String customerName;

    // 贷款银行
    private String loanBankCode;

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

}
