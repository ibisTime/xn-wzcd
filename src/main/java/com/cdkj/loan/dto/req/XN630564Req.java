package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630564Req {

    @NotBlank
    private String code;// 编号

    @NotBlank
    private String appoveResult;// 处理结果

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAppoveResult() {
        return appoveResult;
    }

    public void setAppoveResult(String appoveResult) {
        this.appoveResult = appoveResult;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
