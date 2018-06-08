package com.cdkj.loan.enums;

public enum ERepayPlanStatus {
    TO_REPAYMENTS("0", "待还款"), YET_REPAYMENTS("1", "正常已还款"), OVERDUE_TO_HANDLE(
            "2", "已逾期待处理"), HANDLLER_TO_HESUAN("3", "已处理待核算"), HESUAN_TO_GREEN(
            "4", "核算通过，进绿名单"), HESUANNOT_TO_BLACK("5", "核算不通过，进黑名单");

    // TO_REPAY("0", "待还款"), REPAY_YES("1", "已还款"), OVERDUE("2", "已逾期待处理"),
    // HANDLER_TO_GREEN(
    // "3", "缴纳违约押金，进绿名单"), HANDLER_TO_YELLOW("4", "已代偿，进黄名单"), HANDLER_TO_RED(
    // "5", "催收失败，进红名单处理"), DEPOSIT_END("6", "保证金方式结清"), CLEARS_END("7",
    // "直接全部结清");

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
