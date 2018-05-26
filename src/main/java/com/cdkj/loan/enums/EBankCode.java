package com.cdkj.loan.enums;

/**
 * 
 * @author: CYL 
 * @since: 2018年5月26日 下午11:26:09 
 * @history:
 */
public enum EBankCode {
    ICBC("1", "工行"), BOC("2", "中行"), CCB("3", "建行");

    EBankCode(String code, String value) {
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
