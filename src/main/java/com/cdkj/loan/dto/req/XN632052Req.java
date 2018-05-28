package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改支行信息
 * @author: silver 
 * @since: 2018年5月28日 上午10:23:05 
 * @history:
 */
public class XN632052Req {
    // 编号
    @NotBlank
    private String id;

    // 银行编号
    @NotBlank
    private String bankCode;

    // 简称
    private String abbrName;

    // 全称
    @NotBlank
    private String fullName;

    // 开户行
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
    private String clientVolidDate;

    // 授权人姓名
    private String autherName;

    // 授权人电话
    private String autherPhone;

    // 授权人身份证
    private String authorIdNo;

    // 授权人地址
    private String authorAddress;

    // 信用卡类型
    private String creditCardType;

    // 信用卡名称
    private String creaditCardName;

    // 所属地区
    private String belongArea;

    // 更新人
    @NotBlank
    private String updater;

    // 备注
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getClientVolidDate() {
        return clientVolidDate;
    }

    public void setClientVolidDate(String clientVolidDate) {
        this.clientVolidDate = clientVolidDate;
    }

    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public String getAutherPhone() {
        return autherPhone;
    }

    public void setAutherPhone(String autherPhone) {
        this.autherPhone = autherPhone;
    }

    public String getAuthorIdNo() {
        return authorIdNo;
    }

    public void setAuthorIdNo(String authorIdNo) {
        this.authorIdNo = authorIdNo;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreaditCardName() {
        return creaditCardName;
    }

    public void setCreaditCardName(String creaditCardName) {
        this.creaditCardName = creaditCardName;
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
