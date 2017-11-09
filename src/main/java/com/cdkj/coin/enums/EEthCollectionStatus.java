package com.cdkj.coin.enums;

public enum EEthCollectionStatus {
    Broadcast("0", "广播中"), Broadcast_YES("1", "广播成功"), Broadcast_NO("1", "广播失败");

    EEthCollectionStatus(String code, String value) {
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
