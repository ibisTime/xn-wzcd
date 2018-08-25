package com.cdkj.loan.enums;

/**
 * 执行结果
 * @author: CYL 
 * @since: 2018年8月25日 下午8:20:57 
 * @history:
 */
public enum EExeResult {
    FINISH_NORMAL("1", "执毕"), ABORT("2", "和解"), FINISH_BAD("3", "终结");

    EExeResult(String code, String value) {
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
