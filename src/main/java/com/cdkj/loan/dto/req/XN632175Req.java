package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认打款车行
 * @author: jiafr 
 * @since: 2018年6月17日 下午12:01:55 
 * @history:
 */
public class XN632175Req {

    // 垫资单编号编号
    @NotBlank
    private String code;

    // 垫资金额
    @NotBlank
    private String advanceFundAmount;

    // 垫资日期
    @NotBlank
    private String advanceFundDatetime;

    // 付款银行编号
    @NotBlank
    private String payBankcardCode;

    // 付款凭证
    @NotBlank
    private String billPdf;

    // 意见说明
    private String note;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdvanceFundAmount() {
        return advanceFundAmount;
    }

    public void setAdvanceFundAmount(String advanceFundAmount) {
        this.advanceFundAmount = advanceFundAmount;
    }

    public String getAdvanceFundDatetime() {
        return advanceFundDatetime;
    }

    public void setAdvanceFundDatetime(String advanceFundDatetime) {
        this.advanceFundDatetime = advanceFundDatetime;
    }

    public String getPayBankcardCode() {
        return payBankcardCode;
    }

    public void setPayBankcardCode(String payBankcardCode) {
        this.payBankcardCode = payBankcardCode;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
