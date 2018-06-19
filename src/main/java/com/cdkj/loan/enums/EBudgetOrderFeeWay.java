package com.cdkj.loan.enums;

public enum EBudgetOrderFeeWay {
    TRANSFER("1", "转账"), AN_JIE("2", "按揭款"), REPOINT("3", "返点"), NOT_FEE("4",
            "不收费");

    EBudgetOrderFeeWay(String code, String value) {
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
