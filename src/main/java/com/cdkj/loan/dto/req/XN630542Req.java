package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630542Req extends AListReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String userId;// 用户编号

    private String refType;// 类型

    private String curNodeCode;// 节点编号

    @NotBlank
    private String repayBizCode;// 关联业务编号

    private String overdueHandler;// 逾期处理人

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getOverdueHandler() {
        return overdueHandler;
    }

    public void setOverdueHandler(String overdueHandler) {
        this.overdueHandler = overdueHandler;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
