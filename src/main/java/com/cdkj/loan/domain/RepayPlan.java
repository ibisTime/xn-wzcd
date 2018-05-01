package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 还款计划
* @author: haiqingzheng
* @since: 2018年05月01日 18:52:51
* @history:
*/
public class RepayPlan extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 还款业务编号
	private String repayBizCode;

	// 借款人编号
	private String userId;

	// 总期数
	private String periods;

	// 当前期数
	private String curPeriods;

	// 还款时间
	private String repayDatetime;

	// 本期本金
	private String repayCapital;

	// 本期利息
	private String repayInterest;

	// 已还金额
	private String payedAmount;

	// 逾期金额
	private String overdueAmount;

	// 状态
	private String status;

	// 逾期处理人
	private String overdueHandler;

	// 逾期处理时间
	private String overdueHandleDatetime;

	// 逾期处理说明
	private String overdueHandleNote;

	// 清收费用总额
	private String totalFee;

	// 已缴纳清收费用总额
	private String payedFee;

	// 再次逾期保证金
	private String overdueDeposit;

	// 再次逾期保证金收取方式
	private String depositWay;

	// 实际可退的再次逾期保证金
	private String shouldDeposit;

	// 已催款次数
	private String remindCount;

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

	public void setPeriods(String periods) {
		this.periods = periods;
	}

	public String getPeriods() {
		return periods;
	}

	public void setCurPeriods(String curPeriods) {
		this.curPeriods = curPeriods;
	}

	public String getCurPeriods() {
		return curPeriods;
	}

	public void setRepayDatetime(String repayDatetime) {
		this.repayDatetime = repayDatetime;
	}

	public String getRepayDatetime() {
		return repayDatetime;
	}

	public void setRepayCapital(String repayCapital) {
		this.repayCapital = repayCapital;
	}

	public String getRepayCapital() {
		return repayCapital;
	}

	public void setRepayInterest(String repayInterest) {
		this.repayInterest = repayInterest;
	}

	public String getRepayInterest() {
		return repayInterest;
	}

	public void setPayedAmount(String payedAmount) {
		this.payedAmount = payedAmount;
	}

	public String getPayedAmount() {
		return payedAmount;
	}

	public void setOverdueAmount(String overdueAmount) {
		this.overdueAmount = overdueAmount;
	}

	public String getOverdueAmount() {
		return overdueAmount;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setOverdueHandler(String overdueHandler) {
		this.overdueHandler = overdueHandler;
	}

	public String getOverdueHandler() {
		return overdueHandler;
	}

	public void setOverdueHandleDatetime(String overdueHandleDatetime) {
		this.overdueHandleDatetime = overdueHandleDatetime;
	}

	public String getOverdueHandleDatetime() {
		return overdueHandleDatetime;
	}

	public void setOverdueHandleNote(String overdueHandleNote) {
		this.overdueHandleNote = overdueHandleNote;
	}

	public String getOverdueHandleNote() {
		return overdueHandleNote;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setPayedFee(String payedFee) {
		this.payedFee = payedFee;
	}

	public String getPayedFee() {
		return payedFee;
	}

	public void setOverdueDeposit(String overdueDeposit) {
		this.overdueDeposit = overdueDeposit;
	}

	public String getOverdueDeposit() {
		return overdueDeposit;
	}

	public void setDepositWay(String depositWay) {
		this.depositWay = depositWay;
	}

	public String getDepositWay() {
		return depositWay;
	}

	public void setShouldDeposit(String shouldDeposit) {
		this.shouldDeposit = shouldDeposit;
	}

	public String getShouldDeposit() {
		return shouldDeposit;
	}

	public void setRemindCount(String remindCount) {
		this.remindCount = remindCount;
	}

	public String getRemindCount() {
		return remindCount;
	}

}