package com.cdkj.loan.enums;

/**
 * 用户申领状态
 * @author: xieyj 
 * @since: 2018年6月18日 下午2:34:16 
 * @history:
 */
public enum EGpsUserApplyStatus {

    TO_APPLY("0", "待申领"), APPLYING("1", "申领处理中"), APPLYED("2", "已申领");

    EGpsUserApplyStatus(String code, String value) {
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
