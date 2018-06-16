package com.cdkj.loan.enums;

/**
 * 返点明细节点
 * @author: jiafr 
 * @since: 2018年6月16日 下午10:32:31 
 * @history:
 */
public enum ERepointDetailStatus {

    TODO_MAKE_BILL("0", "待制单"), TODO_PAY("1", "已制单待打款"), HANDLED("2", "已打款");

    ERepointDetailStatus(String code, String value) {
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
