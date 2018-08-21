package com.cdkj.loan.dto.req;

/**
 * 风险客户四级分类
 * @author: jiafr 
 * @since: 2018年8月21日 上午11:36:59 
 * @history:
 */
public class XN630906Req extends APageReq {

    private static final long serialVersionUID = 4085148069452087635L;

    // 业务编号
    private String code;

    // 业务公司编号
    private String companyCode;

    // 借款人
    private String customerName;

    // 客户类别
    private String customerType;

    // 贷款银行编号
    private String loanBankCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

}
