package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认放款
 * @author: silver 
 * @since: 2018年6月10日 上午10:49:34 
 * @history:
 */
public class XN630555Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 打款时间
    @NotBlank
    private String remitDatetime;

    // 打款银行
    @NotBlank
    private String remitBankCode;

    // 打款水单
    @NotBlank
    private String remitBillPdf;

    // 最近修改人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemitDatetime() {
        return remitDatetime;
    }

    public void setRemitDatetime(String remitDatetime) {
        this.remitDatetime = remitDatetime;
    }

    public String getRemitBankCode() {
        return remitBankCode;
    }

    public void setRemitBankCode(String remitBankCode) {
        this.remitBankCode = remitBankCode;
    }

    public String getRemitBillPdf() {
        return remitBillPdf;
    }

    public void setRemitBillPdf(String remitBillPdf) {
        this.remitBillPdf = remitBillPdf;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
