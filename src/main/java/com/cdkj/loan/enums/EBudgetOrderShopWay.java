package com.cdkj.loan.enums;

/**
 * 预算单购车途径
 * @author: jiafr 
 * @since: 2018年7月2日 下午4:48:20 
 * @history:
 */
public enum EBudgetOrderShopWay {
    NEW("1", "新车"), OLD("2", "二手车");

    EBudgetOrderShopWay(String code, String value) {
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
