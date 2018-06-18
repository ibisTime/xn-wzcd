package com.cdkj.loan.enums;

/**
 * 履约保证金类型(1单笔/2贷款额百分比)
 * @author: jiafr 
 * @since: 2018年6月19日 上午3:50:02 
 * @history:
 */
public enum ELyAmountType {

    SINGLE("1", "单笔"), PERCENT("1", "贷款额百分比");

    ELyAmountType(String code, String value) {
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
