package com.cdkj.loan.dto.req;

import java.util.List;

public class XN630540Req extends APageReq {

    private static final long serialVersionUID = 5066181160930283667L;

    private String userId;// 用户编号

    private String repayBizCode;// 关联业务编号

    private String status;// 状态

    private String overdueHandler;// 逾期处理人

    private List<String> statusList; // 状态List

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

}
