package com.cdkj.loan.enums;

public enum EReplaceIsRepayStatus {
    TO_REPLACE("0", "待偿还"), REPLACE_PART("1", "已部分偿还"), REPLACE_ALL("2",
            "已全部偿还");

    EReplaceIsRepayStatus(String code, String value) {
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
