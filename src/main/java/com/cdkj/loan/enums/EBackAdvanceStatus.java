package com.cdkj.loan.enums;

/**
 * 退客户垫资款状态
 * @author: jiafr 
 * @since: 2018年6月9日 下午9:34:51 
 * @history:
 */
public enum EBackAdvanceStatus {

    NONEED_BACK("0", "无需退款"), TODO_BACK("1", "银行已放款待财务退款"), HANDLED_BACK("2",
            "财务已退垫资款定");

    EBackAdvanceStatus(String code, String value) {
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
