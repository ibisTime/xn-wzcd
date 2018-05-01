package com.cdkj.loan.domain;

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
	private String carPrice;

	// 首付比例
	private String sfRate;

	// 首付金额
	private String sfAmount;

	// 贷款银行
	private String loanBank;

	// 贷款金额
	private String loanAmount;

	// 总期数
	private String periods;

	// 银行利率
	private String bankRate;

	// 贷款时间起点
	private String loanStartDatetime;

	// 贷款时间终点
	private String loanEndDatetime;

	// 放款日期
	private String fkDatetime;

	// 风险保证金
	private String fxDeposit;

	// 杂费
	private String otherFee;

	// GPS收费
	private String gpsFee;

	// 首期还款日期
	private String firstRepayDatetime;

	// 首期月供金额
	private String firstRepayAmount;

	// 每期还款日期
	private String monthDatetime;

	// 每期月供金额
	private String monthAmount;

	// 履约保证金
	private String lyDeposit;

	// 状态
	private String status;

	// 最近修改人
	private String updater;

	// 最近修改时间
	private String updateDatetime;

	// 备注
	private String remark;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setRepayBizCode(String repayBizCode) {
		this.repayBizCode = repayBizCode;
	}

	public String getRepayBizCode() {
		return repayBizCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}

	public void setIdKind(String idKind) {
		this.idKind = idKind;
	}

	public String getIdKind() {
		return idKind;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return realName;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setSubbranch(String subbranch) {
		this.subbranch = subbranch;
	}

	public String getSubbranch() {
		return subbranch;
	}

	public void setBankcardNumber(String bankcardNumber) {
		this.bankcardNumber = bankcardNumber;
	}

	public String getBankcardNumber() {
		return bankcardNumber;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarPrice() {
		return carPrice;
	}

	public void setSfRate(String sfRate) {
		this.sfRate = sfRate;
	}

	public String getSfRate() {
		return sfRate;
	}

	public void setSfAmount(String sfAmount) {
		this.sfAmount = sfAmount;
	}

	public String getSfAmount() {
		return sfAmount;
	}

	public void setLoanBank(String loanBank) {
		this.loanBank = loanBank;
	}

	public String getLoanBank() {
		return loanBank;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setPeriods(String periods) {
		this.periods = periods;
	}

	public String getPeriods() {
		return periods;
	}

	public void setBankRate(String bankRate) {
		this.bankRate = bankRate;
	}

	public String getBankRate() {
		return bankRate;
	}

	public void setLoanStartDatetime(String loanStartDatetime) {
		this.loanStartDatetime = loanStartDatetime;
	}

	public String getLoanStartDatetime() {
		return loanStartDatetime;
	}

	public void setLoanEndDatetime(String loanEndDatetime) {
		this.loanEndDatetime = loanEndDatetime;
	}

	public String getLoanEndDatetime() {
		return loanEndDatetime;
	}

	public void setFkDatetime(String fkDatetime) {
		this.fkDatetime = fkDatetime;
	}

	public String getFkDatetime() {
		return fkDatetime;
	}

	public void setFxDeposit(String fxDeposit) {
		this.fxDeposit = fxDeposit;
	}

	public String getFxDeposit() {
		return fxDeposit;
	}

	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
	}

	public String getOtherFee() {
		return otherFee;
	}

	public void setGpsFee(String gpsFee) {
		this.gpsFee = gpsFee;
	}

	public String getGpsFee() {
		return gpsFee;
	}

	public void setFirstRepayDatetime(String firstRepayDatetime) {
		this.firstRepayDatetime = firstRepayDatetime;
	}

	public String getFirstRepayDatetime() {
		return firstRepayDatetime;
	}

	public void setFirstRepayAmount(String firstRepayAmount) {
		this.firstRepayAmount = firstRepayAmount;
	}

	public String getFirstRepayAmount() {
		return firstRepayAmount;
	}

	public void setMonthDatetime(String monthDatetime) {
		this.monthDatetime = monthDatetime;
	}

	public String getMonthDatetime() {
		return monthDatetime;
	}

	public void setMonthAmount(String monthAmount) {
		this.monthAmount = monthAmount;
	}

	public String getMonthAmount() {
		return monthAmount;
	}

	public void setLyDeposit(String lyDeposit) {
		this.lyDeposit = lyDeposit;
	}

	public String getLyDeposit() {
		return lyDeposit;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getUpdateDatetime() {
		return updateDatetime;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}