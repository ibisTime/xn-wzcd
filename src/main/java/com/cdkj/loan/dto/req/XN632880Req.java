package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632880Req {

    // 申请人档案编号
    @NotBlank
    private String archieveCode;

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

    public String getArchieveCode() {
        return archieveCode;
    }

    public void setArchieveCode(String archieveCode) {
        this.archieveCode = archieveCode;
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
