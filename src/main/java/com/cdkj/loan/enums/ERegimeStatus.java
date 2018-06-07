package com.cdkj.loan.enums;

/**
 * 公告状态
 * @author: silver 
 * @since: 2018年6月7日 下午8:15:06 
 * @history:
 */
public enum ERegimeStatus {
    TO_PUBLISH("0", "待发布"), PUBLISHED("1", "已发布"), REMOVED("2", "已撤下");

    ERegimeStatus(String code, String value) {
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
