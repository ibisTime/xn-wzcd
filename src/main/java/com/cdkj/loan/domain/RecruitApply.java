package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 用人申请
* @author: xieyj 
* @since: 2018-06-04 22:50:05
* @history:
*/
public class RecruitApply extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 申请部门编号
    private String departmentCode;

    // 招聘岗位
    private String position;

    // 编制人数
    private int establishQuantity;

    // 部门现有人数
    private int nowQuantity;

    // 申请补充人数
    private int applyQuantity;

    // 申请时间
    private Date applyDatetime;

    // 需要到岗时间
    private Date requireDatetime;

    // 被替代职位
    private String replacePosition;

    // 被替代者姓名
    private String replaceRealName;

    // 被替代原因
    private String newApplyReason;

    // 该职位现有人数
    private Integer positionNowQuantity;

    // 职位增加原因
    private String positionAddReason;

    // 临时聘用时间开始
    private Date tempStartDatetime;

    // 临时聘用时间结束
    private Date tempEndDatetime;

    // 性别
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

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /**-----辅助字段------**/

    private Date applyDatetimeStart;// 申请时间起

    private Date applyDatetimeEnd;// 申请时间止

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public int getEstablishQuantity() {
        return establishQuantity;
    }

    public void setEstablishQuantity(int establishQuantity) {
        this.establishQuantity = establishQuantity;
    }

    public int getNowQuantity() {
        return nowQuantity;
    }

    public void setNowQuantity(int nowQuantity) {
        this.nowQuantity = nowQuantity;
    }

    public int getApplyQuantity() {
        return applyQuantity;
    }

    public void setApplyQuantity(int applyQuantity) {
        this.applyQuantity = applyQuantity;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Date getRequireDatetime() {
        return requireDatetime;
    }

    public void setRequireDatetime(Date requireDatetime) {
        this.requireDatetime = requireDatetime;
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

    public Integer getPositionNowQuantity() {
        return positionNowQuantity;
    }

    public void setPositionNowQuantity(Integer positionNowQuantity) {
        this.positionNowQuantity = positionNowQuantity;
    }

    public String getPositionAddReason() {
        return positionAddReason;
    }

    public void setPositionAddReason(String positionAddReason) {
        this.positionAddReason = positionAddReason;
    }

    public Date getTempStartDatetime() {
        return tempStartDatetime;
    }

    public void setTempStartDatetime(Date tempStartDatetime) {
        this.tempStartDatetime = tempStartDatetime;
    }

    public Date getTempEndDatetime() {
        return tempEndDatetime;
    }

    public void setTempEndDatetime(Date tempEndDatetime) {
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

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
