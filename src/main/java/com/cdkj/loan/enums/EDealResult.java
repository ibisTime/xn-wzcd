package com.cdkj.loan.enums;

/**
 * 处理结果
 * @author: xieyj 
 * @since: 2018年6月17日 下午5:52:42 
 * @history:
 */
public enum EDealResult {
    REDEEM("1", "用户赎回"), SELLED("2", "转卖"), GREEN("3", "用户结清"), JUDGE("4",
            "司法诉讼"), COMPANY_CLEARANCE("5", "公司结清"),DEFERRED_TREATMENT("6","暂缓处理");

    EDealResult(String code, String value) {
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
