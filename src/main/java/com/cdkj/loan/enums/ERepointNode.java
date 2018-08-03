package com.cdkj.loan.enums;

/**
 * 返点支付流程
 * @author: jiafr 
 * @since: 2018年7月21日 下午12:19:14 
 * @history:
 */
public enum ERepointNode {

    MAKE_BILL("010_01", "制单"), BRANCH_MANAGER_APPROVE("010_02", "分公司总经理审批"), CONFIRM_PAY(
            "010_03", "确认放款(出纳打款)"), HAS_PAY("010_04", "已支付");

    ERepointNode(String code, String value) {
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
