package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * GPS个人申领
 * @author: xieyj 
 * @since: 2018年6月18日 下午1:35:40 
 * @history:
 */
public class XN632711Req {
    // 申请人
    @NotBlank
    private String applyUser;

    // 申请数量
    @NotBlank
    private String applyCount;

    // 申请原因
    private String applyReason;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(String applyCount) {
        this.applyCount = applyCount;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

}
