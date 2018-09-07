package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午3:43:43 
 * @history:
 */
public class Bank extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 7671886097276757226L;

    // 编号
    private String code;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 支行名称
    private String subbranch;

    // 12期
    private Double rate12;

    // 24期
    private Double rate24;

    // 36期
    private Double rate36;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    private List<BankRate> bankRateList;

    // 更新人名称
    private String updaterName;

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getRate12() {
        return rate12;
    }

    public void setRate12(Double rate12) {
        this.rate12 = rate12;
    }

    public Double getRate24() {
        return rate24;
    }

    public void setRate24(Double rate24) {
        this.rate24 = rate24;
    }

    public Double getRate36() {
        return rate36;
    }

    public void setRate36(Double rate36) {
        this.rate36 = rate36;
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

    public List<BankRate> getBankRateList() {
        return bankRateList;
    }

    public void setBankRateList(List<BankRate> bankRateList) {
        this.bankRateList = bankRateList;
    }

}
