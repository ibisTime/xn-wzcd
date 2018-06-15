package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632322Req {
    @NotBlank
    private String code;// 编号

    @NotBlank
    private String operator;// 操作人

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

}
