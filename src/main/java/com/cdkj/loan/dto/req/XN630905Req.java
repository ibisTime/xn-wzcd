package com.cdkj.loan.dto.req;

/**
 * 当天0点为止分公司没有打款给车行的数据统计
 * @author: jiafr 
 * @since: 2018年8月21日 上午11:36:22 
 * @history:
 */
public class XN630905Req extends APageReq {

    private static final long serialVersionUID = -3646680350039454519L;

    // 预算单编号
    private String budgetCode;

    // 客户姓名
    private String customerName;

    // 业务公司编号
    private String companyCode;

    // 贷款银行编号
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

}
