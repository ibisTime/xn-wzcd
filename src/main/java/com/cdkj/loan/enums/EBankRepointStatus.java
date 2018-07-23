package com.cdkj.loan.enums;

/**
 * 银行返点状态
 * @author: jiafr 
 * @since: 2018年7月23日 上午11:08:17 
 * @history:
 */
public enum EBankRepointStatus {

    NO("0", "未返点"), YES("1", "已返点");

    EBankRepointStatus(String code, String value) {
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
