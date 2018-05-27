package com.cdkj.loan.enums;

/**
 * 经销商审核节点
 * @author: CYL 
 * @since: 2018年5月23日 上午10:57:01 
 * @history:
 */
public enum ECarDealerNode {

    TO_AUDIT("006_01", "待审核"), AUDIT_PASS("006_02",
            "审核通过"), AUDIT_NOT_PASS("006_03", "审核不通过");

    ECarDealerNode(String code, String value) {
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
