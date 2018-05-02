package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630500Req {

    @NotBlank
    private String mobile;// 手机号

    @NotBlank
    private String idKind;// 证件类型

    @NotBlank
    private String idNo;// 证件号

    @NotBlank
    private String realName;// 真实姓名

    @NotBlank
    private String bankCode;// 银行行别

    @NotBlank
    private String bankName;// 银行名称

    @NotBlank
    private String subbranch;// 开户支行

    @NotBlank
    private String bankcardNumber;// 银行卡号

    @NotBlank
    private String carCode;// 车型编号

    @NotBlank
    private String carPrice;// 车辆总价

    @NotBlank
    private String sfRate;// 首付比例

    @NotBlank
    private String sfAmount;// 首付金额

    @NotBlank
    private String loanBank;// 贷款银行

    @NotBlank
    private String loanAmount;// 贷款金额

    @NotBlank
    private String periods;// 总期数

    @NotBlank
    private String bankRate;// 银行利率

    @NotBlank
    private String loanStartDatetime;// 贷款时间起点

    @NotBlank
    private String loanEndDatetime;// 贷款时间终点

    @NotBlank
    private String fkDatetime;// 放款日期

    @NotBlank
    private String fxDeposit;// 风险保证金

    @NotBlank
    private String otherFee;// 杂费

    @NotBlank
    private String gpsFee;// GPS收费

    @NotBlank
    private String firstRepayDatetime;// 首期还款日期

    @NotBlank
    private String firstRepayAmount;// 首期月供金额

    @NotBlank
    private String monthDatetime;// 每期还款日期

    @NotBlank
    private String monthAmount;// 首期月供金额

    @NotBlank
    private String lyDeposit;// 履约保证金

    @NotBlank
    private String isSubmit;// 是否直接提交审核

    @NotBlank
    private String updater;// 最近修改人

    private String remark;// 备注

    public String getMobile() {
        return mobile;
    }

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getSfRate() {
        return sfRate;
    }

    public void setSfRate(String sfRate) {
        this.sfRate = sfRate;
    }

    public String getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(String sfAmount) {
        this.sfAmount = sfAmount;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getBankRate() {
        return bankRate;
    }

    public void setBankRate(String bankRate) {
        this.bankRate = bankRate;
    }

    public String getLoanStartDatetime() {
        return loanStartDatetime;
    }

    public void setLoanStartDatetime(String loanStartDatetime) {
        this.loanStartDatetime = loanStartDatetime;
    }

    public String getLoanEndDatetime() {
        return loanEndDatetime;
    }

    public void setLoanEndDatetime(String loanEndDatetime) {
        this.loanEndDatetime = loanEndDatetime;
    }

    public String getFkDatetime() {
        return fkDatetime;
    }

    public void setFkDatetime(String fkDatetime) {
        this.fkDatetime = fkDatetime;
    }

    public String getFxDeposit() {
        return fxDeposit;
    }

    public void setFxDeposit(String fxDeposit) {
        this.fxDeposit = fxDeposit;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(String gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getFirstRepayDatetime() {
        return firstRepayDatetime;
    }

    public void setFirstRepayDatetime(String firstRepayDatetime) {
        this.firstRepayDatetime = firstRepayDatetime;
    }

    public String getFirstRepayAmount() {
        return firstRepayAmount;
    }

    public void setFirstRepayAmount(String firstRepayAmount) {
        this.firstRepayAmount = firstRepayAmount;
    }

    public String getMonthDatetime() {
        return monthDatetime;
    }

    public void setMonthDatetime(String monthDatetime) {
        this.monthDatetime = monthDatetime;
    }

    public String getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(String monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getLyDeposit() {
        return lyDeposit;
    }

    public void setLyDeposit(String lyDeposit) {
        this.lyDeposit = lyDeposit;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
