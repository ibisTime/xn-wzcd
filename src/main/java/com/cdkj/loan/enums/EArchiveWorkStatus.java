package com.cdkj.loan.enums;

/**
 * 人事档案工作状态
 * @author: jiafr 
 * @since: 2018年8月13日 下午9:04:16 
 * @history:
 */
public enum EArchiveWorkStatus {

    TRY("1", "试用"), ON_JOB("2", "在职"), LEAVE("3", "离职"), RETIRE("4", "退休");

    EArchiveWorkStatus(String code, String value) {
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
