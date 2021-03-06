package com.cdkj.loan.enums;

public enum EBizLogType {

    CREDIT("001", "征信"), BUDGET_ORDER("002", "预算单"), ADVANCE_FUND_PARENT("003",
            "总公司垫资"), ADVANCE_FUND_BRANCH("004", "分公司垫资"), REQ_BUDGET("005",
            "预算款"), CAR_DEALER_AUDIT("006", "汽车经销商审核"), BANK_LOAN_COMMIT("007",
            "银行放款"), REPOINT("010", "返点支付流程"), INVOICE_MISMATCH("011",
            "发票不匹配影响贷款额"), BUDGET_CANCEL("012", "客户作废"), REPLACE_REPAY_PLAN(
            "013", "代偿还款计划"), ARCHIVE("015", "人事档案"), FBH("016", "发保合"), REPLACE_REPAY_APPLY(
            "017", "代偿预算单"), REPAY_BIZ("020", "还款业务"), ABNORMAL_REPAY_BIZ(
            "021", "异常还款业务"), REPAY_PLAN("022", "还款计划"), BACK_ADVANCE_FUND(
            "014", "收回垫资款"), LOGISTICS("030", "资料传递");

    EBizLogType(String code, String value) {
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
