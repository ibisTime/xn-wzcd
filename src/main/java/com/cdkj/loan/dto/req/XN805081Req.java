package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN805081Req {

    // userId（必填）
    @NotBlank
    private String userId;

    // 昵称（必填）
    @NotBlank
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
