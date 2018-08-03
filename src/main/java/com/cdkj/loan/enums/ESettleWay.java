package com.cdkj.loan.enums;

/**
 * 结算方式(1现结2月结3季结)
 * @author: jiafr 
 * @since: 2018年8月3日 下午2:45:28 
 * @history:
 */
public enum ESettleWay {

    NOW("1", "现结"), MONTH("2", "月结"), QUARTER("3", "季结");

    ESettleWay(String code, String value) {
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
