package com.cdkj.loan.enums;

/**
 * 返点状态
 * @author: jiafr 
 * @since: 2018年6月9日 下午6:38:51 
 * @history:
 */
public enum ERepointStatus {

    TODO("0", "待打款"), HANDLED("1", "已打款");

    ERepointStatus(String code, String value) {
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
