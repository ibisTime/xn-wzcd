package com.cdkj.loan.enums;

/**
 * 补件原因类型
 * @author: CYL 
 * @since: 2018年7月20日 上午9:57:16 
 * @history:
 */
public enum ESupplementReasonType {
    URGENT("1", "紧急"), NO_URGENT("0", "不紧急");

    ESupplementReasonType(String code, String value) {
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
