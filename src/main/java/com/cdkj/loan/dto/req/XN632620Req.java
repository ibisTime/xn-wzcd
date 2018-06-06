package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 新增出差/公出申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午12:43:57 
 * @history:
 */
public class XN632620Req {

    @NotBlank
    private String reason;

    @NotBlank
    private String applyUser;

    @NotBlank
    private String type;

    @NotBlank
    private String updater;

    @NotEmpty
    private List<XN632620ReqChild> detailList;

    public List<XN632620ReqChild> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<XN632620ReqChild> detailList) {
        this.detailList = detailList;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
