package com.cdkj.loan.enums;

public enum EBankcard {
    NORMAL("0", "正常"), BLOCK_UP("1", "停用");

    EBankcard(String code, String value) {
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
