package com.cdkj.loan.enums;

/**
 * 收款账号类型
 * @author: CYL 
 * @since: 2018年5月26日 下午5:17:07 
 * @history:
 */
public enum ECollectBankcardType {
    PLATFORM("1", "平台普通账户"), DEALER_COLLECT("2", "经销商的收款账号"), DEALER_REBATE("3",
            "经销商返点账号");

    ECollectBankcardType(String code, String value) {
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
