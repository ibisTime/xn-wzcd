package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class XN632851Req {

    // 编号
    @NotBlank
    private String code;

    // 综合
    private String composite;

    // 素质
    private String quality;

    // 面试记录
    private String interviewRecord;

    // 录用结果
    private String employResult;

    // 试用期
    private String probation;

    // 薪资
    private String employSalary;

    // 入职部门
    private String employDepartmentCode;

    // 入职职务
    private String employPositionCode;

    // 审核人
    private String employApproveUser;

    // 审核结果
    private String employApproveResult;

    // 审核说明
    private String employApproveNote;

    // 考核项目
    @NotEmpty
    private List<XN632851ReqCheckPro> checkProjectList;

    public String getEmployApproveResult() {
        return employApproveResult;
    }

    public void setEmployApproveResult(String employApproveResult) {
        this.employApproveResult = employApproveResult;
    }

    public List<XN632851ReqCheckPro> getCheckProjectList() {
        return checkProjectList;
    }

    public void setCheckProjectList(
            List<XN632851ReqCheckPro> checkProjectList) {
        this.checkProjectList = checkProjectList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComposite() {
        return composite;
    }

    public void setComposite(String composite) {
        this.composite = composite;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getInterviewRecord() {
        return interviewRecord;
    }

    public void setInterviewRecord(String interviewRecord) {
        this.interviewRecord = interviewRecord;
    }

    public String getEmployResult() {
        return employResult;
    }

    public void setEmployResult(String employResult) {
        this.employResult = employResult;
    }

    public String getProbation() {
        return probation;
    }

    public void setProbation(String probation) {
        this.probation = probation;
    }

    public String getEmploySalary() {
        return employSalary;
    }

    public void setEmploySalary(String employSalary) {
        this.employSalary = employSalary;
    }

    public String getEmployDepartmentCode() {
        return employDepartmentCode;
    }

    public void setEmployDepartmentCode(String employDepartmentCode) {
        this.employDepartmentCode = employDepartmentCode;
    }

    public String getEmployPositionCode() {
        return employPositionCode;
    }

    public void setEmployPositionCode(String employPositionCode) {
        this.employPositionCode = employPositionCode;
    }

    public String getEmployApproveUser() {
        return employApproveUser;
    }

    public void setEmployApproveUser(String employApproveUser) {
        this.employApproveUser = employApproveUser;
    }

    public String getEmployApproveNote() {
        return employApproveNote;
    }

    public void setEmployApproveNote(String employApproveNote) {
        this.employApproveNote = employApproveNote;
    }

}
