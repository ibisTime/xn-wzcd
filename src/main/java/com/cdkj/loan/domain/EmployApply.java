package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 应聘登记
* @author: xieyj 
* @since: 2018-06-05 00:02:11
* @history:
*/
public class EmployApply extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 真实姓名
    private String realName;

    // 性别
    private String gender;

    // 出生年月
    private String birthday;

    // 籍贯
    private String nativePlace;

    // 民族
    private String nation;

    // 应聘岗位
    private String position;

    // 文化程度
    private String education;

    // 身份证号码
    private String idNo;

    // 联系电话
    private String contactMobile;

    // 户籍所在地
    private String residenceAddress;

    // 特长技能
    private String speciality;

    // 期望薪资
    private Long expectSalary;

    // 现居住地址
    private String nowAddress;

    // 紧急联系人
    private String emergencyContact;

    // 紧急联系号码
    private String emergencyContactMobile;

    // 邮编
    private String postcode;

    // 受过何种奖励或专业训练
    private String award;

    // 能否出差
    private String isOut;

    // 能否接受工作调动
    private String isAdjustWork;

    // 是否曾在我公司应聘
    private String isOnceRecruited;

    // 是否有亲属或朋友在我司工作
    private String isFriendWork;

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
    private Long employSalary;

    // 入职部门
    private String employDepartmentCode;

    // 入职职务
    private String employPositionCode;

    // 审核人
    private String employApproveUser;

    // 审核时间
    private Date employApproveDatetime;

    // 审核说明
    private String employApproveNote;

    // 状态(0=待面试 1=已面试通过 2已面试不通过)
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // **********db properties**********
    // 工作经历
    private List<WorkExperience> workExperienceList;

    // 家庭成员
    private List<SocialRelation> socialRelationList;

    // 考核项目
    private List<CheckProject> checkProjectList;

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<SocialRelation> getSocialRelationList() {
        return socialRelationList;
    }

    public void setSocialRelationList(List<SocialRelation> socialRelationList) {
        this.socialRelationList = socialRelationList;
    }

    public List<CheckProject> getCheckProjectList() {
        return checkProjectList;
    }

    public void setCheckProjectList(List<CheckProject> checkProjectList) {
        this.checkProjectList = checkProjectList;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Long getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(Long expectSalary) {
        this.expectSalary = expectSalary;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactMobile() {
        return emergencyContactMobile;
    }

    public void setEmergencyContactMobile(String emergencyContactMobile) {
        this.emergencyContactMobile = emergencyContactMobile;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getIsOut() {
        return isOut;
    }

    public void setIsOut(String isOut) {
        this.isOut = isOut;
    }

    public String getIsAdjustWork() {
        return isAdjustWork;
    }

    public void setIsAdjustWork(String isAdjustWork) {
        this.isAdjustWork = isAdjustWork;
    }

    public String getIsOnceRecruited() {
        return isOnceRecruited;
    }

    public void setIsOnceRecruited(String isOnceRecruited) {
        this.isOnceRecruited = isOnceRecruited;
    }

    public String getIsFriendWork() {
        return isFriendWork;
    }

    public void setIsFriendWork(String isFriendWork) {
        this.isFriendWork = isFriendWork;
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

    public Long getEmploySalary() {
        return employSalary;
    }

    public void setEmploySalary(Long employSalary) {
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

    public Date getEmployApproveDatetime() {
        return employApproveDatetime;
    }

    public void setEmployApproveDatetime(Date employApproveDatetime) {
        this.employApproveDatetime = employApproveDatetime;
    }

    public String getEmployApproveNote() {
        return employApproveNote;
    }

    public void setEmployApproveNote(String employApproveNote) {
        this.employApproveNote = employApproveNote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
