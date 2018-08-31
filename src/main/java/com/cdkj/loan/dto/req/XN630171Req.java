package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 代办事项OSS
 * @author: jiafr 
 * @since: 2018年7月6日 下午2:05:21 
 * @history:
 */
public class XN630171Req extends APageReq {

    private static final long serialVersionUID = 7948180551552144337L;

    @NotBlank
    private String roleCode;// 角色编号

    private String teamCode;// 团队编号

    private String refOrder;// 业务编号

    private String refType;// 流程类型

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

    public String getRefOrder() {
        return refOrder;
    }

    public void setRefOrder(String refOrder) {
        this.refOrder = refOrder;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

}
