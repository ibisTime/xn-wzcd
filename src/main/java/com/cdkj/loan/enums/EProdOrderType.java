package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 产品订单类型
 * @author: xieyj 
 * @since: 2017年2月9日 下午8:10:43 
 * @history:
 */
public enum EProdOrderType {
    PROD("1", "产品"), ACT_PROD("2", "活动产品"), RENT_PROD("3", "租赁产品");

    public static Map<String, EProdOrderType> getMap() {
        Map<String, EProdOrderType> map = new HashMap<String, EProdOrderType>();
        for (EProdOrderType direction : EProdOrderType.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    EProdOrderType(String code, String value) {
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
