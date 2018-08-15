package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午5:49:31 
 * @history:
 */
public class XN632800Req {

    // 姓名
    @NotBlank
    private String realName;

    // 身份证号码
    @NotBlank
    private String idNo;

    // 手机号码
    @NotBlank
    private String mobile;

    // 工号
    @NotBlank
    private String jobNo;

    // 入职时间
    @NotBlank
    private String entryDatetime;

    // 职务岗位编号
    @NotBlank
    private String postCode;

    // 上班班次
    @NotBlank
    private String jobClasses;

    // 出生年月
    @NotBlank
    private String birthday;

    // 性别
    @NotBlank
    private String gender;

    // 民族
    @NotBlank
    private String nation;

    // 籍贯
    @NotBlank
    private String nativePlace;

    // 婚姻状况
    @NotBlank
    private String marryStatus;

    // 政治面貌
    @NotBlank
    private String politics;

    // 专业
    @NotBlank
    private String major;

    // 学历
    @NotBlank
    private String education;

    // 工作状态
    @NotBlank
    private String workStatus;

    // 健康状况
    @NotBlank
    private String health;

    // 工资卡账号
    private String salaryCard;

    // 银行
    private String bankName;

    // 开户支行
    private String subbranch;

    // 五险一金信息
    private String fiveInsuranceInfo;

    // 户籍地址
    @NotBlank
    private String residenceAddress;

    // 户籍性质
    @NotBlank
    private String residenceProperty;

    // 社保登记日期
    private String socialSecurityRegDatetime;

    // 现住址
    private String currentAddress;

    // 紧急联系人
    private String emergencyContact;

    // 紧急联系号码
    private String emergencyContactMobile;

    // 合同期限
    private String contractDeadline;

    // 合同类型
    private String contractType;

    // 试用期时间
    @NotBlank
    private String probationTime;

    // 转正日期
    private String convertDatetime;

    // 离职日期
    private String leaveDatetime;

    // 门禁号
    private String entranceNo;

    // 考勤号
    private String checkNo;

    // 车牌号
    private String carNo;

    // 身份证复印件
    private String idNoPdf;

    // 照片
    private String photo;

    // 微信
    private String wechat;

    // QQ
    private String qq;

    // 绩效工资考核标准
    private String performSalaryStandard;

    // 季度奖考核标准
    private String quarterlyAwardStandard;

    // 通讯费报销标准
    private String commumicationFeeStandard;

    // 省会住宿报销标准
    private String provincialBedStandard;

    // 非省会住宿报销标准
    private String noProvincialBedStandard;

    // 市内交通现金补助
    private String trafficAward;

    // 电话现金补贴
    private String mobileAward;

    // 出租车
    private String taxiWard;

    // 餐补
    private String mealAward;

    // 更新人
    private String updater;

    // 更新时间
    private String updateDatetime;

    // 社会关系列表
    private List<XN632800ReqChild> socialRelationList;

    public List<XN632800ReqChild> getSocialRelationList() {
        return socialRelationList;
    }

    public void setSocialRelationList(List<XN632800ReqChild> socialRelationList) {
        this.socialRelationList = socialRelationList;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(String entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getJobClasses() {
        return jobClasses;
    }

    public void setJobClasses(String jobClasses) {
        this.jobClasses = jobClasses;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getSalaryCard() {
        return salaryCard;
    }

    public void setSalaryCard(String salaryCard) {
        this.salaryCard = salaryCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getFiveInsuranceInfo() {
        return fiveInsuranceInfo;
    }

    public void setFiveInsuranceInfo(String fiveInsuranceInfo) {
        this.fiveInsuranceInfo = fiveInsuranceInfo;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getResidenceProperty() {
        return residenceProperty;
    }

    public void setResidenceProperty(String residenceProperty) {
        this.residenceProperty = residenceProperty;
    }

    public String getSocialSecurityRegDatetime() {
        return socialSecurityRegDatetime;
    }

    public void setSocialSecurityRegDatetime(String socialSecurityRegDatetime) {
        this.socialSecurityRegDatetime = socialSecurityRegDatetime;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
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

    public String getContractDeadline() {
        return contractDeadline;
    }

    public void setContractDeadline(String contractDeadline) {
        this.contractDeadline = contractDeadline;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getProbationTime() {
        return probationTime;
    }

    public void setProbationTime(String probationTime) {
        this.probationTime = probationTime;
    }

    public String getConvertDatetime() {
        return convertDatetime;
    }

    public void setConvertDatetime(String convertDatetime) {
        this.convertDatetime = convertDatetime;
    }

    public String getLeaveDatetime() {
        return leaveDatetime;
    }

    public void setLeaveDatetime(String leaveDatetime) {
        this.leaveDatetime = leaveDatetime;
    }

    public String getEntranceNo() {
        return entranceNo;
    }

    public void setEntranceNo(String entranceNo) {
        this.entranceNo = entranceNo;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getIdNoPdf() {
        return idNoPdf;
    }

    public void setIdNoPdf(String idNoPdf) {
        this.idNoPdf = idNoPdf;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPerformSalaryStandard() {
        return performSalaryStandard;
    }

    public void setPerformSalaryStandard(String performSalaryStandard) {
        this.performSalaryStandard = performSalaryStandard;
    }

    public String getQuarterlyAwardStandard() {
        return quarterlyAwardStandard;
    }

    public void setQuarterlyAwardStandard(String quarterlyAwardStandard) {
        this.quarterlyAwardStandard = quarterlyAwardStandard;
    }

    public String getCommumicationFeeStandard() {
        return commumicationFeeStandard;
    }

    public void setCommumicationFeeStandard(String commumicationFeeStandard) {
        this.commumicationFeeStandard = commumicationFeeStandard;
    }

    public String getProvincialBedStandard() {
        return provincialBedStandard;
    }

    public void setProvincialBedStandard(String provincialBedStandard) {
        this.provincialBedStandard = provincialBedStandard;
    }

    public String getNoProvincialBedStandard() {
        return noProvincialBedStandard;
    }

    public void setNoProvincialBedStandard(String noProvincialBedStandard) {
        this.noProvincialBedStandard = noProvincialBedStandard;
    }

    public String getTrafficAward() {
        return trafficAward;
    }

    public void setTrafficAward(String trafficAward) {
        this.trafficAward = trafficAward;
    }

    public String getMobileAward() {
        return mobileAward;
    }

    public void setMobileAward(String mobileAward) {
        this.mobileAward = mobileAward;
    }

    public String getTaxiWard() {
        return taxiWard;
    }

    public void setTaxiWard(String taxiWard) {
        this.taxiWard = taxiWard;
    }

    public String getMealAward() {
        return mealAward;
    }

    public void setMealAward(String mealAward) {
        this.mealAward = mealAward;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}
