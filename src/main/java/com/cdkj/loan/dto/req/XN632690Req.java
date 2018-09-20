package com.cdkj.loan.dto.req;

public class XN632690Req {

    private String loanBankCode;// 贷款银行

    private String loanPeriods;// 贷款周期

    private String loanAmount;// 贷款金额

    private String rateType;// 利率类型

    private String serviceChargeWay;// 手续费收取方式

    private String bankRate;// 银行利率

    // 银行基准利率
    private String bankBenchmarkRate;

    private String surcharge; // 附加费

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getBankBenchmarkRate() {
        return bankBenchmarkRate;
    }

    public void setBankBenchmarkRate(String bankBenchmarkRate) {
        this.bankBenchmarkRate = bankBenchmarkRate;
    }

    public String getLoanPeriods() {
        return loanPeriods;
    }

    public void setLoanPeriods(String loanPeriods) {
        this.loanPeriods = loanPeriods;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getServiceChargeWay() {
        return serviceChargeWay;
    }

    public void setServiceChargeWay(String serviceChargeWay) {
        this.serviceChargeWay = serviceChargeWay;
    }

    public String getBankRate() {
        return bankRate;
    }

    public void setBankRate(String bankRate) {
        this.bankRate = bankRate;
    }

    public String getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(String surcharge) {
        this.surcharge = surcharge;
    }

}
