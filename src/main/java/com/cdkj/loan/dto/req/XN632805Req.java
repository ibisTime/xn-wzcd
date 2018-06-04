package com.cdkj.loan.dto.req;

/**
 * 分页查询人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午9:15:41 
 * @history:
 */
public class XN632805Req extends APageReq {

    private static final long serialVersionUID = 5138736221155343722L;

    private String realName;

    private String departmentCode;

    private String postCode;

    private String entryDatetimeStart;

    private String entryDatetimeEnd;

    private String workStatus;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEntryDatetimeStart() {
        return entryDatetimeStart;
    }

    public void setEntryDatetimeStart(String entryDatetimeStart) {
        this.entryDatetimeStart = entryDatetimeStart;
    }

    public String getEntryDatetimeEnd() {
        return entryDatetimeEnd;
    }

    public void setEntryDatetimeEnd(String entryDatetimeEnd) {
        this.entryDatetimeEnd = entryDatetimeEnd;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

}
