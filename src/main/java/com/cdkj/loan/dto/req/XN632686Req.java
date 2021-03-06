package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 按月分页查询考勤汇总记录
 * @author: silver 
 * @since: 2018年6月4日 下午7:45:50 
 * @history:
 */
public class XN632686Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 464900751873626340L;

    // 日期
    @NotBlank
    private String date;

    // 部门
    private String departmentCode;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

}
