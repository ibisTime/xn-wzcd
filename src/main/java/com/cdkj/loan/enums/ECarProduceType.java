package com.cdkj.loan.enums;

/**
 * 车辆产生类型
 * @author: CYL 
 * @since: 2018年11月15日 下午1:36:16 
 * @history:
 */
public enum ECarProduceType {
    IMPORT("1", "接口导入"), WRITE("2", "用户新增");

    ECarProduceType(String code, String value) {
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
