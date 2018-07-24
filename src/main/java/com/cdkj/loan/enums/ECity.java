package com.cdkj.loan.enums;


/**
 * 城市
 * @author: jiafr 
 * @since: 2018年7月20日 上午11:13:46 
 * @history:
 */
public enum ECity {
    WENZHOU("WENZHOU", "温州市");

    ECity(String code, String value) {
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
