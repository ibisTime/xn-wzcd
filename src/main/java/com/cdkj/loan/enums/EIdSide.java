package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum EIdSide {
    FACE("face", "正面"), BACK("back", "反面");

    EIdSide(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static Map<String, EIdSide> getIdSideMap() {
        Map<String, EIdSide> map = new HashMap<String, EIdSide>();
        for (EIdSide idSide : EIdSide.values()) {
            map.put(idSide.getCode(), idSide);
        }
        return map;
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
