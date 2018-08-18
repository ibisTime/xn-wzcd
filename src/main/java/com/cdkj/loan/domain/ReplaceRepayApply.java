package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 代偿申请单
* @author: silver
* @since: 2018-06-14 21:08:40
* @history:
*/
public class ReplaceRepayApply extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 代偿性质
    private String type;

    // 预算金额
    private Long amount;

    // 业务编号(还款业务)
    private String bizCode;

    // 收款人开户行
    private String receiptBank;

    // 收款人名称
    private String receiptRealName;

    // 收款人账号
    private String receiptAccount;

    // 是否加急
    private String isUrgent;

    // 申请人
    private String applyUser;

    // 申请时间
    private Date applyDatetime;

    // 申请说明
    private String applyNote;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ********************db properties********************

    // 申请开始时间
    private Date startDatetime;

    // 申请结束时间
    private Date endDatetime;

    private String applyUserName;

    private String updaterName;

    private String budgetOrderCode;// 预算单编号

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setReceiptBank(String receiptBank) {
        this.receiptBank = receiptBank;
    }

    public String getReceiptBank() {
        return receiptBank;
    }

    public void setReceiptRealName(String receiptRealName) {
        this.receiptRealName = receiptRealName;
    }

    public String getReceiptRealName() {
        return receiptRealName;
    }

    public void setReceiptAccount(String receiptAccount) {
        this.receiptAccount = receiptAccount;
    }

    public String getReceiptAccount() {
        return receiptAccount;
    }

    public void setIsUrgent(String isUrgent) {
        this.isUrgent = isUrgent;
    }

    public String getIsUrgent() {
        return isUrgent;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getApplyNote() {
        return applyNote;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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

}
