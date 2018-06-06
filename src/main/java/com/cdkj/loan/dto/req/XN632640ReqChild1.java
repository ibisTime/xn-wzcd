package com.cdkj.loan.dto.req;

/**
 * 新增办公用品/固定资产申请 办公物品列表
 * @author: jiafr 
 * @since: 2018年6月6日 下午5:52:40 
 * @history:
 */
public class XN632640ReqChild1 {

    private String productCode;

    private String mode;

    private String quantity;

    private String price;

    private String remark;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
