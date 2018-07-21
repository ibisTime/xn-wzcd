package com.cdkj.loan.enums;

public enum ERepayPlanNode {
    // 车贷
    TO_REPAY("021_01", "待还款"), REPAY_YES("021_02", "已还款"), OVERDUE("021_03",
            "已逾期待处理"), HANDLER_TO_GREEN("021_04", "已还款,进绿名单"), HANDLER_TO_YELLOW(
            "021_05", "已代偿，进黄名单"), HANDLER_TO_RED("021_06", "催收失败，进红名单处理中"), BAD_DEBT("021_08", "坏账");

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
