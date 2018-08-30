package com.cdkj.loan.enums;

/**
 * 人事档案状态
 * @author: CYL 
 * @since: 2018年8月30日 上午11:05:49 
 * @history:
 */
public enum EArchiveStatus {

    BRANCH_CEO_APPROVE("015_01", "分公司总经理审批"), ON_JOB("2", "行政部审批"), LEAVE("3",
            "离职"), RETIRE("4", "退休");

    EArchiveStatus(String code, String value) {
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
