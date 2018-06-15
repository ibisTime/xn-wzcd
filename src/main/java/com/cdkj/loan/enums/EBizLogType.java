package com.cdkj.loan.enums;

public enum EBizLogType {

    CREDIT("001", "征信"), BUDGET_ORDER("002", "预算单"), REQ_BUDGET("005", "预算款"), ADVANCE_FUND_PARENT(
            "003", "总公司垫资"), ADVANCE_FUND_BRANCH("004", "分公司垫资"), INVOICE_MISMATCH(
            "011", "发票不匹配影响贷款额"), BUDGET_CANCEL("012", "客户作废");

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
