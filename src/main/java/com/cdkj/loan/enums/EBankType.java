package com.cdkj.loan.enums;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月16日 下午11:41:59 
 * @history:
 */
public enum EBankType {

    GH("1", "工行"), ZH("2", "中行"), JH("3", "建行");

    EBankType(String code, String value) {
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
