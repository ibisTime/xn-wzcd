package com.cdkj.loan.enums;

/**
 * 代偿预算单申请
 * @author: silver 
 * @since: 2018年6月15日 上午10:23:06 
 * @history:
 */
public enum EReplaceRepayApplyNode {

    APPLY("017_01", "申请代偿预算单"), FINANCE_APPROVE("017_02", "财务经理审核"), MAKE_BILL(
            "017_03", "制单"), REAPPLY("017_04", "重新申请代偿预算单"), HAS_MAKE_BILL(
            "017_05", "已制单"), CANCEL("017_06", "作废");

    EReplaceRepayApplyNode(String code, String value) {
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
