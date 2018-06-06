package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632670Req {

    // 类型
    @NotBlank
    private String type;

    // 关联资产审批编号
    private String refAssertCode;

    // 关联车贷业务编号
    private String refBudgetOrderCode;

    // 预支金额
    @NotBlank
    private String amount;

    // 开户银行
    @NotBlank
    private String subbranch;

    // 银行账号
    @NotBlank
    private String bankcardNumber;

    // 账户名
    @NotBlank
    private String accountName;

    // 申请人
    @NotBlank
    private String applyUser;

    // 申请说明
    private String applyNote;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefAssertCode() {
        return refAssertCode;
    }

    public void setRefAssertCode(String refAssertCode) {
        this.refAssertCode = refAssertCode;
    }

    public String getRefBudgetOrderCode() {
        return refBudgetOrderCode;
    }

    public void setRefBudgetOrderCode(String refBudgetOrderCode) {
        this.refBudgetOrderCode = refBudgetOrderCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
