package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632210Req {

    @NotBlank
    private String code;// 准入单编号

    private String makeCardRemark;// 制卡备注

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMakeCardRemark() {
        return makeCardRemark;
    }

    public void setMakeCardRemark(String makeCardRemark) {
        this.makeCardRemark = makeCardRemark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
