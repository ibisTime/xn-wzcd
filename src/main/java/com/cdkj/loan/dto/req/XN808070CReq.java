package com.cdkj.loan.dto.req;

/**
 * 查询油费
 * @author: xieyj 
 * @since: 2017年10月17日 上午10:04:37 
 * @history:
 */
public class XN808070CReq {
    // 产品编号(必填)
    private String productSpecsCode;

    // 产品数量(必填)
    private String quantity;

    public String getProductSpecsCode() {
        return productSpecsCode;
    }

    public void setProductSpecsCode(String productSpecsCode) {
        this.productSpecsCode = productSpecsCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
