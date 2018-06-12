package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 上午11:53:07 
 * @history:
 */
public class XN630190Req {

    @NotBlank
    private String name;

    @NotBlank
    private String captain;

    @NotBlank
    private String updater;

    @NotBlank
    private String accountNo;

    @NotBlank
    private String bank;

    @NotBlank
    private String subbranch;

    private String waterBill;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(String waterBill) {
        this.waterBill = waterBill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
