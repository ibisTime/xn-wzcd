package com.cdkj.loan.enums;

/**
 * 福利发放状态
 * @author: silver 
 * @since: 2018年6月6日 下午7:30:41 
 * @history:
 */
public enum EWelfareApplyStatus {
    TO_APPROVE("0", "待审核"), APPROVE_PASS("1", "审核通过"), APPROVE_FAIL("2",
            "审核不通过");

    EWelfareApplyStatus(String code, String value) {
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
