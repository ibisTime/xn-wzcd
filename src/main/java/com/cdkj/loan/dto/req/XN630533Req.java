package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630533Req {

    @NotBlank
    private String code;// 还款计划编号

    @NotBlank
    private String overdueDeposit;// 逾期扣除上次保证金

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOverdueDeposit() {
        return overdueDeposit;
    }

    public void setOverdueDeposit(String overdueDeposit) {
        this.overdueDeposit = overdueDeposit;
    }

}
