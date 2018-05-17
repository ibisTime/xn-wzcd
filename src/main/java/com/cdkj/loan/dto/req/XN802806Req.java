package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN802806Req {

    @NotBlank
    private String code;

    // 系统编号
    @NotBlank
    private String systemCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}
