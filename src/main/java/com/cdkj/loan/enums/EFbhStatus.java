package com.cdkj.loan.enums;

/** 
 * 发保合状态
 * @author: CYL 
 * @since: 2018年6月17日 下午9:39:35 
 * @history:
 */
public enum EFbhStatus {
    PENDING_ENTRY("0", "待录入"), TO_PENDING_ENTRY("1", "已录入");

    EFbhStatus(String code, String value) {
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
