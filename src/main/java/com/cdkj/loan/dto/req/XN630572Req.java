package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 结清审核确认付款
 * @author: jiafr 
 * @since: 2018年7月30日 上午10:24:05 
 * @history:
 */
public class XN630572Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 结清付款时间
    @NotBlank
    private String settlePayDatetime;

    // 结清打款凭证
    @NotBlank
    private String settlePdf;

    // 结清说明
    @NotBlank
    private String settleNote;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSettlePayDatetime() {
        return settlePayDatetime;
    }

    public void setSettlePayDatetime(String settlePayDatetime) {
        this.settlePayDatetime = settlePayDatetime;
    }

    public String getSettlePdf() {
        return settlePdf;
    }

    public void setSettlePdf(String settlePdf) {
        this.settlePdf = settlePdf;
    }

    public String getSettleNote() {
        return settleNote;
    }

    public void setSettleNote(String settleNote) {
        this.settleNote = settleNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
