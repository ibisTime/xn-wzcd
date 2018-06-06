package com.cdkj.loan.enums;

public enum EFeeAdvanceApplyStatus {

    TO_APPROVE("1", "待审核"), APPROVE_YES("1", "待财务审核"), APPROVE_NO("2", "审核不通过"), FINANCE_APPROVE_YES(
            "3", "财务审核通过"), FINANCE_APPROVE_NO("4", "财务审核不通过"), SURE_FK("5",
            "确认放款");

    EFeeAdvanceApplyStatus(String code, String value) {
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
