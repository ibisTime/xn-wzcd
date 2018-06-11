package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改业务团队
 * @author: jiafr 
 * @since: 2018年6月8日 下午2:13:48 
 * @history:
 */
public class XN630192Req {

    // 编号
    @NotBlank
    private String code;

    // 团队名称
    @NotBlank
    private String name;

    // 团队长
    @NotBlank
    private String captain;

    // 更新人
    @NotBlank
    private String updater;

    // 收款账号
    private String accountNo;

    // 收款银行
    private String bank;

    // 收款支行
    private String subbranch;

    // 水单
    private String waterBill;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

}
