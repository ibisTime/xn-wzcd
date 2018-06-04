package com.cdkj.loan.dto.req;

/**
 * 列表查询人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午9:37:49 
 * @history:
 */
public class XN632817Req {

    private String realName;

    private String departmentCode;

    private String postCode;

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

}
