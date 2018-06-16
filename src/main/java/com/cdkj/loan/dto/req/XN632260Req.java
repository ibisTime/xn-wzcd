package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632260Req {

    // 准入单编号
    @NotBlank
    private String code;

    // 付款账号编号
    @NotBlank
    private String shouldBackBankcardCode;

    // 付款时间
    @NotBlank
    private String shouldBackDatetime;

    // 付款凭证
    @NotBlank
    private String shouldBackBillPdf;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShouldBackBankcardCode() {
        return shouldBackBankcardCode;
    }

    public void setShouldBackBankcardCode(String shouldBackBankcardCode) {
        this.shouldBackBankcardCode = shouldBackBankcardCode;
    }

    public String getShouldBackDatetime() {
        return shouldBackDatetime;
    }

    public void setShouldBackDatetime(String shouldBackDatetime) {
        this.shouldBackDatetime = shouldBackDatetime;
    }

    public String getShouldBackBillPdf() {
        return shouldBackBillPdf;
    }

    public void setShouldBackBillPdf(String shouldBackBillPdf) {
        this.shouldBackBillPdf = shouldBackBillPdf;
    }

}
