package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:23:05 
 * @history:
 */
public class XN632050Req {
    // 银行编号∑
    @NotBlank
    private String bankCode;

    // 简称
    @NotBlank
    private String abbrName;

    // 全称
    @NotBlank
    private String fullName;

    // 开户行
    @NotBlank
    private String openBank;

    // 银行地址
    private String address;

    // 电话号码
    private String phoneNumber;

    // 邮编
    private String postCode;

    // 银行委托人
    private String bankClient;

    // 委托有效期
    private String clientValidDate;

    // 授权人姓名
    private String autherName;

    // 授权人电话
    private String autherPhoneNumber;

    // 授权人身份证
    private String autherIdNo;

    // 授权人地址
    private String autherAddress;

    // 信用卡类型
    private String creditCardType;

    // 信用卡名称
    private String creditCardName;

    // 所属地区
    private String belongArea;

    // 更新人
    @NotBlank
    private String updater;

    // 备注
    private String remark;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getBankClient() {
        return bankClient;
    }

    public void setBankClient(String bankClient) {
        this.bankClient = bankClient;
    }

    public String getClientValidDate() {
        return clientValidDate;
    }

    public void setClientValidDate(String clientValidDate) {
        this.clientValidDate = clientValidDate;
    }

    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public String getAutherPhoneNumber() {
        return autherPhoneNumber;
    }

    public void setAutherPhoneNumber(String autherPhoneNumber) {
        this.autherPhoneNumber = autherPhoneNumber;
    }

    public String getAutherAddress() {
        return autherAddress;
    }

    public void setAutherAddress(String autherAddress) {
        this.autherAddress = autherAddress;
    }

    public String getAutherIdNo() {
        return autherIdNo;
    }

    public void setAutherIdNo(String autherIdNo) {
        this.autherIdNo = autherIdNo;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getBelongArea() {
        return belongArea;
    }

    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
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
