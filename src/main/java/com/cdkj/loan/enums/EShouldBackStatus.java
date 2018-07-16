package com.cdkj.loan.enums;

/**
 * 应退按揭款状态(0无需退款1银行已放款待财务退款2财务已退垫资款)
 * @author: jiafr 
 * @since: 2018年7月16日 下午4:15:58 
 * @history:
 */
public enum EShouldBackStatus {
    NO_NEED_REFUND("0", "无需退款"), TODO_REFUND("1", "银行已放款待财务退款"), ALREADY_REFUND(
            "2", "财务已退垫资款");

    EShouldBackStatus(String code, String value) {
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
