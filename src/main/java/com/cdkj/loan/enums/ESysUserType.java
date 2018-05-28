package com.cdkj.loan.enums;

/**
 * 用户类型
 * @author: xieyj 
 * @since: 2018年5月28日 下午9:45:41 
 * @history:
 */
public enum ESysUserType {
    Plat("P", "平台用户"), Plat_Sale("PS", "平台用户-业务员");

    ESysUserType(String code, String value) {
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
