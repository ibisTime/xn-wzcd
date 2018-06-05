package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class XN632860Req {

    // 入职岗位
    @NotBlank
    private String position;

    // 入职时间
    @NotBlank
    private String entryDatetime;

    // 姓名
    @NotBlank
    private String realName;

    // 性别
    @NotBlank
    private String gender;

    // 出生年月
    @NotBlank
    private String birthday;

    // 文化程度
    @NotBlank
    private String education;

    // 民族
    @NotBlank
    private String nation;

    // 籍贯
    @NotBlank
    private String nativePlace;

    // 健康状况
    @NotBlank
    private String health;

    // 婚姻状况
    @NotBlank
    private String marryStatus;

    // 身份证号码
    @NotBlank
    private String idNo;

    // 手机号码
    @NotBlank
    private String mobile;

    // 紧急联系人
    @NotBlank
    private String emergencyContact;

    // 紧急联系号码
    @NotBlank
    private String emergencyContactMobile;

    // 户籍性质
    @NotBlank
    private String residenceProperty;

    // 照片
    private String photo;

    // 户籍所在地
    @NotBlank
    private String residenceAddress;

    // 现居住地址
    @NotBlank
    private String nowAddress;

    // 是否与其他单位存在劳动关系
    @NotBlank
    private String isOtherCompanyRelation;

    // 亲属从事本行姓名
    @NotBlank
    private String relativeName;

    // 亲属与本人关系
    @NotBlank
    private String relativeRelation;

    // 亲属职务
    @NotBlank
    private String relativePosition;

    // 主要业绩及工作能力简述
    private String mainPerform;

    // 试用期期限开始
    private String probationStartDatetime;

    // 试用期期限结束
    private String probationEndDatetime;

    // 试用期工资
    private String probationSalary;

    // 转正后基本工资
    @NotBlank
    private String baseSalary;

    // 转正后绩效工资
    private String performSalary;

    // 绩效工资考核标准
    private String performSalaryStandard;

    // 季度奖考核标准
    private String quarterlyAwardStandard;

    // 通讯费报销标准
    private String communicatePayStandard;

    // 省会住宿报销标准
    private String provincialBedStandard;

    // 非省会住宿报销标准
    private String nonProvincialBedStandard;

    // 市内交通现金补助
    private String trafficStandard;

    // 电话现金补贴
    private String mobileStandard;

    // 出租车
    private String taxiStandard;

    // 餐补
    private String mealStandard;

    // 工资卡账号
    private String salaryCardNo;

    // 开户行
    private String bank;

    // 开户行行号
    private String bankCode;

    // 工作经历列表
    @NotEmpty
    private List<XN632850ReqExp> workExperienceList;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(String entryDatetime) {
        this.entryDatetime = entryDatetime;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
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

    public String getResidenceProperty() {
        return residenceProperty;
    }

    public void setResidenceProperty(String residenceProperty) {
        this.residenceProperty = residenceProperty;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getIsOtherCompanyRelation() {
        return isOtherCompanyRelation;
    }

    public void setIsOtherCompanyRelation(String isOtherCompanyRelation) {
        this.isOtherCompanyRelation = isOtherCompanyRelation;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelativeRelation() {
        return relativeRelation;
    }

    public void setRelativeRelation(String relativeRelation) {
        this.relativeRelation = relativeRelation;
    }

    public String getRelativePosition() {
        return relativePosition;
    }

    public void setRelativePosition(String relativePosition) {
        this.relativePosition = relativePosition;
    }

    public String getMainPerform() {
        return mainPerform;
    }

    public void setMainPerform(String mainPerform) {
        this.mainPerform = mainPerform;
    }

    public String getProbationStartDatetime() {
        return probationStartDatetime;
    }

    public void setProbationStartDatetime(String probationStartDatetime) {
        this.probationStartDatetime = probationStartDatetime;
    }

    public String getProbationEndDatetime() {
        return probationEndDatetime;
    }

    public void setProbationEndDatetime(String probationEndDatetime) {
        this.probationEndDatetime = probationEndDatetime;
    }

    public String getProbationSalary() {
        return probationSalary;
    }

    public void setProbationSalary(String probationSalary) {
        this.probationSalary = probationSalary;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getPerformSalary() {
        return performSalary;
    }

    public void setPerformSalary(String performSalary) {
        this.performSalary = performSalary;
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

    public String getCommunicatePayStandard() {
        return communicatePayStandard;
    }

    public void setCommunicatePayStandard(String communicatePayStandard) {
        this.communicatePayStandard = communicatePayStandard;
    }

    public String getProvincialBedStandard() {
        return provincialBedStandard;
    }

    public void setProvincialBedStandard(String provincialBedStandard) {
        this.provincialBedStandard = provincialBedStandard;
    }

    public String getNonProvincialBedStandard() {
        return nonProvincialBedStandard;
    }

    public void setNonProvincialBedStandard(String nonProvincialBedStandard) {
        this.nonProvincialBedStandard = nonProvincialBedStandard;
    }

    public String getTrafficStandard() {
        return trafficStandard;
    }

    public void setTrafficStandard(String trafficStandard) {
        this.trafficStandard = trafficStandard;
    }

    public String getMobileStandard() {
        return mobileStandard;
    }

    public void setMobileStandard(String mobileStandard) {
        this.mobileStandard = mobileStandard;
    }

    public String getTaxiStandard() {
        return taxiStandard;
    }

    public void setTaxiStandard(String taxiStandard) {
        this.taxiStandard = taxiStandard;
    }

    public String getMealStandard() {
        return mealStandard;
    }

    public void setMealStandard(String mealStandard) {
        this.mealStandard = mealStandard;
    }

    public String getSalaryCardNo() {
        return salaryCardNo;
    }

    public void setSalaryCardNo(String salaryCardNo) {
        this.salaryCardNo = salaryCardNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public List<XN632850ReqExp> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<XN632850ReqExp> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

}
