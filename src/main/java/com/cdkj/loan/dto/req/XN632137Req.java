package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632137Req {

    // 预算单编号
    @NotBlank
    private String budgetOrderCode;

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

}
