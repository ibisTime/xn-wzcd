package com.cdkj.loan.dto.req;

public class XN805081Req {

    // userId（必填）
    private String userId;

    // 昵称（必填）
    private String nickname;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
