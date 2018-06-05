package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 出库
 * @author: silver 
 * @since: 2018年6月5日 下午4:39:13 
 * @history:
 */
public class XN632770Req {
    // 数量
    @NotBlank
    private String quantity;

    // 入库编号
    @NotBlank
    private String storageInCode;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    public String getStorageInCode() {
        return storageInCode;
    }

    public void setStorageInCode(String storageInCode) {
        this.storageInCode = storageInCode;
    }

}
