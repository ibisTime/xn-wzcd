package com.cdkj.loan.enums;

/**
 * 制卡状态
 * @author: CYL 
 * @since: 2018年6月17日 下午3:09:15 
 * @history:
 */
public enum EMakeCardStatus {

    PENDING_CARD("0", "待制卡"), ALREADY_MADE_CARD("1", "已制卡"), PENDING_RECORD("2",
            "待回录"), BACK_RECORD("3", "已回录");

    EMakeCardStatus(String code, String value) {
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
