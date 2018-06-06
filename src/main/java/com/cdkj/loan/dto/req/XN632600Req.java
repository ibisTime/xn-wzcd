package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 补签
 * @author: silver 
 * @since: 2018年6月6日 下午12:01:42 
 * @history:
 */
public class XN632600Req {
    // 申请人编号
    @NotBlank
    private String applyUser;

    // 事由
    @NotBlank
    private String reason;

    // 更新人
    @NotBlank
    private String updater;

    // 补签明旭
    List<XN632600ReqDetail> detailList;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public List<XN632600ReqDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<XN632600ReqDetail> detailList) {
        this.detailList = detailList;
    }

}
