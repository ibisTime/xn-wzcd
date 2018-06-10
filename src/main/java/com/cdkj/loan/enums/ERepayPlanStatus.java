package com.cdkj.loan.enums;

public enum ERepayPlanStatus {
    TO_REPAYMENTS("0", "待还款"), YET_REPAYMENTS("1", "正常已还款"), OVERDUE_TO_HANDLE(
            "2", "已逾期待处理"), HESUAN_TO_GREEN("4", "核算通过，进绿名单"), HESUANNOT_TO_BLACK(
            "5", "核算不通过，进黑名单");

    ERepayPlanStatus(String code, String value) {
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
