package com.cdkj.loan.dto.req;

/**
 * 分页查询
 * @author: jiafr 
 * @since: 2018年6月6日 下午10:16:59 
 * @history:
 */
public class XN632645Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 申请人
    private String applyUser;

    // 申请部门编号
    private String departmentCode;

    // 申请日期起
    private String startApplyDatetime;

    // 申请日期止
    private String endApplyDatetime;

    // 办理状态
    private String status;

    // 类型(1=办公 2=固定资产)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
