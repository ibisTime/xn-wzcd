package com.cdkj.loan.enums;

/**
 * 金额来源
 * @author: jiafr 
 * @since: 2018年9月10日 上午11:39:45 
 * @history:
 */
public enum EFundSource {
    FINANCE_DEPARTMENT("1", "财务部"), ADVANCE_FUND("2", "预支款");

    EFundSource(String code, String value) {
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
