package com.cdkj.loan.enums;

/**
 * 返点明细状态
 * @author: jiafr 
 * @since: 2018年6月16日 下午10:32:31 
 * @history:
 */
public enum ERepointDetailStatus {

    GENERATE("0", "生成"), TODO_PAY("1", "待支付"), APPROVE("2", "审批中"), HAS_PAY(
            "3", "已支付");

    ERepointDetailStatus(String code, String value) {
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
