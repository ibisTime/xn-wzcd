package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 菜单角色-增加菜单角色
 * @author: xieyj 
 * @since: 2016年5月16日 下午10:46:42 
 * @history:
 */
public class XN630020Req {

    // 角色编号（必填）
    @NotBlank(message = "角色编号不能为空")
    private String roleCode;

    // 菜单数组（必填）
    @NotBlank(message = "菜单数组不能为空")
    private List<String> menuCodeList;

    // 更新人（必填）
    @NotBlank(message = "更新人不能为空")
    private String updater;

    // 备注（选填）
    private String remark;

    // 系统编号(必填)
    @NotBlank(message = "系统编号(不能为空")
    private String systemCode;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<String> getMenuCodeList() {
        return menuCodeList;
    }

    public void setMenuCodeList(List<String> menuCodeList) {
        this.menuCodeList = menuCodeList;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
