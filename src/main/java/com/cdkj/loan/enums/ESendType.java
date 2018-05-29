package com.cdkj.loan.enums;

/**
 * 发货类型
 * @author: silver 
 * @since: 2018年5月29日 下午10:14:16 
 * @history:
 */
public enum ESendType {
    OFFLINE("1", "线下"), EXPRESS("2", "快递");

    ESendType(String code, String value) {
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
