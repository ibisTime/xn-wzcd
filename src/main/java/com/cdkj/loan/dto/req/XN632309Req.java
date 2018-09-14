package com.cdkj.loan.dto.req;

public class XN632309Req extends APageReq {

    private static final long serialVersionUID = 744913162256497629L;

    // 客户姓名
    private String customerName;

    // 标记
    private String sign;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
