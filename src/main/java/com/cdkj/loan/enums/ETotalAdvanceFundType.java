package com.cdkj.loan.enums;

/**
 * 垫资汇总类型
 * @author: jiafr 
 * @since: 2018年6月17日 下午9:40:36 
 * @history:
 */
public enum ETotalAdvanceFundType {

    FIRST("1", "第一次打款"), SECOND("2", "发票不匹配补打款"), COLLECTION("3", "发票不匹配收回款"), ADVANCE_FUND_BACK(
            "4", "垫资款退回(分公司当天未垫资)");

    ETotalAdvanceFundType(String code, String value) {
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
