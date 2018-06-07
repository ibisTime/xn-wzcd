package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午3:58:52 
 * @history:
 */
public class XN630050Req {

    // 登录名（必填）
    @NotBlank(message = "登录名不能为空")
    private String loginName;

    // 登录密码（选填）
    @NotBlank(message = "登录密码不能为空")
    private String loginPwd;

    // 手机号（必填）
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    // 真实姓名（必填）
    private String realName;

    // 类型（必填）
    @NotBlank(message = "类型不能为空")
    private String type;

    // 推荐人（选填）
    private String userRefree;

    // 角色编号
    @NotBlank
    private String roleCode;

    // 公司编号
    @NotBlank
    private String companyCode;

    // 部门编号
    @NotBlank
    private String departmentCode;

    // 岗位
    @NotBlank
    private String postCode;

    // 备注（选填）
    private String remark;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserRefree() {
        return userRefree;
    }

    public void setUserRefree(String userRefree) {
        this.userRefree = userRefree;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
