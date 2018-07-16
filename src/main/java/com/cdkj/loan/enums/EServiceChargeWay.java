package com.cdkj.loan.enums;

/**
 * 手续费收取方式
 * @author: jiafr 
 * @since: 2018年6月16日 下午3:26:38 
 * @history:
 */
public enum EServiceChargeWay {

    TRANSFER_ACCOUNTS("1", "转账"), MORTGAGE("2", "按揭款扣"), REPOINT("3", "返点扣"), NO_FEE(
            "4", "不收费");

    EServiceChargeWay(String code, String value) {
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
