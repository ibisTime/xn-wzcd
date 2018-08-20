package com.cdkj.loan.dto.req;

/**
 * 今日已垫资
 * @author: jiafr 
 * @since: 2018年8月20日 下午8:05:03 
 * @history:
 */
public class XN632179Req extends APageReq {

    private static final long serialVersionUID = 306449262364885903L;

    private String customerName;// 客户姓名

    private String bizCode;// 业务编号(预算单编号)

    private String companyCode;// 业务公司编号

    private String loanBankCode;// 贷款银行编号

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
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
