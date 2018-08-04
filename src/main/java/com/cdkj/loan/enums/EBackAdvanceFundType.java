package com.cdkj.loan.enums;

/**
 * 收回垫资款类型
 * @author: jiafr 
 * @since: 2018年8月4日 下午9:00:14 
 * @history:
 */
public enum EBackAdvanceFundType {
    CANCEL("1", "客户作废"), ADVANCE_FUND_BACK("2", "垫资款退回");

    EBackAdvanceFundType(String code, String value) {
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
