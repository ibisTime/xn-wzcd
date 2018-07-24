package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632251Req {

    // 编号
    @NotBlank
    private String code;

    // 预算单编号
    @NotBlank
    private String budgetOrderCode;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
