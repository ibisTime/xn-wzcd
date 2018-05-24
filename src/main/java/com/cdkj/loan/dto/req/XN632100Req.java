package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632100Req {
    @NotBlank
    private String receiptBank;// 收款银行

    @NotBlank
    private String receiptAccount;// 收款账号

    @NotBlank
    private String budgetAmount;// 预算金额

    @NotBlank
    private String useDatetime;// 用款日期

    @NotBlank
    private String applyUser;// 操作人

    @NotBlank
    private String buttonCode;// 按钮标识

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

    public String getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(String budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getUseDatetime() {
        return useDatetime;
    }

    public void setUseDatetime(String useDatetime) {
        this.useDatetime = useDatetime;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode;
    }

}
