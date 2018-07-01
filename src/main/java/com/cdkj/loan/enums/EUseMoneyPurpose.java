package com.cdkj.loan.enums;

/**
 * 返点明细类型（用款用途）
 * @author: jiafr 
 * @since: 2018年6月16日 下午3:35:33 
 * @history:
 */
public enum EUseMoneyPurpose {

    MORTGAGE("1", "应退按揭款"), PROTOCOL_INNER("2", "协议内返点"), PROTOCOL_OUTER("3",
            "协议外返点");

    EUseMoneyPurpose(String code, String value) {
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
