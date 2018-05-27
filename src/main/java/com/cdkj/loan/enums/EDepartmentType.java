package com.cdkj.loan.enums;

public enum EDepartmentType {
    SUBBRANCH_COMPANY("1", "子公司"), DEPARTMENT("2", "部门"), POSITION("3", "职位");

    EDepartmentType(String code, String value) {
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
