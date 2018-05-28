package com.cdkj.loan.enums;

public enum EBizLogType {

    REQ_BUDGET("005", "申请预算款"), CREDIT("001", "征信");

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
