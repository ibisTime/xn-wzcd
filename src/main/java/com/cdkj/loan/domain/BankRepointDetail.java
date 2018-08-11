package com.cdkj.loan.domain;

import java.util.Date;

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
    private Long amount;

    // 到账时间
    private Date settleDatetime;

    // 银行回单
    private String billPdf;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankRepointCode() {
        return bankRepointCode;
    }

    public void setBankRepointCode(String bankRepointCode) {
        this.bankRepointCode = bankRepointCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(Date settleDatetime) {
        this.settleDatetime = settleDatetime;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
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

}
