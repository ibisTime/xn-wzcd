package com.cdkj.loan.enums;

public enum EIsSubmit {
    NOT_SUBMIT("0", "不提交"), SUBMIT("1", "提交");

    EIsSubmit(String code, String value) {
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
