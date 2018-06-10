package com.cdkj.loan.enums;

/**
 * 准入单客户申请作废的冻结状态
 * @author: jiafr 
 * @since: 2018年6月10日 下午7:39:24 
 * @history:
 */
public enum EBudgetFrozenStatus {

    FROZEN("0", "冻结"), NORMAL("1", "正常");

    EBudgetFrozenStatus(String code, String value) {
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
