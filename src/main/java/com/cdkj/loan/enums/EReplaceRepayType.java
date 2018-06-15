package com.cdkj.loan.enums;

/**
 * 代偿预算单申请类型
 * @author: silver 
 * @since: 2018年6月15日 上午10:23:06 
 * @history:
 */
public enum EReplaceRepayType {

    MONTHLY_PAYMENT("1", "月供"), REMAIN_LOAN("2", "剩余贷款金额");

    EReplaceRepayType(String code, String value) {
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
