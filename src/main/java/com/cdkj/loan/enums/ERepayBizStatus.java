package com.cdkj.loan.enums;

public enum ERepayBizStatus {
    TO_REPAYMENTS("0", "还款中"), YET_REPAYMENTS("1", "正常已还款"), YET_CLEARANCE("2",
            "正常结清"), EARLY_REPAYMENT("3", "提前还款"), YET_EARLY_CLEARANCE("4",
                    "确认提前结清"), YET_NOT_CONFIRMED("5",
                            "确认提前结清"), YET_CONFRIM_RESULT("6", "确认处理结果");

    ERepayBizStatus(String code, String value) {
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
