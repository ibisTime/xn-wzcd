package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630556Req {

    @NotBlank
    private String code;// 还款业务编号

    @NotBlank
    private String operator;// 操作人

    @NotBlank
    private String remitAmount;// 打款金额

    @NotBlank
    private String remitPdf;// 打款水单

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemitAmount() {
        return remitAmount;
    }

    public void setRemitAmount(String remitAmount) {
        this.remitAmount = remitAmount;
    }

    public String getRemitPdf() {
        return remitPdf;
    }

    public void setRemitPdf(String remitPdf) {
        this.remitPdf = remitPdf;
    }

}
