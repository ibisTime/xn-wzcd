package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 展示返点明细（用款用途）
 * @author: jiafr 
 * @since: 2018年6月16日 下午5:16:56 
 * @history:
 */
public class XN632290Req {

    @NotBlank
    private String budgetOrderCode;

    @NotBlank
    private String carDealerCode;

    // 服务费
    @NotBlank
    private String fee;

    // 贷款周期
    @NotBlank
    private String loanPeriods;

    // 利率类型
    @NotBlank
    private String rateType;

    // 银行利率
    @NotBlank
    private String bankRate;

    // gps收费
    @NotBlank
    private String gpsFee;

    // 履约保证金
    @NotBlank
    private String lyAmount;

    // 担保风险金
    @NotBlank
    private String fxAmount;

    // 杂费
    @NotBlank
    private String otherFee;

    // GPS收费方式
    @NotBlank
    private String gpsFeeWay;

    // 手续费收取方式
    @NotBlank
    private String feeWay;

    // 厂家贴息
    @NotBlank
    private String carDealerSubsidy;

    public String getCarDealerSubsidy() {
        return carDealerSubsidy;
    }

    public void setCarDealerSubsidy(String carDealerSubsidy) {
        this.carDealerSubsidy = carDealerSubsidy;
    }

    public String getGpsFeeWay() {
        return gpsFeeWay;
    }

    public void setGpsFeeWay(String gpsFeeWay) {
        this.gpsFeeWay = gpsFeeWay;
    }

    public String getFeeWay() {
        return feeWay;
    }

    public void setFeeWay(String feeWay) {
        this.feeWay = feeWay;
    }

    public String getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(String gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getLyAmount() {
        return lyAmount;
    }

    public void setLyAmount(String lyAmount) {
        this.lyAmount = lyAmount;
    }

    public String getFxAmount() {
        return fxAmount;
    }

    public void setFxAmount(String fxAmount) {
        this.fxAmount = fxAmount;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getBankRate() {
        return bankRate;
    }

    public void setBankRate(String bankRate) {
        this.bankRate = bankRate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getLoanPeriods() {
        return loanPeriods;
    }

    public void setLoanPeriods(String loanPeriods) {
        this.loanPeriods = loanPeriods;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

}
