package com.cdkj.loan.enums;

public enum ENoticeRegime {
    NOTICE("1", "公告"), REMIGE("2", "制度");

    ENoticeRegime(String code, String value) {
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
