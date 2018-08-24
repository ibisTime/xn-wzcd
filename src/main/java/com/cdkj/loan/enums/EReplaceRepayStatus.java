package com.cdkj.loan.enums;

/**
 * 代偿预算单申请
 * @author: silver 
 * @since: 2018年6月15日 上午10:23:06 
 * @history:
 */
public enum EReplaceRepayStatus {

    TO_APPROVE("1", "待财务经理审核"), APPROVED_YES("2", "审核通过"), APPROVED_NO("3",
            "审核不通过"), MAKE_DOCUMENT("4", "制单"), DELETE("5", "作废");

    EReplaceRepayStatus(String code, String value) {
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
