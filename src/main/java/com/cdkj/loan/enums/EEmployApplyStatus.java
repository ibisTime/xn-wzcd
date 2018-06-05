package com.cdkj.loan.enums;

public enum EEmployApplyStatus {

    TO_INTERVIEW("0", "待面试"), INTERVIEW_YES("1", "已面试通过"), INTERVIEW_NO("2",
            "面试不通过");

    EEmployApplyStatus(String code, String value) {
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
