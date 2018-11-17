package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632126Req {

    @NotBlank
    private String code;// 预算单编号

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
