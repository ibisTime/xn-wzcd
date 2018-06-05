package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:52:02 
 * @history:
 */
public class XN632170Req {
    // 类型
    @NotBlank
    private String type;

    // 名称
    @NotBlank
    private String name;

    // 贷款银行(编号)
    @NotBlank
    private String loanBank;

    // 万元系数
    @NotBlank
    private String wanFactor;

    // 年利率
    @NotBlank
    private String yearRate;

    // GPS费用
    @NotBlank
    private String gpsFee;

    // 公证费利率
    @NotBlank
    private String authRate;

    // 返点利率
    @NotBlank
    private String backRate;

    // 前置利率
    @NotBlank
    private String preRate;

    // 更新人
    @NotBlank
    private String updater;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getWanFactor() {
        return wanFactor;
    }

    public void setWanFactor(String wanFactor) {
        this.wanFactor = wanFactor;
    }

    public String getYearRate() {
        return yearRate;
    }

    public void setYearRate(String yearRate) {
        this.yearRate = yearRate;
    }

    public String getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(String gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getAuthRate() {
        return authRate;
    }

    public void setAuthRate(String authRate) {
        this.authRate = authRate;
    }

    public String getBackRate() {
        return backRate;
    }

    public void setBackRate(String backRate) {
        this.backRate = backRate;
    }

    public String getPreRate() {
        return preRate;
    }

    public void setPreRate(String preRate) {
        this.preRate = preRate;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
