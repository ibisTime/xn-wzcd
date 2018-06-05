package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 贷款产品
 * @author: silver 
 * @since: 2018年5月30日 上午11:29:54 
 * @history:
 */
public class LoanProduct extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -3072309115192038821L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 名称
    private String name;

    // 贷款银行(编号)
    private String loanBank;

    // 万元系数
    private Long wanFactor;

    // 年利率
    private double yearRate;

    // GPS费用
    private Long gpsFee;

    // 公证费利率
    private double authRate;

    // 返点利率
    private double backRate;

    // 前置利率
    private double preRate;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ************db properties************

    // 贷款银行名称
    private String loanBankName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public Long getWanFactor() {
        return wanFactor;
    }

    public void setWanFactor(Long wanFactor) {
        this.wanFactor = wanFactor;
    }

    public double getYearRate() {
        return yearRate;
    }

    public void setYearRate(double yearRate) {
        this.yearRate = yearRate;
    }

    public Long getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(Long gpsFee) {
        this.gpsFee = gpsFee;
    }

    public double getAuthRate() {
        return authRate;
    }

    public void setAuthRate(double authRate) {
        this.authRate = authRate;
    }

    public double getBackRate() {
        return backRate;
    }

    public void setBackRate(double backRate) {
        this.backRate = backRate;
    }

    public double getPreRate() {
        return preRate;
    }

    public void setPreRate(double preRate) {
        this.preRate = preRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

}
