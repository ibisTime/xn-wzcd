package com.cdkj.loan.enums;

public enum ELoanRole {

    APPLY_USER("1", "申请人"), GHR("2", "共还人"), GUARANTOR("3", "担保人");

    ELoanRole(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

}
