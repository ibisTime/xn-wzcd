package com.cdkj.loan.enums;


/**
 * 汽车经销商协议状态
 * @author: jiafr 
 * @since: 2018年7月26日 下午8:01:28 
 * @history:
 */
public enum ECarDealerProtocolStatus {

    UP("1", "上架"), DOWN("0", "下架");

    ECarDealerProtocolStatus(String code, String value) {
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
