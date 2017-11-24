package com.cdkj.coin.dto.req;

public class XN805081Req {

    // userId（必填）
    private String userId;

    // 邮箱（必填）
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
