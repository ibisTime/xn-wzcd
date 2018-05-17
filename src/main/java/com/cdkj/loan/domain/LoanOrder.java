package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 车贷订单
* @author: haiqingzheng
* @since: 2018年05月01日 17:23:33
* @history:
*/
public class LoanOrder extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 还款业务编号
    private String repayBizCode;

    // 申请人编号
    private String userId;

    // 手机号
    private String mobile;

    // 证件类型
    private String idKind;

    // 证件号
    private String idNo;

    // 真实姓名
    private String realName;

    // 银行行别
    private String bankCode;

    // 银行名称
    private String bankName;

    // 开户支行
    private String subbranch;

    // 银行卡号
    private String bankcardNumber;

    // 车型编号
    private String carCode;

    // 车辆总价
    private Long carPrice;

    // 首付比例
    private double sfRate;

    // 首付金额
    private Long sfAmount;

    // 贷款银行
    private String loanBank;

    // 贷款金额
    private Long loanAmount;

    // 总期数
    private int periods;

    // 银行利率
    private double bankRate;

    // 贷款时间起点
    private Date loanStartDatetime;

    // 贷款时间终点
    private Date loanEndDatetime;

    // 放款日期
    private Date fkDatetime;

    // 风险保证金
    private Long fxDeposit;

    // 杂费
    private Long otherFee;

    // GPS收费
    private Long gpsFee;

    // 首期还款日期
    private Date firstRepayDatetime;

    // 首期月供金额
    private Long firstRepayAmount;

    // 每期还款日期
    private int monthDatetime;

    // 每期月供金额
    private Long monthAmount;

    // 履约保证金
    private Long lyDeposit;

    // 状态
    private String status;

    // 最近修改人
    private String updater;

    // 最近修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ****** 辅助字段 ******

    // 用户信息
    private User user;

    private String carName; // 车型名称

    private String seriesName; // 车系名称

    private String brandName; // 品牌名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
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

    public Long getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Long carPrice) {
        this.carPrice = carPrice;
    }

    public double getSfRate() {
        return sfRate;
    }

    public void setSfRate(double sfRate) {
        this.sfRate = sfRate;
    }

    public Long getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(Long sfAmount) {
        this.sfAmount = sfAmount;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public double getBankRate() {
        return bankRate;
    }

    public void setBankRate(double bankRate) {
        this.bankRate = bankRate;
    }

    public Date getLoanStartDatetime() {
        return loanStartDatetime;
    }

    public void setLoanStartDatetime(Date loanStartDatetime) {
        this.loanStartDatetime = loanStartDatetime;
    }

    public Date getLoanEndDatetime() {
        return loanEndDatetime;
    }

    public void setLoanEndDatetime(Date loanEndDatetime) {
        this.loanEndDatetime = loanEndDatetime;
    }

    public Date getFkDatetime() {
        return fkDatetime;
    }

    public void setFkDatetime(Date fkDatetime) {
        this.fkDatetime = fkDatetime;
    }

    public Long getFxDeposit() {
        return fxDeposit;
    }

    public void setFxDeposit(Long fxDeposit) {
        this.fxDeposit = fxDeposit;
    }

    public Long getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Long otherFee) {
        this.otherFee = otherFee;
    }

    public Long getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(Long gpsFee) {
        this.gpsFee = gpsFee;
    }

    public Date getFirstRepayDatetime() {
        return firstRepayDatetime;
    }

    public void setFirstRepayDatetime(Date firstRepayDatetime) {
        this.firstRepayDatetime = firstRepayDatetime;
    }

    public Long getFirstRepayAmount() {
        return firstRepayAmount;
    }

    public void setFirstRepayAmount(Long firstRepayAmount) {
        this.firstRepayAmount = firstRepayAmount;
    }

    public int getMonthDatetime() {
        return monthDatetime;
    }

    public void setMonthDatetime(int monthDatetime) {
        this.monthDatetime = monthDatetime;
    }

    public Long getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(Long monthAmount) {
        this.monthAmount = monthAmount;
    }

    public Long getLyDeposit() {
        return lyDeposit;
    }

    public void setLyDeposit(Long lyDeposit) {
        this.lyDeposit = lyDeposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
