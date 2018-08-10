package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author: jiafr 
 * @since: 2018年8月10日 下午2:48:18 
 * @history:
 */
public class XN632310Req {

    @NotBlank
    private String code;

    @NotBlank
    private String actualAmount;

    @NotBlank
    private String waterBill;

    @NotBlank
    private String updater;

    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(String waterBill) {
        this.waterBill = waterBill;
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
