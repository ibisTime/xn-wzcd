package com.cdkj.loan.enums;

/**
 * 杂费类型(1单笔/2贷款额百分比)
 * @author: jiafr 
 * @since: 2018年6月19日 上午3:53:37 
 * @history:
 */
public enum EOtherType {

    SINGLE("1", "单笔"), PERCENT("2", "贷款额百分比");

    EOtherType(String code, String value) {
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
