package com.cdkj.loan.enums;

/**
 * 中行手续费收取方式
 * @author: CYL 
 * @since: 2018年8月7日 下午2:05:21 
 * @history:
 */
public enum EBocFeeWay {
    STAGES("1", "分期"), DISPOSABLE("2", "一次性"), SURCHARGE("2", "附加费");

    EBocFeeWay(String code, String value) {
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
