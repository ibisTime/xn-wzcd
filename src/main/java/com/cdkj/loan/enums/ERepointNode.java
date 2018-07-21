package com.cdkj.loan.enums;

/**
 * 返点流程
 * @author: jiafr 
 * @since: 2018年7月21日 下午12:19:14 
 * @history:
 */
public enum ERepointNode {
    MAKE_BILL("010_01", "制单"), BRANCH_MANAGER_APPROVE("010_02", "分公司总经理审批"), FINANCE_CONFIRM(
            "010_03", "财务确认"), CONFIRM_PAY("010_04", "确认放款(出纳打款)");

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
