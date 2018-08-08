package com.cdkj.loan.enums;

/**
 * 附加费
 * @author: CYL 
 * @since: 2018年8月8日 下午4:07:53 
 * @history:
 */
public enum ESurcharge {
    SIX_THOUSAND("1", "6000"), SIX_THOUSAND_ONE("2", "6100");

    ESurcharge(String code, String value) {
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
