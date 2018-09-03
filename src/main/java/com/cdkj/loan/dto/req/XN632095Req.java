package com.cdkj.loan.dto.req;

public class XN632095Req extends APageReq {

    private static final long serialVersionUID = 1097295458736658794L;

    // URL
    private String url;

    // 操作人
    private String operator;

    private String realName;// 真实姓名

    private String updateDatetimeStart;// 操作时间起始

    private String updateDatetimeEnd;// 操作时间结束

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUpdateDatetimeStart() {
        return updateDatetimeStart;
    }

    public void setUpdateDatetimeStart(String updateDatetimeStart) {
        this.updateDatetimeStart = updateDatetimeStart;
    }

    public String getUpdateDatetimeEnd() {
        return updateDatetimeEnd;
    }

    public void setUpdateDatetimeEnd(String updateDatetimeEnd) {
        this.updateDatetimeEnd = updateDatetimeEnd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
