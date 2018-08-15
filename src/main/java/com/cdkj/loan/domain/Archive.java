package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 人事档案
 * @author: jiafr 
 * @since: 2018年6月5日 下午1:10:28 
 * @history:
 */
public class Archive extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 姓名
    private String realName;

    // 身份证号码
    private String idNo;

    // 手机号码
    private String mobile;

    // 工号
    private String jobNo;

    // 入职时间
    private Date entryDatetime;

    // 部门编号
    private String departmentCode;

    // 职务岗位编号
    private String postCode;

    // 上班班次
    private String jobClasses;

    // 出生年月
    private Date birthday;

    // 性别
    private String gender;

    // 民族
    private String nation;

    // 籍贯
    private String nativePlace;

    // 婚姻状况
    private String marryStatus;

    // 政治面貌
    private String politics;

    // 专业
    private String major;

    // 学历
    private String education;

    // 工作状态
    private String workStatus;

    // 健康状况
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
    private String residenceAddress;

    // 户籍性质
    private String residenceProperty;

    // 社保登记日期
    private Date socialSecurityRegDatetime;

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
    private String probationTime;

    // 转正日期
    private Date convertDatetime;

    // 离职日期
    private Date leaveDatetime;

    // 离职缘由
    private String leaveReason;

    // 交接人
    private String heirPeople;

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
    private Long trafficAward;

    // 电话现金补贴
    private Long mobileAward;

    // 出租车
    private Long taxiWard;

    // 餐补
    private Long mealAward;

    // 工龄
    private String workingYears;

    // 状态(0删除1正常)
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 用户编号
    private String userId;

    /*************db properties*************/

    // 入职时间起
    private String entryDatetimeStart;

    // 入职时间止
    private String entryDatetimeEnd;

    private List<SocialRelation> socialRelationList;

    // 部门名称
    private String departmentName;

    // 职务岗位名称
    private String postName;

    // 年龄起
    private Integer ageStart;

    // 年龄止
    private Integer ageEnd;

    public Integer getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(Integer ageStart) {
        this.ageStart = ageStart;
    }

    public Integer getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(Integer ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<SocialRelation> getSocialRelationList() {
        return socialRelationList;
    }

    public void setSocialRelationList(List<SocialRelation> socialRelationList) {
        this.socialRelationList = socialRelationList;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
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

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setJobClasses(String jobClasses) {
        this.jobClasses = jobClasses;
    }

    public String getJobClasses() {
        return jobClasses;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
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

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getPolitics() {
        return politics;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    public void setSalaryCard(String salaryCard) {
        this.salaryCard = salaryCard;
    }

    public String getSalaryCard() {
        return salaryCard;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setFiveInsuranceInfo(String fiveInsuranceInfo) {
        this.fiveInsuranceInfo = fiveInsuranceInfo;
    }

    public String getFiveInsuranceInfo() {
        return fiveInsuranceInfo;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceProperty(String residenceProperty) {
        this.residenceProperty = residenceProperty;
    }

    public String getResidenceProperty() {
        return residenceProperty;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getSocialSecurityRegDatetime() {
        return socialSecurityRegDatetime;
    }

    public void setSocialSecurityRegDatetime(Date socialSecurityRegDatetime) {
        this.socialSecurityRegDatetime = socialSecurityRegDatetime;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
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

    public void setContractDeadline(String contractDeadline) {
        this.contractDeadline = contractDeadline;
    }

    public String getContractDeadline() {
        return contractDeadline;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractType() {
        return contractType;
    }

    public void setProbationTime(String probationTime) {
        this.probationTime = probationTime;
    }

    public String getProbationTime() {
        return probationTime;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setHeirPeople(String heirPeople) {
        this.heirPeople = heirPeople;
    }

    public String getHeirPeople() {
        return heirPeople;
    }

    public void setEntranceNo(String entranceNo) {
        this.entranceNo = entranceNo;
    }

    public String getEntranceNo() {
        return entranceNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setIdNoPdf(String idNoPdf) {
        this.idNoPdf = idNoPdf;
    }

    public String getIdNoPdf() {
        return idNoPdf;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getWechat() {
        return wechat;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQq() {
        return qq;
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

    public void setCommumicationFeeStandard(String commumicationFeeStandard) {
        this.commumicationFeeStandard = commumicationFeeStandard;
    }

    public String getCommumicationFeeStandard() {
        return commumicationFeeStandard;
    }

    public void setProvincialBedStandard(String provincialBedStandard) {
        this.provincialBedStandard = provincialBedStandard;
    }

    public String getProvincialBedStandard() {
        return provincialBedStandard;
    }

    public void setNoProvincialBedStandard(String noProvincialBedStandard) {
        this.noProvincialBedStandard = noProvincialBedStandard;
    }

    public String getNoProvincialBedStandard() {
        return noProvincialBedStandard;
    }

    public void setWorkingYears(String workingYears) {
        this.workingYears = workingYears;
    }

    public String getWorkingYears() {
        return workingYears;
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

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public Date getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(Date entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public Date getConvertDatetime() {
        return convertDatetime;
    }

    public void setConvertDatetime(Date convertDatetime) {
        this.convertDatetime = convertDatetime;
    }

    public Date getLeaveDatetime() {
        return leaveDatetime;
    }

    public void setLeaveDatetime(Date leaveDatetime) {
        this.leaveDatetime = leaveDatetime;
    }

    public Long getTrafficAward() {
        return trafficAward;
    }

    public void setTrafficAward(Long trafficAward) {
        this.trafficAward = trafficAward;
    }

    public Long getMobileAward() {
        return mobileAward;
    }

    public void setMobileAward(Long mobileAward) {
        this.mobileAward = mobileAward;
    }

    public Long getTaxiWard() {
        return taxiWard;
    }

    public void setTaxiWard(Long taxiWard) {
        this.taxiWard = taxiWard;
    }

    public Long getMealAward() {
        return mealAward;
    }

    public void setMealAward(Long mealAward) {
        this.mealAward = mealAward;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getEntryDatetimeStart() {
        return entryDatetimeStart;
    }

    public void setEntryDatetimeStart(String entryDatetimeStart) {
        this.entryDatetimeStart = entryDatetimeStart;
    }

    public String getEntryDatetimeEnd() {
        return entryDatetimeEnd;
    }

    public void setEntryDatetimeEnd(String entryDatetimeEnd) {
        this.entryDatetimeEnd = entryDatetimeEnd;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

}
