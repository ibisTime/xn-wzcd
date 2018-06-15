package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632320Req {

    @NotBlank
    private String amount;// 预算金额

    @NotBlank
    private String bizCode;// 业务编号

    @NotBlank
    private String receiptBank;// 收款人开户行

    @NotBlank
    private String receiptAccount;// 收款人账号

    @NotBlank
    private String receiptRealName;// 收款人名称

    @NotBlank
    private String isUrgent;// 是否加急

    @NotBlank
    private String applyUser;// 申请人

    private String applyNote;// 申请说明

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getReceiptBank() {
        return receiptBank;
    }

    public void setReceiptBank(String receiptBank) {
        this.receiptBank = receiptBank;
    }

    public String getReceiptAccount() {
        return receiptAccount;
    }

    public void setReceiptAccount(String receiptAccount) {
        this.receiptAccount = receiptAccount;
    }

    public String getReceiptRealName() {
        return receiptRealName;
    }

    public void setReceiptRealName(String receiptRealName) {
        this.receiptRealName = receiptRealName;
    }

    public String getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(String isUrgent) {
        this.isUrgent = isUrgent;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

}
