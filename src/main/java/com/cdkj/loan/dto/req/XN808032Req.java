package com.cdkj.loan.dto.req;

public class XN808032Req {

    // 编号(必填)
    private String code;

    // 名称(必填)
    private String name;

    // 市场参考价，原价
    private String originalPrice;

    // 价格(人民币)(必填)
    private String price;

    // 库存(必填)
    private String quantity;

    // 相对位置编号(必填)
    private String orderNo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

}
