package com.cdkj.loan.enums;

/**
 * 诉讼状态
 * @author: silver 
 * @since: 2018年6月17日 下午3:21:35 
 * @history:
 */
public enum ECaseStatus {

    RECORD("1", "立案"), HEAR("2", "审理"), JUDGE("3", "判决");

    ECaseStatus(String code, String value) {
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
