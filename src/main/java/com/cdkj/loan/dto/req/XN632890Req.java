package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 请假管理
 * @author: silver 
 * @since: 2018年6月5日 下午8:34:17 
 * @history:
 */
public class XN632890Req {
    // 申请人编号
    @NotBlank
    private String applyUser;

    // 请假类别
    @NotBlank
    private String type;

    // 事由
    @NotBlank
    private String reason;

    // 开始时间
    @NotBlank
    private String startDatetime;

    // 结束时间
    @NotBlank
    private String endDatetime;

    // 时长
    @NotBlank
    private String totalHour;

    // 附件
    private String pdf;

    // 更新人
    private String updater;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(String totalHour) {
        this.totalHour = totalHour;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
