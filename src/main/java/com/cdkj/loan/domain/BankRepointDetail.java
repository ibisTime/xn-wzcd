package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 银行返佣明细
* @author: jiafr 
* @since: 2018-08-10 14:28:21
* @history:
*/
public class BankRepointDetail extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 银行返佣编号
	private String bankRepointCode;

	// 返佣金额
	private String amount;

	// 到账时间
	private String settleDatetime;

	// 银行回单
	private String billPdf;

	// 更新人
	private String updater;

	// 更新时间
	private String updateDatetime;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setBankRepointCode(String bankRepointCode) {
		this.bankRepointCode = bankRepointCode;
	}

	public String getBankRepointCode() {
		return bankRepointCode;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setSettleDatetime(String settleDatetime) {
		this.settleDatetime = settleDatetime;
	}

	public String getSettleDatetime() {
		return settleDatetime;
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

}