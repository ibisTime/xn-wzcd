package com.cdkj.loan.enums;

/**
 * 公告阅读记录
 * @author: silver 
 * @since: 2018年6月7日 下午3:57:33 
 * @history:
 */
public enum ENoticeReadStatus {
    YES("1", "已读"), NO("0", "未读");

    ENoticeReadStatus(String code, String value) {
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
