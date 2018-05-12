package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN802502Req {

    // 账户编号(必填)
    @NotBlank
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
