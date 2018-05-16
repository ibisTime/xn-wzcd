package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN802110Req {

    @NotBlank
    private String bankCode;// 银行编号

    @NotBlank
    private String bankName;// 银行名称

    @NotBlank
    private String channelType;// 渠道类型

    @NotBlank
    private String status;// 状态(1 启用 0 不启用)

    @NotBlank
    private String channelBank;// 渠道给银行的代号

    @NotBlank
    private String maxOrder; // 笔数限制

    @NotBlank
    private String orderAmount;// 单笔限额

    @NotBlank
    private String dayAmount;// 每日限额

    @NotBlank
    private String monthAmount;// 每月限额

    private String remark;// 备注

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

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannelBank() {
        return channelBank;
    }

    public void setChannelBank(String channelBank) {
        this.channelBank = channelBank;
    }

    public String getMaxOrder() {
        return maxOrder;
    }

    public void setMaxOrder(String maxOrder) {
        this.maxOrder = maxOrder;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(String dayAmount) {
        this.dayAmount = dayAmount;
    }

    public String getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(String monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
