package com.cdkj.loan.enums;

/**
 * gps使用
 * @author: xieyj 
 * @since: 2018年5月31日 上午6:19:51 
 * @history:
 */
public enum EGpsUseStatus {
    UN_USE("0", "待使用"), USED("1", "已使用");

    EGpsUseStatus(String code, String value) {
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
