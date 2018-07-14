package com.cdkj.loan.enums;

/**
 * 入档状态
 * @author: jiafr 
 * @since: 2018年7月14日 下午2:48:23 
 * @history:
 */
public enum EEnterFileStatus {

    TODO("0", "待入档"), TODO_MAKEUP("1", "待补录"), ACHIEVE("2", "已入档");
    EEnterFileStatus(String code, String status) {
        this.code = code;
        this.status = status;
    }

    private String code;

    private String status;

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

}
