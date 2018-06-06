package com.cdkj.loan.dto.req;

public class XN632885Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -7543802108244979634L;

    // 申请人档案编号
    private String archieveCode;

    // 新部门
    private String newDepartment;

    // 状态
    private String status;

    private String applyDatetimeStart;// 申请时间起

    private String applyDatetimeEnd;// 申请时间止

    public String getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(String applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public String getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(String applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
