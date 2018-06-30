package com.cdkj.loan.enums;

/**
 * 返点明细类型（1正常数据2发票不匹配产生的新数据）
 * @author: jiafr 
 * @since: 2018年6月30日 下午7:36:21 
 * @history:
 */
public enum ERepointDetailType {

    NORMAL("1", "正常数据"), NEW("2", "发票不匹配产生的新数据");

    ERepointDetailType(String code, String value) {
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
