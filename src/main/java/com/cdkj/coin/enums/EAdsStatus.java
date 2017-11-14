package com.cdkj.coin.enums;

import com.cdkj.coin.exception.BizException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public enum EAdsStatus {

    DRAFT("0", "草稿"),
    SHANG_JIA("1", "上架"),
    XIA_JIA("2", "下架");

    EAdsStatus(String code, String value) {
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
