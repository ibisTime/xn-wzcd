package com.cdkj.loan.dto.req;

/**
 * 申请撤销垫资
 * @author: jiafr 
 * @since: 2018年6月17日 下午3:44:03 
 * @history:
 */
public class XN632177Req {

    private String code;

    private String cancelReason;

    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
