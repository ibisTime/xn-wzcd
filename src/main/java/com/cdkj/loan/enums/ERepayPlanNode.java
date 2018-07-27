package com.cdkj.loan.enums;

public enum ERepayPlanNode {
    // 车贷
    TO_REPAY("022_01", "待还款"), REPAY_YES("022_02", "已还款"), OVERDUE("022_03",
            "已逾期待处理"), HANDLER_TO_GREEN("022_04", "已还款,进绿名单"), HANDLER_TO_YELLOW(
            "022_05", "已代偿，进黄名单"), HANDLER_TO_RED("022_06", "催收失败，进红名单处理中"), BAD_DEBT("022_08", "坏账");

    ERepayPlanNode(String code, String value) {
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
