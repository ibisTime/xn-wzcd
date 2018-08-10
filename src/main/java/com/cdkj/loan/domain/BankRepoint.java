package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 银行返佣
* @author: jiafr 
* @since: 2018-08-10 14:19:23
* @history:
*/
public class BankRepoint extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 业务编号
	private String bizCode;

	// 客户姓名
	private String customerName;

	// 汽车经销商编号
	private String carDealerCode;

	// 贷款银行编号
	private String loanBankCode;

	// 业务公司编号
	private String companyCode;

	// 结算费率
	private String settleRate;

	// 结算金额
	private String settleAmount;

	// 推荐服务费
	private String recommendFee;

	// 风险代理费
	private String riskAgentFee;

	// 应交税费
	private String tax;

	// 到账日期
	private String settleDatetime;

	// 我司留存利率
	private String companySaveRate;

	// 我司留存返佣
	private String companySaveRepoint;

	// 代收代付返佣
	private String agentRepoint;

	// 退回金额
	private String sendBackAmount;

	// 银行回单（退回）
	private String billPdf;

	// 更新人
	private String updater;

	// 更新时间
	private String updateDatetime;

	// 节点
	private String curNodeCode;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCarDealerCode(String carDealerCode) {
		this.carDealerCode = carDealerCode;
	}

	public String getCarDealerCode() {
		return carDealerCode;
	}

	public void setLoanBankCode(String loanBankCode) {
		this.loanBankCode = loanBankCode;
	}

	public String getLoanBankCode() {
		return loanBankCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setSettleRate(String settleRate) {
		this.settleRate = settleRate;
	}

	public String getSettleRate() {
		return settleRate;
	}

	public void setSettleAmount(String settleAmount) {
		this.settleAmount = settleAmount;
	}

	public String getSettleAmount() {
		return settleAmount;
	}

	public void setRecommendFee(String recommendFee) {
		this.recommendFee = recommendFee;
	}

	public String getRecommendFee() {
		return recommendFee;
	}

	public void setRiskAgentFee(String riskAgentFee) {
		this.riskAgentFee = riskAgentFee;
	}

	public String getRiskAgentFee() {
		return riskAgentFee;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTax() {
		return tax;
	}

	public void setSettleDatetime(String settleDatetime) {
		this.settleDatetime = settleDatetime;
	}

	public String getSettleDatetime() {
		return settleDatetime;
	}

	public void setCompanySaveRate(String companySaveRate) {
		this.companySaveRate = companySaveRate;
	}

	public String getCompanySaveRate() {
		return companySaveRate;
	}

	public void setCompanySaveRepoint(String companySaveRepoint) {
		this.companySaveRepoint = companySaveRepoint;
	}

	public String getCompanySaveRepoint() {
		return companySaveRepoint;
	}

	public void setAgentRepoint(String agentRepoint) {
		this.agentRepoint = agentRepoint;
	}

	public String getAgentRepoint() {
		return agentRepoint;
	}

	public void setSendBackAmount(String sendBackAmount) {
		this.sendBackAmount = sendBackAmount;
	}

	public String getSendBackAmount() {
		return sendBackAmount;
	}

	public void setBillPdf(String billPdf) {
		this.billPdf = billPdf;
	}

	public String getBillPdf() {
		return billPdf;
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

	public void setCurNodeCode(String curNodeCode) {
		this.curNodeCode = curNodeCode;
	}

	public String getCurNodeCode() {
		return curNodeCode;
	}

}