package com.cdkj.loan.dto.req;

public class XN630522Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String code;// 还款业务编号

    private String userId;// 用户编号

    private String refType;// 关联类型

    private String curNodeCode;// 节点

    // 角色编号
    private String roleCode;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

}
