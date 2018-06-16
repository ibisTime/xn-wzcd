package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632330Req {
    // 代偿申请编号
    @NotBlank
    private String replaceApplyCode;

    // 业务编号(还款计划)
    @NotBlank
    private String bizCode;

    // 与我司过往是否有纠纷
    private String isPlatIssue;

    // 代偿后采取的方式
    private String takeWay;

    // 暂缓天数
    private String deferDays;

    // 代偿申请原因
    private String applyReason;

    // 代偿申请原因说明
    private String applyReasonNote;

    // 更新人
    @NotBlank
    private String operator;

    public String getReplaceApplyCode() {
        return replaceApplyCode;
    }

    public void setReplaceApplyCode(String replaceApplyCode) {
        this.replaceApplyCode = replaceApplyCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getIsPlatIssue() {
        return isPlatIssue;
    }

    public void setIsPlatIssue(String isPlatIssue) {
        this.isPlatIssue = isPlatIssue;
    }

    public String getTakeWay() {
        return takeWay;
    }

    public void setTakeWay(String takeWay) {
        this.takeWay = takeWay;
    }

    public String getDeferDays() {
        return deferDays;
    }

    public void setDeferDays(String deferDays) {
        this.deferDays = deferDays;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getApplyReasonNote() {
        return applyReasonNote;
    }

    public void setApplyReasonNote(String applyReasonNote) {
        this.applyReasonNote = applyReasonNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
