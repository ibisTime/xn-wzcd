package com.cdkj.loan.enums;

/**
 * 垫资业务类型
 * @author: jiafr 
 * @since: 2018年6月17日 上午10:57:32 
 * @history:
 */
public enum EAdvanceType {

    PARENT_BIZ("1", "本地公司业务"), BRANCH_BIZ("2", "外地公司业务");

    EAdvanceType(String code, String value) {
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
