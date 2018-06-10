package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 财务确认退客户垫资款
 * @author: jiafr 
 * @since: 2018年6月9日 下午4:11:16 
 * @history:
 */
public class XN632180Req {

    // 编号
    @NotBlank
    private String code;

    // 更新人
    @NotBlank
    private String updater;

    // 退款金额
    @NotBlank
    private String backAdvanceAmount;

    // 收款账号
    @NotBlank
    private String backAdvanceAccount;

    // 开户行
    @NotBlank
    private String backAdvanceOpenBank;

    // 开户支行
    @NotBlank
    private String backAdvanceSubbranch;

    // 水单
    @NotBlank
    private String backAdvanceWaterBill;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getBackAdvanceAmount() {
        return backAdvanceAmount;
    }

    public void setBackAdvanceAmount(String backAdvanceAmount) {
        this.backAdvanceAmount = backAdvanceAmount;
    }

    public String getBackAdvanceAccount() {
        return backAdvanceAccount;
    }

    public void setBackAdvanceAccount(String backAdvanceAccount) {
        this.backAdvanceAccount = backAdvanceAccount;
    }

    public String getBackAdvanceOpenBank() {
        return backAdvanceOpenBank;
    }

    public void setBackAdvanceOpenBank(String backAdvanceOpenBank) {
        this.backAdvanceOpenBank = backAdvanceOpenBank;
    }

    public String getBackAdvanceSubbranch() {
        return backAdvanceSubbranch;
    }

    public void setBackAdvanceSubbranch(String backAdvanceSubbranch) {
        this.backAdvanceSubbranch = backAdvanceSubbranch;
    }

    public String getBackAdvanceWaterBill() {
        return backAdvanceWaterBill;
    }

    public void setBackAdvanceWaterBill(String backAdvanceWaterBill) {
        this.backAdvanceWaterBill = backAdvanceWaterBill;
    }

}
