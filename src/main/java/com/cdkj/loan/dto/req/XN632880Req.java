package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632880Req {

    // 申请人
    private String applyUser;

    // 申请时间
    private String applyDatetime;

    // 新部门
    @NotBlank
    private String newDepartment;

    // 新岗位
    @NotBlank
    private String newPosition;

    // 开始日期
    @NotBlank
    private String startDatetime;

    // 结束日期
    @NotBlank
    private String endDatetime;

    // 缘由
    private String reason;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(String applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(String newDepartment) {
        this.newDepartment = newDepartment;
    }

    public String getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(String newPosition) {
        this.newPosition = newPosition;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
