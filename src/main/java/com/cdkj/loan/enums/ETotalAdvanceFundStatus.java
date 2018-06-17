package com.cdkj.loan.enums;

/**
 * 垫资汇总表状态
 * @author: jiafr 
 * @since: 2018年6月17日 上午11:59:16 
 * @history:
 */
public enum ETotalAdvanceFundStatus {

    TODO("0", "待打款给分公司"), HANDLED("1", "已打款给分公司");

    ETotalAdvanceFundStatus(String code, String value) {
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
