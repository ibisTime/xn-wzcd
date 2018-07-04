package com.cdkj.loan.enums;

/**
 * 预算单类型（1正常单2外单）
 * @author: jiafr 
 * @since: 2018年7月1日 下午2:08:32 
 * @history:
 */
public enum EBudgetType {

    NORMAL("1", "正常单"), OUT("2", "外单");

    EBudgetType(String code, String value) {
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
