package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午4:46:11 
 * @history:
 */
public class XN632030Req {

    // 银行编号
    @NotBlank
    private String bankCode;

    // 银行名称
    @NotBlank
    private String bankName;

    private String subbranch;

    // 12期
    private String rate12;

    // 18期
    private String rate18;

    // 24期
    private String rate24;

    // 36期
    private String rate36;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    // 利率列表
    private List<XN632030ReqRate> bankRateList;

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
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

    public String getRate12() {
        return rate12;
    }

    public void setRate12(String rate12) {
        this.rate12 = rate12;
    }

    public String getRate18() {
        return rate18;
    }

    public void setRate18(String rate18) {
        this.rate18 = rate18;
    }

    public String getRate24() {
        return rate24;
    }

    public void setRate24(String rate24) {
        this.rate24 = rate24;
    }

    public String getRate36() {
        return rate36;
    }

    public void setRate36(String rate36) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<XN632030ReqRate> getBankRateList() {
        return bankRateList;
    }

    public void setBankRateList(List<XN632030ReqRate> bankRateList) {
        this.bankRateList = bankRateList;
    }

}
