package com.cdkj.loan.enums;

/**
 * @author: xieyj 
 * @since: 2018年5月31日 上午4:31:05 
 * @history:
 */
public enum ELoanProductStatus {
    TO_PUBLISH("1", "待上架"), PUBLISH_YES("2", "已上架"), PUBLISH_NO("3", "已下架");

    ELoanProductStatus(String code, String value) {
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
