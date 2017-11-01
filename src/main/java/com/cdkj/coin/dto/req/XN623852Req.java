package com.cdkj.coin.dto.req;

import java.util.List;

public class XN623852Req {

    // 取现订单编号(必填)
    private List<String> codeList;

    // 支付回录人(必填)
    private String payUser;

    // 审核结果1 是 0 否(必填)
    private String payResult;

    // 支付回录说明(必填)
    private String payNote;

    // 支付渠道订单编号（支付渠道代表）(必填)
    private String channelOrder;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public String getPayNote() {
        return payNote;
    }

    public void setPayNote(String payNote) {
        this.payNote = payNote;
    }

    public String getChannelOrder() {
        return channelOrder;
    }

    public void setChannelOrder(String channelOrder) {
        this.channelOrder = channelOrder;
    }
}
