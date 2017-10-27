package com.cdkj.coin.dto.req;

public class XN623851Req {

    // 用户编号
    private String fromUserId;

    // 接受地址
    private String toAddress;

    // 金额
    private String amount;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
