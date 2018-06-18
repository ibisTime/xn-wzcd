package com.cdkj.loan.enums;

/**
 * 利率类型
 * @author: jiafr 
 * @since: 2018年6月16日 下午10:06:00 
 * @history:
 */
public enum ERateType {

    GH_CT("1", "工行传统"), ZH_CT("2", "中行传统"), JH_CT("3", "建行传统"), GH_ZK("4",
            "工行直客"), ZH_ZK("5", "中行直客"), JH_ZK("6", "建行直客");

    ERateType(String code, String value) {
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
