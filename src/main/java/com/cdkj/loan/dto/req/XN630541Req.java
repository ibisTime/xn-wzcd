package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630541Req {

    @NotBlank(message = "编号不能为空")
    private String code; // 编号（必填）

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
