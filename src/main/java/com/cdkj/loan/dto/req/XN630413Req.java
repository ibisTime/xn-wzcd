package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630413Req {

    @NotBlank(message = "编号不能为空")
    private String code; // 编号（必填）

    @NotBlank(message = "UI位置不能为空")
    private String location; // UI位置

    @NotBlank(message = "UI次序不能为空")
    private String orderNo;// UI次序

    @NotBlank(message = "最新修改人不能为空")
    private String updater; // 最新修改人（必填）

    private String remark; // 备注（选填）

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
