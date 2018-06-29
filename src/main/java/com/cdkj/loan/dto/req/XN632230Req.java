package com.cdkj.loan.dto.req;

/**
 * 发票不匹配申请
 * @author: jiafr 
 * @since: 2018年6月28日 下午10:41:19 
 * @history:
 */
public class XN632230Req {

    // 编号
    private String code;

    // 贷款金额
    private String loanAmount;

    // 操作人
    private String operator;

    // 我司贷款成数
    private String companyLoanCs;

    // 综合利率
    private String globalRate;

    // 银行贷款成数
    private String bankLoanCs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCompanyLoanCs() {
        return companyLoanCs;
    }

    public void setCompanyLoanCs(String companyLoanCs) {
        this.companyLoanCs = companyLoanCs;
    }

    public String getGlobalRate() {
        return globalRate;
    }

    public void setGlobalRate(String globalRate) {
        this.globalRate = globalRate;
    }

    public String getBankLoanCs() {
        return bankLoanCs;
    }

    public void setBankLoanCs(String bankLoanCs) {
        this.bankLoanCs = bankLoanCs;
    }

}
