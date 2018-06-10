package com.cdkj.loan.enums;

/**
 * 处理结果
 * @author: xieyj 
 * @since: 2018年6月11日 上午2:28:48 
 * @history:
 */
public enum EDealResult {
    GREEN("1", "交保证金进绿名单"), RED("2", "申请拖车进红名单"), YELLOW("3", "代偿进黄名单");

    EDealResult(String code, String value) {
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
