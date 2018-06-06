package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632650Req {

    // 申请人
    @NotBlank
    private String applyUser;

    // 请示领导
    @NotBlank
    private String leadUserId;

    // 请示内容
    @NotBlank
    private String content;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getLeadUserId() {
        return leadUserId;
    }

    public void setLeadUserId(String leadUserId) {
        this.leadUserId = leadUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
