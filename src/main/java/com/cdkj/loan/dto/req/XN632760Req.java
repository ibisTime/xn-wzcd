package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 入库
 * @author: silver 
 * @since: 2018年6月5日 下午2:29:56 
 * @history:
 */
public class XN632760Req {
    // 产品编号
    @NotBlank
    private String productCode;

    // 数量
    @NotBlank
    private String quantity;

    // 单价
    @NotBlank
    private String price;

    // 有效期起
    private String validDateStart;

    // 有效期止
    private String validDateEnd;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getValidDateStart() {
        return validDateStart;
    }

    public void setValidDateStart(String validDateStart) {
        this.validDateStart = validDateStart;
    }

    public String getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(String validDateEnd) {
        this.validDateEnd = validDateEnd;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
