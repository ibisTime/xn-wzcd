package com.cdkj.coin.enums;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public enum EAdsPublishType {

    DRAFT("0", "存草稿"),
    PUBLISH("1", "直接发布");

    EAdsPublishType(String code, String value) {
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
