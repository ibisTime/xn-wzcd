package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author: xieyj 
 * @since: 2017年1月18日 上午11:09:57 
 * @history:
 */
public class XN802012Req {

    // 编号(必填)
    @NotBlank
    private String code;

    // 户名(选填，有传就修改，没传不修改)
    private String realName;

    // 卡号(必填)
    @NotBlank
    private String bankcardNumber;

    // 银行行别（必填）
    @NotBlank
    private String bankCode;

    // 银行名称（必填）
    @NotBlank
    private String bankName;

    // 支行名称（选填）
    private String subbranch;

    // 绑定手机号（选填）
    private String bindMobile;

    private String type;// 类型（只做判断）

    // 更新人
    @NotBlank
    private String updater;

    // 备注（选填）
    private String remark;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
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

}
