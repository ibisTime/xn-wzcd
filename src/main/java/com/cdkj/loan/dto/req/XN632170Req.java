package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:52:02 
 * @history:
 */
public class XN632170Req {
    // 名称
    @NotBlank
    private String name;

    // 贷款银行(编号ID)
    @NotBlank
    private String loanBank;

    // GPS费用
    @NotBlank
    private String gpsFee;

    // 公证费
    @NotBlank
    private String authFee;

    // 服务费
    @NotBlank
    private String fee;

    // 月供利率
    @NotBlank
    private String monthRate;

    // 更新人
    @NotBlank
    private String updater;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(String gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getAuthFee() {
        return authFee;
    }

    public void setAuthFee(String authFee) {
        this.authFee = authFee;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(String monthRate) {
        this.monthRate = monthRate;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
