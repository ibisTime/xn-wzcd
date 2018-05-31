package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 资料传递类型
 * @author: silver 
 * @since: 2018年5月30日 下午4:05:14 
 * @history:
 */
public enum ELogisticsType {
    BUDGET("1", "预算单"), GPS("2", "gps");

    public static Map<String, ELogisticsType> getAccountTypeResultMap() {
        Map<String, ELogisticsType> map = new HashMap<String, ELogisticsType>();
        for (ELogisticsType type : ELogisticsType.values()) {
            map.put(type.getCode(), type);
        }
        return map;
    }

    ELogisticsType(String code, String value) {
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
