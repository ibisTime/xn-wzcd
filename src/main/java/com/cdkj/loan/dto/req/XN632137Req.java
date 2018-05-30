package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632137Req {

    @NotBlank
    private String code;// 编号

    @NotBlank
    private String operator;// 操作人

    private String repayBankcardNumber;// 卡号

    private String repayBillDate;// 账单还款日

    private String repayBankDate;// 银行还款日

    private String repayCompanyDate;// 公司还款日

    private String repayFirstMonthAmount;// 首期月供金额

    private String repayMonthAmount;// 每期月供金额

    private String bankFkDate;// 放款日期

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepayBankcardNumber() {
        return repayBankcardNumber;
    }

    public void setRepayBankcardNumber(String repayBankcardNumber) {
        this.repayBankcardNumber = repayBankcardNumber;
    }

    public String getRepayBillDate() {
        return repayBillDate;
    }

    public void setRepayBillDate(String repayBillDate) {
        this.repayBillDate = repayBillDate;
    }

    public String getRepayBankDate() {
        return repayBankDate;
    }

    public void setRepayBankDate(String repayBankDate) {
        this.repayBankDate = repayBankDate;
    }

    public String getRepayCompanyDate() {
        return repayCompanyDate;
    }

    public void setRepayCompanyDate(String repayCompanyDate) {
        this.repayCompanyDate = repayCompanyDate;
    }

    public String getRepayFirstMonthAmount() {
        return repayFirstMonthAmount;
    }

    public void setRepayFirstMonthAmount(String repayFirstMonthAmount) {
        this.repayFirstMonthAmount = repayFirstMonthAmount;
    }

    public String getRepayMonthAmount() {
        return repayMonthAmount;
    }

    public void setRepayMonthAmount(String repayMonthAmount) {
        this.repayMonthAmount = repayMonthAmount;
    }

    public String getBankFkDate() {
        return bankFkDate;
    }

    public void setBankFkDate(String bankFkDate) {
        this.bankFkDate = bankFkDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
