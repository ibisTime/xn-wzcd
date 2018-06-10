
package com.cdkj.loan.enums;

/**
 * 拖车管理处理结果
 * @author: CYL 
 * @since: 2018年6月10日 下午8:10:05 
 * @history:
 */
public enum EtrailerManageResult {
    USER_REDEEM("0", "待用户赎回"), JUDICIAL_LAWSUIT("1", "司法诉讼");

    EtrailerManageResult(String code, String value) {
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
