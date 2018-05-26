package com.cdkj.loan.enums;

public enum EGpsType {
    LINE("1", "有线"), NO_LINE("0", "无线");

    EGpsType(String code, String value) {
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
