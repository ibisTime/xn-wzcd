package com.cdkj.loan.enums;

/**
 * 请款预算单节点
 * @author: CYL 
 * @since: 2018年5月23日 上午10:57:01 
 * @history:
 */
public enum EReqBudgetNode {

    APPLY("01", "填写申请垫资请款预算单"), AUDIT("02", "财务经理审核"), CREDIT("03", "确认放款");

    EReqBudgetNode(String code, String value) {
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
