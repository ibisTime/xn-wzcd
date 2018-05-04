package com.cdkj.loan.dto.req;

public class XN630540Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String userId;// 用户编号

    private String refType;// 关联类型

    private String refCode;// 关联业务编号

    private String status;// 状态

    private String overdueHandler;// 逾期处理人

    public String getOverdueHandler() {
        return overdueHandler;
    }

    public void setOverdueHandler(String overdueHandler) {
        this.overdueHandler = overdueHandler;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
