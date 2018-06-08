package com.cdkj.loan.dto.req;

/**
 * 分页查询
 * @author: jiafr 
 * @since: 2018年6月6日 下午10:16:59 
 * @history:
 */
public class XN632647Req {

    private String applyUser;

    private String departmentCode;

    private String startApplyDatetime;

    private String endApplyDatetime;

    private String status;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getStartApplyDatetime() {
        return startApplyDatetime;
    }

    public void setStartApplyDatetime(String startApplyDatetime) {
        this.startApplyDatetime = startApplyDatetime;
    }

    public String getEndApplyDatetime() {
        return endApplyDatetime;
    }

    public void setEndApplyDatetime(String endApplyDatetime) {
        this.endApplyDatetime = endApplyDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
