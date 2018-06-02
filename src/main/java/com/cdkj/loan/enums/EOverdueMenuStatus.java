package com.cdkj.loan.enums;

/**
 * 
 * @author: CYL 
 * @since: 2018年6月2日 下午9:24:02 
 * @history:
 */
public enum EOverdueMenuStatus {
    DCL("0", "待处理"), YCL("1", "已处理");

    EOverdueMenuStatus(String code, String value) {
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
