package com.cdkj.loan.dto.req;

/**
 * 代偿预算单分页查
 * @author: silver 
 * @since: 2018年6月15日 上午10:56:32 
 * @history:
 */
public class XN632325Req extends APageReq {

    private static final long serialVersionUID = 1L;

    private String code;

    private String curNodeCode;

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
