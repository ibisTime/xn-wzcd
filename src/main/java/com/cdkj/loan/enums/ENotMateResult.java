package com.cdkj.loan.enums;

/**
 * 不匹配原因
 * @author: CYL 
 * @since: 2018年9月8日 下午8:11:43 
 * @history:
 */
public enum ENotMateResult {
    ONE_CARD_MORE_LOAN("1", "一卡多贷"), INFO_NOT_MATE("0", "信息不匹配");

    ENotMateResult(String code, String value) {
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
