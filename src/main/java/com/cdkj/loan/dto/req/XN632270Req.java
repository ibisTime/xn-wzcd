package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632270Req {
    // 准入单编号
    @NotBlank
    private String code;

    // 作废原因
    @NotBlank
    private String zfReason;

    // 操作人
    @NotBlank
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZfReason() {
        return zfReason;
    }

    public void setZfReason(String zfReason) {
        this.zfReason = zfReason;
    }

}
