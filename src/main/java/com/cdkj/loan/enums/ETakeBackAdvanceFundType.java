package com.cdkj.loan.enums;

/**
 * 收回垫资款类型
 * @author: jiafr 
 * @since: 2018年7月17日 上午12:56:41 
 * @history:
 */
public enum ETakeBackAdvanceFundType {

    CUSTOMER_CANCEL("1", "客户作废"), ADVANCE_FUND_RETURN("2", "垫资款退回");

    ETakeBackAdvanceFundType(String code, String value) {
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
