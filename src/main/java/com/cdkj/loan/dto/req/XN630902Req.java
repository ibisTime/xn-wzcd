package com.cdkj.loan.dto.req;

/**
 * 余额明细统计
 * @author: jiafr 
 * @since: 2018年8月7日 下午9:39:25 
 * @history:
 */
public class XN630902Req extends APageReq {

    private static final long serialVersionUID = 4508558042628174433L;

    private String bizCode;// 业务编号

    private String customerName;// 客户姓名

    private String companyCode;// 业务公司编号

    private String loanBankCode;// 贷款银行编号

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
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
