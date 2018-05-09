package com.cdkj.loan.enums;

/**
 * 催收方式
 * @author: CYL 
 * @since: 2018年5月9日 上午10:31:33 
 * @history:
 */
public enum ECollectStatus {

    SHORT_MESSAGE("0", "短信"), MESSAGE_PUSH("1", "消息推送");

    ECollectStatus(String code, String value) {
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
