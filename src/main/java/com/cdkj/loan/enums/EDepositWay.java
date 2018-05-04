package com.cdkj.loan.enums;

public enum EDepositWay {
    OFF_LINE("0", "线下"), WITHHOLD("1", "代扣");

    EDepositWay(String code, String value) {
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
