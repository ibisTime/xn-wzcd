package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

public class ProductSpecs extends ABaseDO {

    private static final long serialVersionUID = 2484198146787764549L;

    // ******************db properties ********************
    // 编号
    private String code;

    // 名称
    private String name;

    // 展示图
    private String pic;

    // 产品编号
    private String productCode;

    // 市场参考价，原价
    private Long originalPrice;

    // 现价(人民币)
    private Long price;

    // 首付比例
    private double sfRate;

    // 总期数
    private int periods;

    // 银行利率
    private double bankRate;

    // 库存
    private Integer quantity;

    // 发货地（ 精确到省份）
    private String province;

    // 重量（kg）
    private Double weight;

    // 相对位置编号
    private Integer orderNo;

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

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public double getSfRate() {
        return sfRate;
    }

    public void setSfRate(double sfRate) {
        this.sfRate = sfRate;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public double getBankRate() {
        return bankRate;
    }

    public void setBankRate(double bankRate) {
        this.bankRate = bankRate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    // ******************db properties ********************

}
