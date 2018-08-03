package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632100Req {

    @NotBlank
    private String receiptAccount;// 收款账号编号

    @NotBlank
    private String budgetAmount;// 预算金额

    @NotBlank
    private String useDatetime;// 用款日期

    @NotBlank
    private String applyUser;// 申请人

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

}
