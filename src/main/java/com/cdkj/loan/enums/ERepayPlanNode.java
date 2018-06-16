package com.cdkj.loan.enums;

public enum ERepayPlanNode {
    // 车贷
    TO_REPAY("021_01", "待还款"), REPAY_YES("021_02", "已还款"), OVERDUE("021_03",
            "已逾期待处理"), HANDLER_TO_GREEN("021_04", "已还款,进绿名单"), HANDLER_TO_YELLOW(
            "021_05", "已代偿，进黄名单"), HANDLER_TO_RED("021_06", "催收失败，进红名单处理"), QKCSB_APPLY_TC(
            "021_07", "红名单处理中"), BAD_DEBT("021_08", "坏账"),

    // 商品计划节点
    PRD_TO_REPAY("006_01", "待还款"), PRD_REPAY_YES("006_02", "已还款"), PRD_OVERDUE(
            "006_03", "已逾期待处理"), PRD_HANDLER_TO_GREEN("006_04", "逾期处理，进绿名单"), PRD_HANDLER_TO_BLACK(
            "006_05", "不还，进黑名单");

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
