package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632120Req {

    // 操作人
    @NotBlank
    private String operator;

    // 处理类型(0 保存 1 发送)
    @NotBlank
    private String dealType;

    // 贷款产品编号
    @NotBlank
    private String loanProductCode;

    // 是否垫资
    @NotBlank
    private String isAdvanceFund;

    // 征信单编号
    @NotBlank
    private String creditCode;

    // 业务种类
    @NotBlank
    private String bizType;

    // 贷款期限
    @NotBlank
    private String loanPeriod;

    // 开票单位
    @NotBlank
    private String invoiceCompany;

    // 品牌
    @NotBlank
    private String carBrand;

    // 车系
    @NotBlank
    private String carSeries;

    // 车型
    @NotBlank
    private String carModel;

    // 车辆照片
    @NotBlank
    private String carPic;

    // 合格证
    @NotBlank
    private String carHgzPic;

    // 合格证号
    @NotBlank
    private String carHgzNo;

    // 车架号
    @NotBlank
    private String carFrameNo;

    // 发动机号
    @NotBlank
    private String carEngineNo;

    // 市场指导价
    @NotBlank
    private String originalPrice;

    // 开票价
    @NotBlank
    private String invoicePrice;

    // 颜色
    @NotBlank
    private String carColor;

    // 月供保证金
    @NotBlank
    private String monthDeposit;

    // 首付金额
    @NotBlank
    private String firstAmount;

    // 首付比例
    @NotBlank
    private String firstRate;

    // 贷款额
    @NotBlank
    private String loanAmount;

    // 落户地点
    @NotBlank
    private String settleAddress;

    // 申请人姓名
    @NotBlank
    private String applyUserName;

    // 性别
    @NotBlank
    private String gender;

    // 婚姻状况
    @NotBlank
    private String marryState;

    // 民族
    @NotBlank
    private String nation;

    // 学历
    @NotBlank
    private String education;

    // 身份证号
    @NotBlank
    private String idNo;

    // 家庭人口
    @NotBlank
    private String familyNumber;

    // 手机号
    @NotBlank
    private String mobile;

    // 现居住地址
    @NotBlank
    private String nowAddress;

    // 邮编1
    @NotBlank
    private String postCode1;

    // 户口所在地
    @NotBlank
    private String residenceAddress;

    // 邮编2
    @NotBlank
    private String postCode2;

    // 家庭主要财产
    @NotBlank
    private String familyMainAsset;

    // 主要财产包括
    @NotBlank
    private String mainAssetInclude;

    // 主要收入来源
    @NotBlank
    private String mainIncome;

    // 工作单位名称
    @NotBlank
    private String workCompanyName;

    // 工作单位地址
    @NotBlank
    private String workCompanyAddress;

    // 单位性质
    private String workCompanyProperty;

    // 所属行业
    private String workBelongIndustry;

    // 职业
    private String workProfession;

    // 何时进入现单位工作
    private String workDatetime;

    // 自营公司单位面积
    private String selfCompanyArea;

    // 员工数量
    private String employeeQuantity;

    // 企业月产值
    private String enterpriseMonthOutput;

    // 职位
    private String position;

    // 职称
    private String postTitle;

    // 月收入
    private String monthIncome;

    // 配偶姓名
    private String mateName;

    // 配偶手机号
    private String mateMobile;

    // 配偶身份证号
    private String mateIdNo;

    // 配偶学历
    private String mateEducation;

    // 配偶工作单位名称
    private String mateCompanyName;

    // 配偶工作单位地址
    private String mateCompanyAddress;

    // 配偶工作单位联系电话
    private String mateCompanyContactNo;

    // 配偶支付宝流水时间起
    private String mateZfbJourDatetimeStart;

    // 配偶支付宝流水时间止
    private String mateZfbJourDatetimeEnd;

    // 配偶支付宝收入
    private String mateZfbJourIncome;

    // 配偶支付宝支出
    private String mateZfbJourExpend;

    // 配偶支付宝帐户余额
    private String mateZfbJourBalance;

    // 配偶支付宝月均收入
    private String mateZfbJourMonthIncome;

    // 配偶支付宝月均支出
    private String mateZfbJourMonthExpend;

    // 配偶支付宝流水图片
    private String mateZfbJourPic;

    // 配偶支付宝流水备注
    private String mateZfbJourRemark;

    // 配偶微信流水时间起
    private String mateWxJourDatetimeStart;

    // 配偶微信流水时间止
    private String mateWxJourDatetimeEnd;

    // 配偶微信收入
    private String mateWxJourIncome;

    // 配偶微信支出
    private String mateWxJourExpend;

    // 配偶微信帐户余额
    private String mateWxJourBalance;

    // 配偶微信月均收入
    private String mateWxJourMonthIncome;

    // 配偶微信月均支出
    private String mateWxJourMonthExpend;

    // 配偶微信流水图片
    private String mateWxJourPic;

    // 配偶微信流水备注
    private String mateWxJourRemark;

    // 配偶流水时间起
    private String mateJourDatetimeStart;

    // 配偶流水时间止
    private String mateJourDatetimeEnd;

    // 配偶收入
    private String mateJourIncome;

    // 配偶支出
    private String mateJourExpend;

    // 配偶帐户余额
    private String mateJourBalance;

    // 配偶月均收入
    private String mateJourMonthIncome;

    // 配偶月均支出
    private String mateJourMonthExpend;

    // 配偶流水图片
    private String mateJourPic;

    // 配偶流水备注
    private String mateJourRemark;

    // 配偶资产资料pdf
    private String mateAssetPdf;

    // 担保人姓名
    private String guaName;

    // 担保人手机号
    private String guaMobile;

    // 担保人身份证号
    private String guaIdNo;

    // 担保人固定电话
    private String guaPhone;

    // 担保人工作单位名称
    private String guaCompanyName;

    // 担保人工作单位地址
    private String guaCompanyAddress;

    // 担保人房产地址
    private String guaHouseAssetAddress;

    // 担保人支付宝流水时间起
    private String guaZfbJourDatetimeStart;

    // 担保人支付宝流水时间止
    private String guaZfbJourDatetimeEnd;

    // 担保人支付宝收入
    private String guaZfbJourIncome;

    // 担保人支付宝支出
    private String guaZfbJourExpend;

    // 担保人支付宝帐户余额
    private String guaZfbJourBalance;

    // 担保人支付宝月均收入
    private String guaZfbJourMonthIncome;

    // 担保人支付宝月均支出
    private String guaZfbJourMonthExpend;

    // 担保人支付宝流水图片
    private String guaZfbJourPic;

    // 担保人支付宝流水备注
    private String guaZfbJourRemark;

    // 担保人微信流水时间起
    private String guaWxJourDatetimeStart;

    // 担保人微信流水时间止
    private String guaWxJourDatetimeEnd;

    // 担保人微信收入
    private String guaWxJourIncome;

    // 担保人微信支出
    private String guaWxJourExpend;

    // 担保人微信帐户余额
    private String guaWxJourBalance;

    // 担保人微信月均收入
    private String guaWxJourMonthIncome;

    // 担保人微信月均支出
    private String guaWxJourMonthExpend;

    // 担保人微信流水图片
    private String guaWxJourPic;

    // 担保人微信流水备注
    private String guaWxJourRemark;

    // 担保人流水时间起
    private String guaJourDatetimeStart;

    // 担保人流水时间止
    private String guaJourDatetimeEnd;

    // 担保人收入
    private String guaJourIncome;

    // 担保人支出
    private String guaJourExpend;

    // 担保人帐户余额
    private String guaJourBalance;

    // 担保人月均收入
    private String guaJourMonthIncome;

    // 担保人月均支出
    private String guaJourMonthExpend;

    // 担保人流水图片
    private String guaJourPic;

    // 担保人流水备注
    private String guaJourRemark;

    // 担保人资产资料pdf
    private String guaAssetPdf;

    // 家庭紧急联系人信息1 姓名
    private String emergencyName1;

    // 家庭紧急联系人信息1 与申请人关系
    private String emergencyRelation1;

    // 家庭紧急联系人信息1 手机号码
    private String emergencyMobile1;

    // 家庭紧急联系人信息2 姓名
    private String emergencyName2;

    // 家庭紧急联系人信息2 与申请人关系
    private String emergencyRelation2;

    // 家庭紧急联系人信息2 手机号码
    private String emergencyMobile2;

    // 支付宝流水时间起
    private String zfbJourDatetimeStart;

    // 支付宝流水时间止
    private String zfbJourDatetimeEnd;

    // 支付宝收入
    private String zfbJourIncome;

    // 支付宝支出
    private String zfbJourExpend;

    // 支付宝帐户余额
    private String zfbJourBalance;

    // 支付宝月均收入
    private String zfbJourMonthIncome;

    // 支付宝月均支出
    private String zfbJourMonthExpend;

    // 支付宝流水图片
    private String zfbJourPic;

    // 支付宝流水备注
    private String zfbJourRemark;

    // 微信流水时间起
    private String wxJourDatetimeStart;

    // 微信流水时间止
    private String wxJourDatetimeEnd;

    // 微信收入
    private String wxJourIncome;

    // 微信支出
    private String wxJourExpend;

    // 微信帐户余额
    private String wxJourBalance;

    // 微信月均收入
    private String wxJourMonthIncome;

    // 微信月均支出
    private String wxJourMonthExpend;

    // 微信流水图片
    private String wxJourPic;

    // 微信流水备注
    private String wxJourRemark;

    // 流水时间起
    private String jourDatetimeStart;

    // 流水时间止
    private String jourDatetimeEnd;

    // 收入
    private String jourIncome;

    // 支出
    private String jourExpend;

    // 帐户余额
    private String jourBalance;

    // 月均收入
    private String jourMonthIncome;

    // 月均支出
    private String jourMonthExpend;

    // 流水图片
    private String jourPic;

    // 流水备注
    private String jourRemark;

    // 资产资料pdf
    private String assetPdf;

    // 购房合同
    private String houseContract;

    // 房屋照片
    private String housePicture;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getLoanProductCode() {
        return loanProductCode;
    }

    public void setLoanProductCode(String loanProductCode) {
        this.loanProductCode = loanProductCode;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getMonthDeposit() {
        return monthDeposit;
    }

    public void setMonthDeposit(String monthDeposit) {
        this.monthDeposit = monthDeposit;
    }

    public String getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(String firstAmount) {
        this.firstAmount = firstAmount;
    }

    public String getFirstRate() {
        return firstRate;
    }

    public void setFirstRate(String firstRate) {
        this.firstRate = firstRate;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getSettleAddress() {
        return settleAddress;
    }

    public void setSettleAddress(String settleAddress) {
        this.settleAddress = settleAddress;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

    public String getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(String familyNumber) {
        this.familyNumber = familyNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getPostCode1() {
        return postCode1;
    }

    public void setPostCode1(String postCode1) {
        this.postCode1 = postCode1;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getPostCode2() {
        return postCode2;
    }

    public void setPostCode2(String postCode2) {
        this.postCode2 = postCode2;
    }

    public String getFamilyMainAsset() {
        return familyMainAsset;
    }

    public void setFamilyMainAsset(String familyMainAsset) {
        this.familyMainAsset = familyMainAsset;
    }

    public String getMainAssetInclude() {
        return mainAssetInclude;
    }

    public void setMainAssetInclude(String mainAssetInclude) {
        this.mainAssetInclude = mainAssetInclude;
    }

    public String getMainIncome() {
        return mainIncome;
    }

    public void setMainIncome(String mainIncome) {
        this.mainIncome = mainIncome;
    }

    public String getWorkCompanyName() {
        return workCompanyName;
    }

    public void setWorkCompanyName(String workCompanyName) {
        this.workCompanyName = workCompanyName;
    }

    public String getWorkCompanyAddress() {
        return workCompanyAddress;
    }

    public void setWorkCompanyAddress(String workCompanyAddress) {
        this.workCompanyAddress = workCompanyAddress;
    }

    public String getSelfCompanyArea() {
        return selfCompanyArea;
    }

    public void setSelfCompanyArea(String selfCompanyArea) {
        this.selfCompanyArea = selfCompanyArea;
    }

    public String getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(String employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public String getEnterpriseMonthOutput() {
        return enterpriseMonthOutput;
    }

    public void setEnterpriseMonthOutput(String enterpriseMonthOutput) {
        this.enterpriseMonthOutput = enterpriseMonthOutput;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMateMobile() {
        return mateMobile;
    }

    public void setMateMobile(String mateMobile) {
        this.mateMobile = mateMobile;
    }

    public String getMateIdNo() {
        return mateIdNo;
    }

    public void setMateIdNo(String mateIdNo) {
        this.mateIdNo = mateIdNo;
    }

    public String getMateEducation() {
        return mateEducation;
    }

    public void setMateEducation(String mateEducation) {
        this.mateEducation = mateEducation;
    }

    public String getMateCompanyName() {
        return mateCompanyName;
    }

    public void setMateCompanyName(String mateCompanyName) {
        this.mateCompanyName = mateCompanyName;
    }

    public String getMateCompanyAddress() {
        return mateCompanyAddress;
    }

    public void setMateCompanyAddress(String mateCompanyAddress) {
        this.mateCompanyAddress = mateCompanyAddress;
    }

    public String getMateCompanyContactNo() {
        return mateCompanyContactNo;
    }

    public void setMateCompanyContactNo(String mateCompanyContactNo) {
        this.mateCompanyContactNo = mateCompanyContactNo;
    }

    public String getGuaName() {
        return guaName;
    }

    public void setGuaName(String guaName) {
        this.guaName = guaName;
    }

    public String getGuaMobile() {
        return guaMobile;
    }

    public void setGuaMobile(String guaMobile) {
        this.guaMobile = guaMobile;
    }

    public String getGuaIdNo() {
        return guaIdNo;
    }

    public void setGuaIdNo(String guaIdNo) {
        this.guaIdNo = guaIdNo;
    }

    public String getGuaPhone() {
        return guaPhone;
    }

    public void setGuaPhone(String guaPhone) {
        this.guaPhone = guaPhone;
    }

    public String getGuaCompanyName() {
        return guaCompanyName;
    }

    public void setGuaCompanyName(String guaCompanyName) {
        this.guaCompanyName = guaCompanyName;
    }

    public String getGuaCompanyAddress() {
        return guaCompanyAddress;
    }

    public void setGuaCompanyAddress(String guaCompanyAddress) {
        this.guaCompanyAddress = guaCompanyAddress;
    }

    public String getGuaHouseAssetAddress() {
        return guaHouseAssetAddress;
    }

    public void setGuaHouseAssetAddress(String guaHouseAssetAddress) {
        this.guaHouseAssetAddress = guaHouseAssetAddress;
    }

    public String getEmergencyName1() {
        return emergencyName1;
    }

    public void setEmergencyName1(String emergencyName1) {
        this.emergencyName1 = emergencyName1;
    }

    public String getEmergencyRelation1() {
        return emergencyRelation1;
    }

    public void setEmergencyRelation1(String emergencyRelation1) {
        this.emergencyRelation1 = emergencyRelation1;
    }

    public String getEmergencyMobile1() {
        return emergencyMobile1;
    }

    public void setEmergencyMobile1(String emergencyMobile1) {
        this.emergencyMobile1 = emergencyMobile1;
    }

    public String getEmergencyName2() {
        return emergencyName2;
    }

    public void setEmergencyName2(String emergencyName2) {
        this.emergencyName2 = emergencyName2;
    }

    public String getEmergencyRelation2() {
        return emergencyRelation2;
    }

    public void setEmergencyRelation2(String emergencyRelation2) {
        this.emergencyRelation2 = emergencyRelation2;
    }

    public String getEmergencyMobile2() {
        return emergencyMobile2;
    }

    public void setEmergencyMobile2(String emergencyMobile2) {
        this.emergencyMobile2 = emergencyMobile2;
    }

    public String getJourDatetimeStart() {
        return jourDatetimeStart;
    }

    public void setJourDatetimeStart(String jourDatetimeStart) {
        this.jourDatetimeStart = jourDatetimeStart;
    }

    public String getJourDatetimeEnd() {
        return jourDatetimeEnd;
    }

    public void setJourDatetimeEnd(String jourDatetimeEnd) {
        this.jourDatetimeEnd = jourDatetimeEnd;
    }

    public String getJourIncome() {
        return jourIncome;
    }

    public void setJourIncome(String jourIncome) {
        this.jourIncome = jourIncome;
    }

    public String getJourExpend() {
        return jourExpend;
    }

    public void setJourExpend(String jourExpend) {
        this.jourExpend = jourExpend;
    }

    public String getJourBalance() {
        return jourBalance;
    }

    public void setJourBalance(String jourBalance) {
        this.jourBalance = jourBalance;
    }

    public String getJourMonthIncome() {
        return jourMonthIncome;
    }

    public void setJourMonthIncome(String jourMonthIncome) {
        this.jourMonthIncome = jourMonthIncome;
    }

    public String getJourMonthExpend() {
        return jourMonthExpend;
    }

    public void setJourMonthExpend(String jourMonthExpend) {
        this.jourMonthExpend = jourMonthExpend;
    }

    public String getJourRemark() {
        return jourRemark;
    }

    public void setJourRemark(String jourRemark) {
        this.jourRemark = jourRemark;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getCarHgzPic() {
        return carHgzPic;
    }

    public void setCarHgzPic(String carHgzPic) {
        this.carHgzPic = carHgzPic;
    }

    public String getCarHgzNo() {
        return carHgzNo;
    }

    public void setCarHgzNo(String carHgzNo) {
        this.carHgzNo = carHgzNo;
    }

    public String getCarFrameNo() {
        return carFrameNo;
    }

    public void setCarFrameNo(String carFrameNo) {
        this.carFrameNo = carFrameNo;
    }

    public String getCarEngineNo() {
        return carEngineNo;
    }

    public void setCarEngineNo(String carEngineNo) {
        this.carEngineNo = carEngineNo;
    }

    public String getHouseContract() {
        return houseContract;
    }

    public void setHouseContract(String houseContract) {
        this.houseContract = houseContract;
    }

    public String getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(String housePicture) {
        this.housePicture = housePicture;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getMateZfbJourDatetimeStart() {
        return mateZfbJourDatetimeStart;
    }

    public void setMateZfbJourDatetimeStart(String mateZfbJourDatetimeStart) {
        this.mateZfbJourDatetimeStart = mateZfbJourDatetimeStart;
    }

    public String getMateZfbJourDatetimeEnd() {
        return mateZfbJourDatetimeEnd;
    }

    public void setMateZfbJourDatetimeEnd(String mateZfbJourDatetimeEnd) {
        this.mateZfbJourDatetimeEnd = mateZfbJourDatetimeEnd;
    }

    public String getMateZfbJourIncome() {
        return mateZfbJourIncome;
    }

    public void setMateZfbJourIncome(String mateZfbJourIncome) {
        this.mateZfbJourIncome = mateZfbJourIncome;
    }

    public String getMateZfbJourExpend() {
        return mateZfbJourExpend;
    }

    public void setMateZfbJourExpend(String mateZfbJourExpend) {
        this.mateZfbJourExpend = mateZfbJourExpend;
    }

    public String getMateZfbJourBalance() {
        return mateZfbJourBalance;
    }

    public void setMateZfbJourBalance(String mateZfbJourBalance) {
        this.mateZfbJourBalance = mateZfbJourBalance;
    }

    public String getMateZfbJourMonthIncome() {
        return mateZfbJourMonthIncome;
    }

    public void setMateZfbJourMonthIncome(String mateZfbJourMonthIncome) {
        this.mateZfbJourMonthIncome = mateZfbJourMonthIncome;
    }

    public String getMateZfbJourMonthExpend() {
        return mateZfbJourMonthExpend;
    }

    public void setMateZfbJourMonthExpend(String mateZfbJourMonthExpend) {
        this.mateZfbJourMonthExpend = mateZfbJourMonthExpend;
    }

    public String getMateZfbJourPic() {
        return mateZfbJourPic;
    }

    public void setMateZfbJourPic(String mateZfbJourPic) {
        this.mateZfbJourPic = mateZfbJourPic;
    }

    public String getMateZfbJourRemark() {
        return mateZfbJourRemark;
    }

    public void setMateZfbJourRemark(String mateZfbJourRemark) {
        this.mateZfbJourRemark = mateZfbJourRemark;
    }

    public String getMateWxJourDatetimeStart() {
        return mateWxJourDatetimeStart;
    }

    public void setMateWxJourDatetimeStart(String mateWxJourDatetimeStart) {
        this.mateWxJourDatetimeStart = mateWxJourDatetimeStart;
    }

    public String getMateWxJourDatetimeEnd() {
        return mateWxJourDatetimeEnd;
    }

    public void setMateWxJourDatetimeEnd(String mateWxJourDatetimeEnd) {
        this.mateWxJourDatetimeEnd = mateWxJourDatetimeEnd;
    }

    public String getMateWxJourIncome() {
        return mateWxJourIncome;
    }

    public void setMateWxJourIncome(String mateWxJourIncome) {
        this.mateWxJourIncome = mateWxJourIncome;
    }

    public String getMateWxJourExpend() {
        return mateWxJourExpend;
    }

    public void setMateWxJourExpend(String mateWxJourExpend) {
        this.mateWxJourExpend = mateWxJourExpend;
    }

    public String getMateWxJourBalance() {
        return mateWxJourBalance;
    }

    public void setMateWxJourBalance(String mateWxJourBalance) {
        this.mateWxJourBalance = mateWxJourBalance;
    }

    public String getMateWxJourMonthIncome() {
        return mateWxJourMonthIncome;
    }

    public void setMateWxJourMonthIncome(String mateWxJourMonthIncome) {
        this.mateWxJourMonthIncome = mateWxJourMonthIncome;
    }

    public String getMateWxJourMonthExpend() {
        return mateWxJourMonthExpend;
    }

    public void setMateWxJourMonthExpend(String mateWxJourMonthExpend) {
        this.mateWxJourMonthExpend = mateWxJourMonthExpend;
    }

    public String getMateWxJourPic() {
        return mateWxJourPic;
    }

    public void setMateWxJourPic(String mateWxJourPic) {
        this.mateWxJourPic = mateWxJourPic;
    }

    public String getMateWxJourRemark() {
        return mateWxJourRemark;
    }

    public void setMateWxJourRemark(String mateWxJourRemark) {
        this.mateWxJourRemark = mateWxJourRemark;
    }

    public String getMateJourDatetimeStart() {
        return mateJourDatetimeStart;
    }

    public void setMateJourDatetimeStart(String mateJourDatetimeStart) {
        this.mateJourDatetimeStart = mateJourDatetimeStart;
    }

    public String getMateJourDatetimeEnd() {
        return mateJourDatetimeEnd;
    }

    public void setMateJourDatetimeEnd(String mateJourDatetimeEnd) {
        this.mateJourDatetimeEnd = mateJourDatetimeEnd;
    }

    public String getMateJourIncome() {
        return mateJourIncome;
    }

    public void setMateJourIncome(String mateJourIncome) {
        this.mateJourIncome = mateJourIncome;
    }

    public String getMateJourExpend() {
        return mateJourExpend;
    }

    public void setMateJourExpend(String mateJourExpend) {
        this.mateJourExpend = mateJourExpend;
    }

    public String getMateJourBalance() {
        return mateJourBalance;
    }

    public void setMateJourBalance(String mateJourBalance) {
        this.mateJourBalance = mateJourBalance;
    }

    public String getMateJourMonthIncome() {
        return mateJourMonthIncome;
    }

    public void setMateJourMonthIncome(String mateJourMonthIncome) {
        this.mateJourMonthIncome = mateJourMonthIncome;
    }

    public String getMateJourMonthExpend() {
        return mateJourMonthExpend;
    }

    public void setMateJourMonthExpend(String mateJourMonthExpend) {
        this.mateJourMonthExpend = mateJourMonthExpend;
    }

    public String getMateJourPic() {
        return mateJourPic;
    }

    public void setMateJourPic(String mateJourPic) {
        this.mateJourPic = mateJourPic;
    }

    public String getMateJourRemark() {
        return mateJourRemark;
    }

    public void setMateJourRemark(String mateJourRemark) {
        this.mateJourRemark = mateJourRemark;
    }

    public String getMateAssetPdf() {
        return mateAssetPdf;
    }

    public void setMateAssetPdf(String mateAssetPdf) {
        this.mateAssetPdf = mateAssetPdf;
    }

    public String getGuaZfbJourDatetimeStart() {
        return guaZfbJourDatetimeStart;
    }

    public void setGuaZfbJourDatetimeStart(String guaZfbJourDatetimeStart) {
        this.guaZfbJourDatetimeStart = guaZfbJourDatetimeStart;
    }

    public String getGuaZfbJourDatetimeEnd() {
        return guaZfbJourDatetimeEnd;
    }

    public void setGuaZfbJourDatetimeEnd(String guaZfbJourDatetimeEnd) {
        this.guaZfbJourDatetimeEnd = guaZfbJourDatetimeEnd;
    }

    public String getGuaZfbJourIncome() {
        return guaZfbJourIncome;
    }

    public void setGuaZfbJourIncome(String guaZfbJourIncome) {
        this.guaZfbJourIncome = guaZfbJourIncome;
    }

    public String getGuaZfbJourExpend() {
        return guaZfbJourExpend;
    }

    public void setGuaZfbJourExpend(String guaZfbJourExpend) {
        this.guaZfbJourExpend = guaZfbJourExpend;
    }

    public String getGuaZfbJourBalance() {
        return guaZfbJourBalance;
    }

    public void setGuaZfbJourBalance(String guaZfbJourBalance) {
        this.guaZfbJourBalance = guaZfbJourBalance;
    }

    public String getGuaZfbJourMonthIncome() {
        return guaZfbJourMonthIncome;
    }

    public void setGuaZfbJourMonthIncome(String guaZfbJourMonthIncome) {
        this.guaZfbJourMonthIncome = guaZfbJourMonthIncome;
    }

    public String getGuaZfbJourMonthExpend() {
        return guaZfbJourMonthExpend;
    }

    public void setGuaZfbJourMonthExpend(String guaZfbJourMonthExpend) {
        this.guaZfbJourMonthExpend = guaZfbJourMonthExpend;
    }

    public String getGuaZfbJourPic() {
        return guaZfbJourPic;
    }

    public void setGuaZfbJourPic(String guaZfbJourPic) {
        this.guaZfbJourPic = guaZfbJourPic;
    }

    public String getGuaZfbJourRemark() {
        return guaZfbJourRemark;
    }

    public void setGuaZfbJourRemark(String guaZfbJourRemark) {
        this.guaZfbJourRemark = guaZfbJourRemark;
    }

    public String getGuaWxJourDatetimeStart() {
        return guaWxJourDatetimeStart;
    }

    public void setGuaWxJourDatetimeStart(String guaWxJourDatetimeStart) {
        this.guaWxJourDatetimeStart = guaWxJourDatetimeStart;
    }

    public String getGuaWxJourDatetimeEnd() {
        return guaWxJourDatetimeEnd;
    }

    public void setGuaWxJourDatetimeEnd(String guaWxJourDatetimeEnd) {
        this.guaWxJourDatetimeEnd = guaWxJourDatetimeEnd;
    }

    public String getGuaWxJourIncome() {
        return guaWxJourIncome;
    }

    public void setGuaWxJourIncome(String guaWxJourIncome) {
        this.guaWxJourIncome = guaWxJourIncome;
    }

    public String getGuaWxJourExpend() {
        return guaWxJourExpend;
    }

    public void setGuaWxJourExpend(String guaWxJourExpend) {
        this.guaWxJourExpend = guaWxJourExpend;
    }

    public String getGuaWxJourBalance() {
        return guaWxJourBalance;
    }

    public void setGuaWxJourBalance(String guaWxJourBalance) {
        this.guaWxJourBalance = guaWxJourBalance;
    }

    public String getGuaWxJourMonthIncome() {
        return guaWxJourMonthIncome;
    }

    public void setGuaWxJourMonthIncome(String guaWxJourMonthIncome) {
        this.guaWxJourMonthIncome = guaWxJourMonthIncome;
    }

    public String getGuaWxJourMonthExpend() {
        return guaWxJourMonthExpend;
    }

    public void setGuaWxJourMonthExpend(String guaWxJourMonthExpend) {
        this.guaWxJourMonthExpend = guaWxJourMonthExpend;
    }

    public String getGuaWxJourPic() {
        return guaWxJourPic;
    }

    public void setGuaWxJourPic(String guaWxJourPic) {
        this.guaWxJourPic = guaWxJourPic;
    }

    public String getGuaWxJourRemark() {
        return guaWxJourRemark;
    }

    public void setGuaWxJourRemark(String guaWxJourRemark) {
        this.guaWxJourRemark = guaWxJourRemark;
    }

    public String getGuaJourDatetimeStart() {
        return guaJourDatetimeStart;
    }

    public void setGuaJourDatetimeStart(String guaJourDatetimeStart) {
        this.guaJourDatetimeStart = guaJourDatetimeStart;
    }

    public String getGuaJourDatetimeEnd() {
        return guaJourDatetimeEnd;
    }

    public void setGuaJourDatetimeEnd(String guaJourDatetimeEnd) {
        this.guaJourDatetimeEnd = guaJourDatetimeEnd;
    }

    public String getGuaJourIncome() {
        return guaJourIncome;
    }

    public void setGuaJourIncome(String guaJourIncome) {
        this.guaJourIncome = guaJourIncome;
    }

    public String getGuaJourExpend() {
        return guaJourExpend;
    }

    public void setGuaJourExpend(String guaJourExpend) {
        this.guaJourExpend = guaJourExpend;
    }

    public String getGuaJourBalance() {
        return guaJourBalance;
    }

    public void setGuaJourBalance(String guaJourBalance) {
        this.guaJourBalance = guaJourBalance;
    }

    public String getGuaJourMonthIncome() {
        return guaJourMonthIncome;
    }

    public void setGuaJourMonthIncome(String guaJourMonthIncome) {
        this.guaJourMonthIncome = guaJourMonthIncome;
    }

    public String getGuaJourMonthExpend() {
        return guaJourMonthExpend;
    }

    public void setGuaJourMonthExpend(String guaJourMonthExpend) {
        this.guaJourMonthExpend = guaJourMonthExpend;
    }

    public String getGuaJourPic() {
        return guaJourPic;
    }

    public void setGuaJourPic(String guaJourPic) {
        this.guaJourPic = guaJourPic;
    }

    public String getGuaJourRemark() {
        return guaJourRemark;
    }

    public void setGuaJourRemark(String guaJourRemark) {
        this.guaJourRemark = guaJourRemark;
    }

    public String getGuaAssetPdf() {
        return guaAssetPdf;
    }

    public void setGuaAssetPdf(String guaAssetPdf) {
        this.guaAssetPdf = guaAssetPdf;
    }

    public String getZfbJourDatetimeStart() {
        return zfbJourDatetimeStart;
    }

    public void setZfbJourDatetimeStart(String zfbJourDatetimeStart) {
        this.zfbJourDatetimeStart = zfbJourDatetimeStart;
    }

    public String getZfbJourDatetimeEnd() {
        return zfbJourDatetimeEnd;
    }

    public void setZfbJourDatetimeEnd(String zfbJourDatetimeEnd) {
        this.zfbJourDatetimeEnd = zfbJourDatetimeEnd;
    }

    public String getZfbJourIncome() {
        return zfbJourIncome;
    }

    public void setZfbJourIncome(String zfbJourIncome) {
        this.zfbJourIncome = zfbJourIncome;
    }

    public String getZfbJourExpend() {
        return zfbJourExpend;
    }

    public void setZfbJourExpend(String zfbJourExpend) {
        this.zfbJourExpend = zfbJourExpend;
    }

    public String getZfbJourBalance() {
        return zfbJourBalance;
    }

    public void setZfbJourBalance(String zfbJourBalance) {
        this.zfbJourBalance = zfbJourBalance;
    }

    public String getZfbJourMonthIncome() {
        return zfbJourMonthIncome;
    }

    public void setZfbJourMonthIncome(String zfbJourMonthIncome) {
        this.zfbJourMonthIncome = zfbJourMonthIncome;
    }

    public String getZfbJourMonthExpend() {
        return zfbJourMonthExpend;
    }

    public void setZfbJourMonthExpend(String zfbJourMonthExpend) {
        this.zfbJourMonthExpend = zfbJourMonthExpend;
    }

    public String getZfbJourPic() {
        return zfbJourPic;
    }

    public void setZfbJourPic(String zfbJourPic) {
        this.zfbJourPic = zfbJourPic;
    }

    public String getZfbJourRemark() {
        return zfbJourRemark;
    }

    public void setZfbJourRemark(String zfbJourRemark) {
        this.zfbJourRemark = zfbJourRemark;
    }

    public String getWxJourDatetimeStart() {
        return wxJourDatetimeStart;
    }

    public void setWxJourDatetimeStart(String wxJourDatetimeStart) {
        this.wxJourDatetimeStart = wxJourDatetimeStart;
    }

    public String getWxJourDatetimeEnd() {
        return wxJourDatetimeEnd;
    }

    public void setWxJourDatetimeEnd(String wxJourDatetimeEnd) {
        this.wxJourDatetimeEnd = wxJourDatetimeEnd;
    }

    public String getWxJourIncome() {
        return wxJourIncome;
    }

    public void setWxJourIncome(String wxJourIncome) {
        this.wxJourIncome = wxJourIncome;
    }

    public String getWxJourExpend() {
        return wxJourExpend;
    }

    public void setWxJourExpend(String wxJourExpend) {
        this.wxJourExpend = wxJourExpend;
    }

    public String getWxJourBalance() {
        return wxJourBalance;
    }

    public void setWxJourBalance(String wxJourBalance) {
        this.wxJourBalance = wxJourBalance;
    }

    public String getWxJourMonthIncome() {
        return wxJourMonthIncome;
    }

    public void setWxJourMonthIncome(String wxJourMonthIncome) {
        this.wxJourMonthIncome = wxJourMonthIncome;
    }

    public String getWxJourMonthExpend() {
        return wxJourMonthExpend;
    }

    public void setWxJourMonthExpend(String wxJourMonthExpend) {
        this.wxJourMonthExpend = wxJourMonthExpend;
    }

    public String getWxJourPic() {
        return wxJourPic;
    }

    public void setWxJourPic(String wxJourPic) {
        this.wxJourPic = wxJourPic;
    }

    public String getWxJourRemark() {
        return wxJourRemark;
    }

    public void setWxJourRemark(String wxJourRemark) {
        this.wxJourRemark = wxJourRemark;
    }

    public String getJourPic() {
        return jourPic;
    }

    public void setJourPic(String jourPic) {
        this.jourPic = jourPic;
    }

    public String getAssetPdf() {
        return assetPdf;
    }

    public void setAssetPdf(String assetPdf) {
        this.assetPdf = assetPdf;
    }

    public String getWorkCompanyProperty() {
        return workCompanyProperty;
    }

    public void setWorkCompanyProperty(String workCompanyProperty) {
        this.workCompanyProperty = workCompanyProperty;
    }

    public String getWorkBelongIndustry() {
        return workBelongIndustry;
    }

    public void setWorkBelongIndustry(String workBelongIndustry) {
        this.workBelongIndustry = workBelongIndustry;
    }

    public String getWorkProfession() {
        return workProfession;
    }

    public void setWorkProfession(String workProfession) {
        this.workProfession = workProfession;
    }

    public String getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(String workDatetime) {
        this.workDatetime = workDatetime;
    }

}
