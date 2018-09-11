package com.cdkj.loan.dto.req;

public class XN632327Req extends AListReq {

    private static final long serialVersionUID = 1L;

    private String code;

    private String curNodeCode;

    // 业务编号(还款业务)
    private String bizCode;

    private String type;

    private String receiptRealName;

    private String startDatetime;

    private String endADatetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getReceiptRealName() {
        return receiptRealName;
    }

    public void setReceiptRealName(String receiptRealName) {
        this.receiptRealName = receiptRealName;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndADatetime() {
        return endADatetime;
    }

    public void setEndADatetime(String endADatetime) {
        this.endADatetime = endADatetime;
    }
}
