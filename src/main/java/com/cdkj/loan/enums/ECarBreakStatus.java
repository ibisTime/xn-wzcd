package com.cdkj.loan.enums;

/**
 * 违章处理状态
 * @author: silver 
 * @since: 2018年6月6日 下午4:55:10 
 * @history:
 */
public enum ECarBreakStatus {
    TO_APPROVE("0", "待审核"), APPROVE_PASS("1", "审核通过"), APPROVE_FAIL("2",
            "审核不通过");

    ECarBreakStatus(String code, String value) {
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
