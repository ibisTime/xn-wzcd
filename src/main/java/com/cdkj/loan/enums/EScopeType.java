package com.cdkj.loan.enums;

/**
 * 公告范围类型
 * @author: silver 
 * @since: 2018年6月7日 下午2:43:10 
 * @history:
 */
public enum EScopeType {
    ALL("-1", "所有人员"), SUB_COMPANY("1", "分公司"), DEPARTMENT("2", "部门"), POST("3",
            "职位"), PEOPLE("4", "具体人");
    EScopeType(String code, String value) {
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
