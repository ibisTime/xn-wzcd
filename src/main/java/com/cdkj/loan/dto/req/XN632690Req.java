package com.cdkj.loan.dto.req;

public class XN632690Req {

    private String carDealerCode;// 经销商编号

    private String loanBankCode;// 贷款银行

    private Integer loanPeriods;// 贷款周期

    private Long loanAmount;// 贷款金额

    private String rateType;// 利率类型

    private String serviceChargeWay;// 手续费收取方式

    private double bankRate;// 银行利率(%)

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public Integer getLoanPeriods() {
        return loanPeriods;
    }

    public void setLoanPeriods(Integer loanPeriods) {
        this.loanPeriods = loanPeriods;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
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

    public double getBankRate() {
        return bankRate;
    }

    public void setBankRate(double bankRate) {
        this.bankRate = bankRate;
    }

}
