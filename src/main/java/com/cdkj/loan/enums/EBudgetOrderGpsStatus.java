package com.cdkj.loan.enums;

/**
 * 预算单GPS状态
 * @author: silver 
 * @since: 2018年6月18日 下午6:22:10 
 * @history:
 */
public enum EBudgetOrderGpsStatus {
    INVALID("0", "已作废"), USE_ING("1", "使用中");
    EBudgetOrderGpsStatus(String code, String value) {
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
