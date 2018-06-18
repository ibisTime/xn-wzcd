package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * gps 安装回录
 * @author: silver 
 * @since: 2018年6月18日 下午5:51:55 
 * @history:
 */
public class XN632342Req {
    // GPS编号
    @NotBlank
    private String gpsCode;

    // 安装位置
    @NotBlank
    private String azLocation;

    // 安装时间
    @NotBlank
    private String azDatetime;

    // 安装人员
    @NotBlank
    private String azUser;

    // 预算单编号
    @NotBlank
    private String budgetOrder;

    // 备注
    private String remark;

    // 操作人
    private String operator;

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getAzLocation() {
        return azLocation;
    }

    public void setAzLocation(String azLocation) {
        this.azLocation = azLocation;
    }

    public String getAzDatetime() {
        return azDatetime;
    }

    public void setAzDatetime(String azDatetime) {
        this.azDatetime = azDatetime;
    }

    public String getAzUser() {
        return azUser;
    }

    public void setAzUser(String azUser) {
        this.azUser = azUser;
    }

    public String getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(String budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
