package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 代偿审核分页查--根据角色
 * @author: silver 
 * @since: 2018年6月16日 上午10:23:17 
 * @history:
 */
public class XN632339Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String bizCode;// 业务编号

    private String curNodeCode;// 状态

    private String type;// 代偿类型

    @NotBlank
    private String roleCode; // 角色编号

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
