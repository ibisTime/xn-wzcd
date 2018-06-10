package com.cdkj.loan.enums;

/**
 * 准入单 是否垫资
 * @author: jiafr 
 * @since: 2018年6月9日 下午8:53:45 
 * @history:
 */
public enum EIsAdvanceFund {
    YES("1", "是"), NO("0", "否");

    EIsAdvanceFund(String code, String value) {
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
