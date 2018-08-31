package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 代办事项APP
 * @author: jiafr 
 * @since: 2018年7月6日 下午2:05:21 
 * @history:
 */
public class XN630172Req {

    @NotBlank
    private String roleCode;// 角色编号

    private String teamCode;// 团队编号

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

}
