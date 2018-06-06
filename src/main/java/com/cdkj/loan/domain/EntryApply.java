package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 入职申请
* @author: CYunlai 
* @since: 2018-06-05 17:42:15
* @history:
*/
public class EntryApply extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 539588895789973725L;

    // 编号
    private String code;

    // 入职岗位
    private String position;

    // 入职时间
    private Date entryDatetime;

    // 姓名
    private String realName;

    // 性别
    private String gender;

    // 出生年月
    private Date birthday;

    // 文化程度
    private String education;

    // 民族
    private String nation;

    // 籍贯
    private String nativePlace;

    // 健康状况
    private String health;

    // 婚姻状况
    private String marryStatus;

    // 身份证号码
    private String idNo;

    // 手机号码
    private String mobile;

    // 紧急联系人
    private String emergencyContact;

    // 紧急联系号码
    private String emergencyContactMobile;

    // 户籍性质
    private String residenceProperty;

    // 照片
    private String photo;

    // 户籍所在地
    private String residenceAddress;

    // 现居住地址
    private String nowAddress;

    // 是否与其他单位存在劳动关系
    private String isOtherCompanyRelation;

    // 亲属从事本行姓名
    private String relativeName;

    // 亲属与本人关系
    private String relativeRelation;

    // 亲属职务
    private String relativePosition;

    // 主要业绩及工作能力简述
    private String mainPerform;

    // 试用期期限开始
    private Date probationStartDatetime;

    // 试用期期限结束
    private Date probationEndDatetime;

    // 试用期工资
    private Long probationSalary;

    // 转正后基本工资
    private Long baseSalary;

    // 转正后绩效工资
    private Long performSalary;

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
    private Long trafficStandard;

    // 电话现金补贴
    private Long mobileStandard;

    // 出租车
    private Long taxiStandard;

    // 餐补
    private Long mealStandard;

    // 工资卡账号
    private String salaryCardNo;

    // 开户行
    private String bank;

    // 开户行行号
    private String bankCode;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 工作经历
    private List<WorkExperience> workExperienceList;

    // 入职时间起
    private Date entryDatetimeStart;

    // 入职时间止
    private Date entryDatetimeEnd;

    public Date getEntryDatetimeStart() {
        return entryDatetimeStart;
    }

    public void setEntryDatetimeStart(Date entryDatetimeStart) {
        this.entryDatetimeStart = entryDatetimeStart;
    }

    public Date getEntryDatetimeEnd() {
        return entryDatetimeEnd;
    }

    public void setEntryDatetimeEnd(Date entryDatetimeEnd) {
        this.entryDatetimeEnd = entryDatetimeEnd;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContactMobile(String emergencyContactMobile) {
        this.emergencyContactMobile = emergencyContactMobile;
    }

    public String getEmergencyContactMobile() {
        return emergencyContactMobile;
    }

    public void setResidenceProperty(String residenceProperty) {
        this.residenceProperty = residenceProperty;
    }

    public String getResidenceProperty() {
        return residenceProperty;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setIsOtherCompanyRelation(String isOtherCompanyRelation) {
        this.isOtherCompanyRelation = isOtherCompanyRelation;
    }

    public String getIsOtherCompanyRelation() {
        return isOtherCompanyRelation;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeRelation(String relativeRelation) {
        this.relativeRelation = relativeRelation;
    }

    public String getRelativeRelation() {
        return relativeRelation;
    }

    public void setRelativePosition(String relativePosition) {
        this.relativePosition = relativePosition;
    }

    public String getRelativePosition() {
        return relativePosition;
    }

    public void setPerformSalaryStandard(String performSalaryStandard) {
        this.performSalaryStandard = performSalaryStandard;
    }

    public String getPerformSalaryStandard() {
        return performSalaryStandard;
    }

    public void setQuarterlyAwardStandard(String quarterlyAwardStandard) {
        this.quarterlyAwardStandard = quarterlyAwardStandard;
    }

    public String getQuarterlyAwardStandard() {
        return quarterlyAwardStandard;
    }

    public void setCommunicatePayStandard(String communicatePayStandard) {
        this.communicatePayStandard = communicatePayStandard;
    }

    public String getCommunicatePayStandard() {
        return communicatePayStandard;
    }

    public void setProvincialBedStandard(String provincialBedStandard) {
        this.provincialBedStandard = provincialBedStandard;
    }

    public String getProvincialBedStandard() {
        return provincialBedStandard;
    }

    public void setNonProvincialBedStandard(String nonProvincialBedStandard) {
        this.nonProvincialBedStandard = nonProvincialBedStandard;
    }

    public String getNonProvincialBedStandard() {
        return nonProvincialBedStandard;
    }

    public void setSalaryCardNo(String salaryCardNo) {
        this.salaryCardNo = salaryCardNo;
    }

    public String getSalaryCardNo() {
        return salaryCardNo;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public Date getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(Date entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMainPerform() {
        return mainPerform;
    }

    public void setMainPerform(String mainPerform) {
        this.mainPerform = mainPerform;
    }

    public Date getProbationStartDatetime() {
        return probationStartDatetime;
    }

    public void setProbationStartDatetime(Date probationStartDatetime) {
        this.probationStartDatetime = probationStartDatetime;
    }

    public Date getProbationEndDatetime() {
        return probationEndDatetime;
    }

    public void setProbationEndDatetime(Date probationEndDatetime) {
        this.probationEndDatetime = probationEndDatetime;
    }

    public Long getProbationSalary() {
        return probationSalary;
    }

    public void setProbationSalary(Long probationSalary) {
        this.probationSalary = probationSalary;
    }

    public Long getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Long baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Long getPerformSalary() {
        return performSalary;
    }

    public void setPerformSalary(Long performSalary) {
        this.performSalary = performSalary;
    }

    public Long getTrafficStandard() {
        return trafficStandard;
    }

    public void setTrafficStandard(Long trafficStandard) {
        this.trafficStandard = trafficStandard;
    }

    public Long getMobileStandard() {
        return mobileStandard;
    }

    public void setMobileStandard(Long mobileStandard) {
        this.mobileStandard = mobileStandard;
    }

    public Long getTaxiStandard() {
        return taxiStandard;
    }

    public void setTaxiStandard(Long taxiStandard) {
        this.taxiStandard = taxiStandard;
    }

    public Long getMealStandard() {
        return mealStandard;
    }

    public void setMealStandard(Long mealStandard) {
        this.mealStandard = mealStandard;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
