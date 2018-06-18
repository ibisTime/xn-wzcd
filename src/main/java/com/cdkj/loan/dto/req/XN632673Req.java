package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认放款
 * @author: xieyj 
 * @since: 2018年6月6日 下午9:13:47 
 * @history:
 */
public class XN632673Req {

    // 编号
    @NotBlank
    private String code;

    // 付款时间
    @NotBlank
    private String payDatetime;

    // 付款账号
    @NotBlank
    private String payBankcard;

    // 付款凭证
    @NotBlank
    private String payPdf;

    @NotBlank
    private String updater;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(String payDatetime) {
        this.payDatetime = payDatetime;
    }

    public String getPayBank() {
        return payBank;
    }

    public void setPayBank(String payBank) {
        this.payBank = payBank;
    }

    public String getPayBankcard() {
        return payBankcard;
    }

    public void setPayBankcard(String payBankcard) {
        this.payBankcard = payBankcard;
    }

    public String getPayPdf() {
        return payPdf;
    }

    public void setPayPdf(String payPdf) {
        this.payPdf = payPdf;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
