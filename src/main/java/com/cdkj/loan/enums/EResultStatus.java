package com.cdkj.loan.enums;

/**
 * 结果是否
 * @author: CYL 
 * @since: 2018年6月11日 下午7:30:11 
 * @history:
 */
public enum EResultStatus {
    YES("1", "是"), NO("0", "否");

    EResultStatus(String code, String value) {
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
