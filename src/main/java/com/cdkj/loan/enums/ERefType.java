package com.cdkj.loan.enums;

public enum ERefType {
    // 还款业务关联类型
    CAR("0", "汽车"), PRODUCT("1", "商品");

    ERefType(String code, String value) {
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
