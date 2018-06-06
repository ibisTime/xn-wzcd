package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class XN632870Req {

    // 入职编号
    @NotBlank
    private String entryCode;

    // 申请人
    @NotBlank
    private String applyUser;

    // 工作总结
    private String workSummary;

    // 总体评价
    private String allEvaluation;

    // 是否转正
    @NotBlank
    private String isFullWorker;

    // 生效日期
    @NotBlank
    private String effectDatetime;

    // 备注
    private String remark;

    // 试用期评估列表
    @NotEmpty
    private List<XN632870ReqProbationAssess> probationAssessList;

    public List<XN632870ReqProbationAssess> getProbationAssessList() {
        return probationAssessList;
    }

    public void setProbationAssessList(
            List<XN632870ReqProbationAssess> probationAssessList) {
        this.probationAssessList = probationAssessList;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public String getWorkSummary() {
        return workSummary;
    }

    public void setWorkSummary(String workSummary) {
        this.workSummary = workSummary;
    }

    public String getAllEvaluation() {
        return allEvaluation;
    }

    public void setAllEvaluation(String allEvaluation) {
        this.allEvaluation = allEvaluation;
    }

    public String getIsFullWorker() {
        return isFullWorker;
    }

    public void setIsFullWorker(String isFullWorker) {
        this.isFullWorker = isFullWorker;
    }

    public String getEffectDatetime() {
        return effectDatetime;
    }

    public void setEffectDatetime(String effectDatetime) {
        this.effectDatetime = effectDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
