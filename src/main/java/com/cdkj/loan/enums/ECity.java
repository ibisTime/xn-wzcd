package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

import com.cdkj.loan.exception.BizException;

/**
 * 城市
 * @author: jiafr 
 * @since: 2018年7月20日 上午11:13:46 
 * @history:
 */
public enum ECity {
    WENZHOU("WENZHOU", "温州市");

    public static Map<String, ECity> getAccountTypeResultMap() {
        Map<String, ECity> map = new HashMap<String, ECity>();
        for (ECity type : ECity.values()) {
            map.put(type.getCode(), type);
        }
        return map;
    }

    public static ECity getAccountType(String code) {
        Map<String, ECity> map = getAccountTypeResultMap();
        ECity result = map.get(code);
        if (result == null) {
            throw new BizException("XN0000", code + "对应的accountType不存在");
        }
        return result;
    }

    ECity(String code, String value) {
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
