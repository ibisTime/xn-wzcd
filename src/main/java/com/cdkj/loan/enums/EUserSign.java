package com.cdkj.loan.enums;

/**
 * @author: xieyj 
 * @since: 2018年7月1日 下午8:25:25 
 * @history:
 */
public enum EUserSign {
    // 标记(0=白名单 1=绿名单 2=黄名单 3=红名单)
    WHITE("0", "白名单"), GREEN("1", "绿名单"), YELLOW("2", "黄名单"), RED("3", "红名单");

    EUserSign(String code, String value) {
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
