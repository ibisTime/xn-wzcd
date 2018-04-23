package com.cdkj.loan.enums;

public enum ECarOrderStatus {

    DCL("0", "待处理"), YCL("1", "已处理");
    ECarOrderStatus(String code, String status) {
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
