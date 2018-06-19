package com.cdkj.loan.enums;

public enum ERepointDetailUseMoneyPurpose {
    SHOULD_BACK("1", "应退按揭款"), PROIN_REPOINT("2", "协议内返点"), PROOUT_REPOINT("3",
            "协议外返点");

    ERepointDetailUseMoneyPurpose(String code, String value) {
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
