package com.cdkj.loan.enums;

/**
 * 执行结果
 * @author: xieyj 
 * @since: 2018年6月17日 下午5:52:42 
 * @history:
 */
public enum EExeResult {
    FINISH_NORMAL("1", "完毕"), ABORT("2", "中止"), FINISH_BAD("3", "终结");

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
