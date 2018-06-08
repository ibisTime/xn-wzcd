package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 申请应聘
 * @author: xieyj 
 * @since: 2018年6月5日 上午10:01:21 
 * @history:
 */
public class XN632850Req {

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
    private String expectSalary;

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

    // 能否加班
    private String isOverTime;

    // 能否接受工作调动
    private String isAdjustWork;

    // 是否曾在我公司应聘
    private String isOnceRecruited;

    // 是否有亲属或朋友在我司工作
    private String isFriendWork;

    // 更新人
    @NotBlank
    private String updater;

    // 备注
    private String remark;

    // 工作经历列表
    @NotEmpty
    private List<XN632850ReqExp> workExperienceList;

    // 家庭成员列表
    private List<XN632850ReqSocial> socialRelationList;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getIsOverTime() {
        return isOverTime;
    }

    public void setIsOverTime(String isOverTime) {
        this.isOverTime = isOverTime;
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

    public String getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(String expectSalary) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<XN632850ReqExp> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<XN632850ReqExp> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<XN632850ReqSocial> getSocialRelationList() {
        return socialRelationList;
    }

    public void setSocialRelationList(
            List<XN632850ReqSocial> socialRelationList) {
        this.socialRelationList = socialRelationList;
    }
}
