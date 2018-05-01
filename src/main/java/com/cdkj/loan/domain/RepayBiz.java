package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 还款业务
* @author: haiqingzheng
* @since: 2018年05月01日 17:58:51
* @history:
*/
public class RepayBiz extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 申请人编号
	private String userId;

	// 还款卡编号
	private String bankcardCode;

	// 关联类型
	private String refType;

	// 关联编号
	private String refCode;

	// 业务总价
	private String bizPrice;

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

	// 剩余期数
	private String restPeriods;

	// 银行利率
	private String bankRate;

	// 贷款时间起点
	private String loanStartDatetime;

	// 贷款时间终点
	private String loanEndDatetime;

	// 风险保证金
	private String fxDeposit;

	// 首期还款日期
	private String firstRepayDatetime;

	// 首期月供金额
	private String firstRepayAmount;

	// 每期还款日期
	private String monthDatetime;

	// 每期月供金额
	private String monthAmount;

	// 履约保证金（可退）
	private String lyDeposit;

	// 扣除的履约保证金
	private String cutLyDeposit;

	// 状态
	private String status;

	// 剩余欠款
	private String restAmount;

	// 未还清收总成本
	private String restTotalCost;

	// 额外保证金收入
	private String totalInDeposit;

	// 逾期总金额
	private String overdueAmount;

	// 累计逾期期数
	private String totalOverdueCount;

	// 实际逾期期数
	private String curOverdueCount;

	// 黑名单处理结果备案
	private String blackHandleNote;

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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setBankcardCode(String bankcardCode) {
		this.bankcardCode = bankcardCode;
	}

	public String getBankcardCode() {
		return bankcardCode;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public String getRefCode() {
		return refCode;
	}

	public void setBizPrice(String bizPrice) {
		this.bizPrice = bizPrice;
	}

	public String getBizPrice() {
		return bizPrice;
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

	public void setRestPeriods(String restPeriods) {
		this.restPeriods = restPeriods;
	}

	public String getRestPeriods() {
		return restPeriods;
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

	public void setFxDeposit(String fxDeposit) {
		this.fxDeposit = fxDeposit;
	}

	public String getFxDeposit() {
		return fxDeposit;
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

	public void setCutLyDeposit(String cutLyDeposit) {
		this.cutLyDeposit = cutLyDeposit;
	}

	public String getCutLyDeposit() {
		return cutLyDeposit;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setRestAmount(String restAmount) {
		this.restAmount = restAmount;
	}

	public String getRestAmount() {
		return restAmount;
	}

	public void setRestTotalCost(String restTotalCost) {
		this.restTotalCost = restTotalCost;
	}

	public String getRestTotalCost() {
		return restTotalCost;
	}

	public void setTotalInDeposit(String totalInDeposit) {
		this.totalInDeposit = totalInDeposit;
	}

	public String getTotalInDeposit() {
		return totalInDeposit;
	}

	public void setOverdueAmount(String overdueAmount) {
		this.overdueAmount = overdueAmount;
	}

	public String getOverdueAmount() {
		return overdueAmount;
	}

	public void setTotalOverdueCount(String totalOverdueCount) {
		this.totalOverdueCount = totalOverdueCount;
	}

	public String getTotalOverdueCount() {
		return totalOverdueCount;
	}

	public void setCurOverdueCount(String curOverdueCount) {
		this.curOverdueCount = curOverdueCount;
	}

	public String getCurOverdueCount() {
		return curOverdueCount;
	}

	public void setBlackHandleNote(String blackHandleNote) {
		this.blackHandleNote = blackHandleNote;
	}

	public String getBlackHandleNote() {
		return blackHandleNote;
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