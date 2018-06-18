package com.cdkj.loan.enums;

/**
 * 三种银行
 * @author: CYL 
 * @since: 2018年6月18日 下午1:40:59 
 * @history:
 */
public enum EbelongBank {
    GH("1", "工行"), ZH("2", "中行"), JH("3", "建行");

    EbelongBank(String code, String value) {
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
