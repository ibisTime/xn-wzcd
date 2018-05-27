package com.cdkj.loan.enums;

/**
 * 银行状态
 * @author: silver 
 * @since: 2018年5月27日 下午3:52:23 
 * @history:
 */
public enum EBankStatus {

    Shelf_NO("0", "已下架"), Shelf_YES("1", "已上架");

    EBankStatus(String code, String value) {
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
