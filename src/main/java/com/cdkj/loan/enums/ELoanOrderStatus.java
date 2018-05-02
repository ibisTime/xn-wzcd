package com.cdkj.loan.enums;

public enum ELoanOrderStatus {
    // 0=待提交 1=待审核 2=审核不通过 3=审核通过
    TO_SUBMIT("0", "待提交"), TO_AUDIT("1", "待审核"), AUDIT_NOTPASS("2",
            "审核不通过"), AUDIT_PASS("3", "审核通过");

    ELoanOrderStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
