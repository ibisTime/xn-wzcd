package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 审核
 * @author: silver 
 * @since: 2018年6月16日 下午3:39:21 
 * @history:
 */
public class XN630559Req {
    // 还款业务编号
    @NotBlank
    private String code;

    // 付款银行(公司结清)
    @NotBlank
    private String paymentBank;

    // 付款凭证(公司结清)
    @NotBlank
    private String paymentPdf;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPaymentBank() {
        return paymentBank;
    }

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }

    public String getPaymentPdf() {
        return paymentPdf;
    }

    public void setPaymentPdf(String paymentPdf) {
        this.paymentPdf = paymentPdf;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
