package com.cdkj.loan.dto.res;

import java.util.Date;

public class XN632833Res {

    // 姓名
    private String realName;

    // 档案编号
    private String archiveCode;

    // 部门名称
    private String departmentName;

    // 结束日期
    private Date endDatetime;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getArchiveCode() {
        return archiveCode;
    }

    public void setArchiveCode(String archiveCode) {
        this.archiveCode = archiveCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

}
