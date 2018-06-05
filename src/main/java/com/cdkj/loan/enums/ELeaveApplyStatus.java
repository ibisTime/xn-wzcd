package com.cdkj.loan.enums;

/**
 * 请假状态
 * @author: silver 
 * @since: 2018年6月5日 下午8:41:15 
 * @history:
 */
public enum ELeaveApplyStatus {
    TO_APPROVE("0", "待审核"), APPROVE_PASS("1", "审核通过"), APPROVE_FAIL("2",
            "审核不通过");

    ELeaveApplyStatus(String code, String value) {
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
