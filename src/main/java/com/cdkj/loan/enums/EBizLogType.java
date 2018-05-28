package com.cdkj.loan.enums;

public enum EBizLogType {

    REQ_BUDGET("005", "预算款"), BUDGET_ORDER("002", "预算单"), CREDIT("001", "征信");

    EBizLogType(String code, String value) {
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
