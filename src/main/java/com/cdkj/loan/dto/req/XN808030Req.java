package com.cdkj.loan.dto.req;

public class XN808030Req {

    // 名称(必填)
    private String name;

    // 图片(必填)
    private String pic;

    // 产品(必填)
    private String productCode;

    // 市场参考价，原价
    private String originalPrice;

    // 价格(人民币)(必填)
    private String price;

    // 库存(必填)
    private String quantity;

    // 发货地（ 精确到省份）(必填)
    private String province;

    // 重量（kg）(必填)
    private String weight;

    // 相对位置编号(必填)
    private String orderNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

}
