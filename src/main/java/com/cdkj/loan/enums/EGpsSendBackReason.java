package com.cdkj.loan.enums;

/**
 * GPS回退原因
 * @author: jiafr 
 * @since: 2018年7月30日 下午4:01:55 
 * @history:
 */
public enum EGpsSendBackReason {

    DAMAGE("1", "GPS损坏"), EMPLOYEE_LEAVE("2", "员工离职");

    EGpsSendBackReason(String code, String value) {
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
