package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 入职申请
* @author: CYunlai 
* @since: 2018-06-05 17:09:07
* @history:
*/
public class EntryApply extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 入职岗位
    private String position;

    // 入职时间
    private String entryDatetime;

    // 姓名
    private String realName;

    // 性别
    private String gender;

    // 出生年月
    private String birthday;

    // 文化程度
    private String education;

    // 民族
    private String nation;

    // 籍贯
    private String nativePlace;

    // 健康状况
    private String health;

    // 婚姻状况
    private String marryState;

    // 身份证号码
    private String idNo;

    // 手机号码
    private String mobile;

    // 紧急联系人
    private String emergencyContact;

    // 紧急联系号码
    private String emergencyContactMobile;

    // 户籍性质
    private String photo;

    // 照片
    private String residenceAddress;

    // 户籍所在地
    private String nowAddress;

    // 现居住地址
    private String isOtherCompanyRelation;

    // 是否与其他单位存在劳动关系
    private String relativeName;

    // 亲属从事本行姓名
    private String relativeRelation;

    // 亲属与本人关系
    private String relativePosition;

    // 亲属职务
    private String mainPerform;

    // 主要业绩及工作能力简述
    private String probationStartDatetime;

    // 试用期期限开始
    private String probationEndDatetime;

    // 试用期期限结束
    private String probationSalary;

    // 试用期工资
    private String baseSalary;

    // 转正后基本工资
    private String performSalary;

    // 转正后绩效工资
    private String performSalaryStandard;

    // 绩效工资考核标准
    private String quarterlyAwardStandard;

    // 季度奖考核标准
    private String communicatePayStandard;

    // 通讯费报销标准
    private String provincialBedStandard;

    // 省会住宿报销标准
    private String nonProvincialBedStandard;

    // 非省会住宿报销标准
    private String trafficStandard;

    // 市内交通现金补助
    private String mobileStandard;

    // 电话现金补贴
    private String taxiStandard;

    // 出租车
    private String mealStandard;

    // 餐补
    private String salaryCardNo;

    // 工资卡账号
    private String bank;

    // 开户行
    private String bankCode;

    // 开户行行号
    private String status;

    // 状态
    private String updater;

    // 更新人
    private String updateDatetime;

    // 更新时间
    private String remark;

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

    public void setEntryDatetime(String entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public String getEntryDatetime() {
        return entryDatetime;
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

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
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

    public void setMarryState(String marryState) {
        this.marryState = marryState;
    }

    public String getMarryState() {
        return marryState;
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

    public void setProbationStartDatetime(String probationStartDatetime) {
        this.probationStartDatetime = probationStartDatetime;
    }

    public String getProbationStartDatetime() {
        return probationStartDatetime;
    }

    public void setProbationEndDatetime(String probationEndDatetime) {
        this.probationEndDatetime = probationEndDatetime;
    }

    public String getProbationEndDatetime() {
        return probationEndDatetime;
    }

    public void setProbationSalary(String probationSalary) {
        this.probationSalary = probationSalary;
    }

    public String getProbationSalary() {
        return probationSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setPerformSalary(String performSalary) {
        this.performSalary = performSalary;
    }

    public String getPerformSalary() {
        return performSalary;
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

    public void setTrafficStandard(String trafficStandard) {
        this.trafficStandard = trafficStandard;
    }

    public String getTrafficStandard() {
        return trafficStandard;
    }

    public void setMobileStandard(String mobileStandard) {
        this.mobileStandard = mobileStandard;
    }

    public String getMobileStandard() {
        return mobileStandard;
    }

    public void setTaxiStandard(String taxiStandard) {
        this.taxiStandard = taxiStandard;
    }

    public String getTaxiStandard() {
        return taxiStandard;
    }

    public void setMealStandard(String mealStandard) {
        this.mealStandard = mealStandard;
    }

    public String getMealStandard() {
        return mealStandard;
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

    public String getMainPerform() {
        return mainPerform;
    }

    public void setMainPerform(String mainPerform) {
        this.mainPerform = mainPerform;
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

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
