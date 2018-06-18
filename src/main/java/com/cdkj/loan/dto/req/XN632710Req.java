package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * GPS公司申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:46:36 
 * @history:
 */
public class XN632710Req {

    // 申请公司
    @NotBlank
    private String companyCode;

    // 申请人
    @NotBlank
    private String applyUser;

    // 申请数量
    @NotBlank
    private String applyCount;

    // 申请原因
    private String applyReason;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

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
