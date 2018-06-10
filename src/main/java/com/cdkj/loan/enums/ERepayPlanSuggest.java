package com.cdkj.loan.enums;

/**
 * 还款计划建议
 * @author: CYL 
 * @since: 2018年6月11日 上午2:16:54 
 * @history:
 */
public enum ERepayPlanSuggest {
    SIX_SAFEGUARDS("1", "6个月保证金"), ALREADY_CLEAR("2", "已结清");

    ERepayPlanSuggest(String code, String value) {
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
