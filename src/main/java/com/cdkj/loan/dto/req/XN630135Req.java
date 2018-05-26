package com.cdkj.loan.dto.req;

/**
 * 
 * @author: CYL 
 * @since: 2018年5月26日 上午11:00:47 
 * @history:
 */
public class XN630135Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -5086166851379663826L;

    // （选填） 关键字
    private String keyword;

    private String type;// 类型

    private String status;// 状态

    private String roleCode;// 角色编号

    private String departmentCode;// 部门编号

    private String updater;// 更新人

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
