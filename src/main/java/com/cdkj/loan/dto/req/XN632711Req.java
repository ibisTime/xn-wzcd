package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

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

    // GPS列表
    @NotEmpty
    private List<XN632712ReqGps> gpsList;

    // 申请原因
    private String applyReason;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public List<XN632712ReqGps> getGpsList() {
        return gpsList;
    }

    public void setGpsList(List<XN632712ReqGps> gpsList) {
        this.gpsList = gpsList;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

}
