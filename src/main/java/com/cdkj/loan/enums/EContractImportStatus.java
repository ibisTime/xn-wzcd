package com.cdkj.loan.enums;

/**
 * 银行合同导入状态
 * @author: CYL 
 * @since: 2018年7月24日 下午8:20:59 
 * @history:
 */
public enum EContractImportStatus {

    MATCH("0", "已匹配"), HANDLE("1", "已处理"), NOT_MATCH("2", "不匹配");
    EContractImportStatus(String code, String status) {
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
