package com.cdkj.loan.enums;

/**
 * 请假状态
 * @author: silver 
 * @since: 2018年6月5日 下午8:41:15 
 * @history:
 */
public enum ELeaveApplyType {
    SHIJIA("1", "事假"), TIAOXIU("2", "调休"), NIANXIUJIA("3", "年休假"), 
    BINJIA("4", "病假"), HUNJIA("5", "婚假"), SANGJIA("6", "丧假"), 
    CHANJIA("7", "产假"), PEICHANJIA("8", "陪产假"), CHANJIANJIA("9", "产检假"), 
    TANQINJIA("10", "探亲假"), GONGJIA("11", "公假"),
    GONGSANGJIA("12", "工伤假"), OTHER("13", "其他");

    ELeaveApplyType(String code, String value) {
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
