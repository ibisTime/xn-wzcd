package com.cdkj.loan.enums;

/**
 * GPS申领单类型
 * @author: silver 
 * @since: 2018年5月31日 上午2:40:13 
 * @history:
 */
public enum EGpsApplyType {
    COMPANY("1", "公司"), PERSON("", "个人");

    EGpsApplyType(String code, String value) {
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
