package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 清收费用
* @author: haiqingzheng
* @since: 2018年05月01日 19:01:42
* @history:
*/
public class Cost extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 还款计划编号
	private String repayPlanCode;

	// 费用项名称
	private String item;

	// 金额
	private String amount;

	// 发生时间
	private String payDatetime;

	// 发生付款方式
	private String payWay;

	// 状态
	private String status;

	// 执行时间
	private String repayDatetime;

	// 执行付款方式
	private String repayWay;

	// 备注
	private String remark;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setRepayPlanCode(String repayPlanCode) {
		this.repayPlanCode = repayPlanCode;
	}

	public String getRepayPlanCode() {
		return repayPlanCode;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return item;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setPayDatetime(String payDatetime) {
		this.payDatetime = payDatetime;
	}

	public String getPayDatetime() {
		return payDatetime;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setRepayDatetime(String repayDatetime) {
		this.repayDatetime = repayDatetime;
	}

	public String getRepayDatetime() {
		return repayDatetime;
	}

	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay;
	}

	public String getRepayWay() {
		return repayWay;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}