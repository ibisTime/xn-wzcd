package com.cdkj.loan.enums;

/**
 * 预算单类型
 * @author: jiafr 
 * @since: 2018年6月28日 下午4:07:23 
 * @history:
 */
public enum EBudgetOrderType {

    NORMAL("1", "正常"), out_order("2", "外单");

    EBudgetOrderType(String code, String value) {
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
