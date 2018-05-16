package com.cdkj.loan.dto.req;

public class XN802116Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 渠道银行
    private String channelType;

    // 渠道银行代号
    private String channelBank;

    // 状态(1 启用 0 不启用)
    private String status;

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

    public String getChannelBank() {
        return channelBank;
    }

    public void setChannelBank(String channelBank) {
        this.channelBank = channelBank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
