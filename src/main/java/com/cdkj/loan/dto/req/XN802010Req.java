package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 绑定银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午4:56:20 
 * @history:
 */
public class XN802010Req {

    // 用户编号（必填）
    @NotBlank
    private String userId;

    // 用户姓名（必填）
    @NotBlank
    private String realName;

    // 银行编号（必填）
    @NotBlank
    private String bankCode;

    // 银行名称（必填）
    @NotBlank
    private String bankName;

    // 支行名称（必填）
    @NotBlank
    private String subbranch;

    // 卡号（必填）
    @NotBlank
    private String bankcardNumber;

    // 绑定手机号（必填）
    @NotBlank
    private String bindMobile;

    // 操作人（必填）
    @NotBlank
    private String updater;

    // 备注（选填）
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
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
