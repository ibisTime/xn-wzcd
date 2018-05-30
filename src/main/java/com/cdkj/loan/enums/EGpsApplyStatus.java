package com.cdkj.loan.enums;

/**
 * gps申请
 * @author: silver 
 * @since: 2018年5月31日 上午12:21:06 
 * @history:
 */
public enum EGpsApplyStatus {
    TO_APPROVE("0", "待审核"), APPROVE_YES("1", "审核通过"), APPROVE_NO("2",
            "审核不通过"), TO_RECEIVE("3", "待收货"), RECEIVED("4", "已收货");

    EGpsApplyStatus(String code, String value) {
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
