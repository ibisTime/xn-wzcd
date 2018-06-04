package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632480Req {

    // 申请部门编号
    private String departmentCode;

    // 招聘岗位
    @NotBlank
    private String position;

    // 编制人数
    @NotBlank
    private String establishQuantity;

    // 部门现有人数
    @NotBlank
    private String nowQuantity;

    // 申请补充人数
    @NotBlank
    private String applyQuantity;

    // 申请时间
    private String applyDatetime;

    // 需要到岗时间
    @NotBlank
    private String requireDatetime;

    // 被替代职位
    private String replacePosition;

    // 被替代者姓名
    private String replaceRealName;

    // 被替代原因
    private String newApplyReason;

    // 该职位现有人数
    private String positionNowQuantity;

    // 职位增加原因
    private String positionAddReason;

    // 临时聘用时间开始
    private String tempStartDatetime;

    // 临时聘用时间结束
    private String tempEndDatetime;

    // 性别
    @NotBlank
    private String gender;

    // 年龄
    private String age;

    // 婚育情况
    private String marryState;

    // 文化程度
    private String education;

    // 专业
    private String major;

    // 专业资格
    private String majorRequire;

    // 能力要求
    private String abilityRequire;

    // 相关工作经验
    private String experience;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getReplacePosition() {
        return replacePosition;
    }

    public void setReplacePosition(String replacePosition) {
        this.replacePosition = replacePosition;
    }

    public String getReplaceRealName() {
        return replaceRealName;
    }

    public void setReplaceRealName(String replaceRealName) {
        this.replaceRealName = replaceRealName;
    }

    public String getNewApplyReason() {
        return newApplyReason;
    }

    public void setNewApplyReason(String newApplyReason) {
        this.newApplyReason = newApplyReason;
    }

    public String getEstablishQuantity() {
        return establishQuantity;
    }

    public void setEstablishQuantity(String establishQuantity) {
        this.establishQuantity = establishQuantity;
    }

    public String getNowQuantity() {
        return nowQuantity;
    }

    public void setNowQuantity(String nowQuantity) {
        this.nowQuantity = nowQuantity;
    }

    public String getApplyQuantity() {
        return applyQuantity;
    }

    public void setApplyQuantity(String applyQuantity) {
        this.applyQuantity = applyQuantity;
    }

    public String getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(String applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getRequireDatetime() {
        return requireDatetime;
    }

    public void setRequireDatetime(String requireDatetime) {
        this.requireDatetime = requireDatetime;
    }

    public String getPositionNowQuantity() {
        return positionNowQuantity;
    }

    public void setPositionNowQuantity(String positionNowQuantity) {
        this.positionNowQuantity = positionNowQuantity;
    }

    public String getPositionAddReason() {
        return positionAddReason;
    }

    public void setPositionAddReason(String positionAddReason) {
        this.positionAddReason = positionAddReason;
    }

    public String getTempStartDatetime() {
        return tempStartDatetime;
    }

    public void setTempStartDatetime(String tempStartDatetime) {
        this.tempStartDatetime = tempStartDatetime;
    }

    public String getTempEndDatetime() {
        return tempEndDatetime;
    }

    public void setTempEndDatetime(String tempEndDatetime) {
        this.tempEndDatetime = tempEndDatetime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajorRequire() {
        return majorRequire;
    }

    public void setMajorRequire(String majorRequire) {
        this.majorRequire = majorRequire;
    }

    public String getAbilityRequire() {
        return abilityRequire;
    }

    public void setAbilityRequire(String abilityRequire) {
        this.abilityRequire = abilityRequire;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
