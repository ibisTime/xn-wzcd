package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 预算单
* @author: xieyj 
* @since: 2018-05-26 17:53:19
* @history:
*/
public class BudgetOrder extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 客户类型
    private String customerType;

    // 客户姓名
    private String customerName;

    // 汽车经销商编号
    private String carDealerCode;

    // 贷款银行编号
    private String loanBankCode;

    // 厂商指导价
    private String originalPrice;

    // 车辆型号
    private String carModel;

    // 贷款周期
    private String loanPeriods;

    // 发票价格
    private String invoicePrice;

    // 购车途径
    private String shopWay;

    // 利率类型
    private String rateType;

    // 贷款金额
    private String loanAmount;

    // 是否需要贷前调查
    private String isSurvey;

    // 银行利率
    private String bankRate;

    // 我司贷款成数
    private String companyLoanCs;

    // 是否垫资
    private String isAdvanceFund;

    // 综合利率
    private String globalRate;

    // 服务费
    private String fee;

    // 厂家贴息
    private String carDealerSubsidy;

    // 银行贷款成数
    private String bankLoanCs;

    // 业务公司编号
    private String companyCode;

    // 业务员编号
    private String saleUserId;

    // 车价
    private String carPrice;

    // 经办支行
    private String bankBranch;

    // 房产证情况
    private String isHouseProperty;

    // 房产证
    private String houseProperty;

    // 有无购房合同
    private String isHouseContract;

    // 购房合同
    private String houseContract;

    // 购房发票
    private String houseInvoice;

    // 营业执照情况
    private String isLicense;

    // 营业执照
    private String license;

    // 提供场地证明
    private String isSiteProve;

    // 场地证明
    private String siteProve;

    // 经营场地面积
    private String siteArea;

    // 现有车辆类型
    private String carType;

    // 有无驾照
    private String isDriceLicense;

    // 驾照
    private String driceLicense;

    // 其他资产说明
    private String otherPropertyNote;

    // 申请人户籍地
    private String applyBirthAddress;

    // 现住地址
    private String applyNowAddress;

    // 现住房屋类型
    private String houseType;

    // 共还人户籍地
    private String ghBirthAddress;

    // 担保1户籍地
    private String guarantor1BirthAddress;

    // 担保2户籍地
    private String guarantor2BirthAddress;

    // 其他情况说明
    private String otherNote;

    // 油补
    private String oilSubsidy;

    // 油补公里数
    private String oilSubsidyKil;

    // 是否我司续保
    private String isPlatInsure;

    // GPS收费
    private String gpsFee;

    // GPS提成
    private String gpsDeduct;

    // GPS收费方式
    private String gpsFeeWay;

    // 履约保证金
    private String lyAmount;

    // 担保风险金
    private String fxAmount;

    // 杂费
    private String otherFee;

    // 手续费收取方式
    private String feeWay;

    // 结婚证离婚证
    private String marryDivorce;

    // 户口本(主贷本人页)
    private String applyUserHkb;

    // 银行流水
    private String bankBillPdf;

    // 单身证明
    private String singleProvePdf;

    // 收入证明
    private String incomeProvePdf;

    // 居住证明
    private String liveProvePdf;

    // 自建房证明
    private String buildProvePdf;

    // 户口本（首页）
    private String hkbFirstPage;

    // 户口本（户主页）
    private String hkbMainPage;

    // 共还人户口本
    private String ghHkb;

    // 担保人1身份证
    private String guarantor1IdNo;

    // 担保人1户口本
    private String guarantor1Hkb;

    // 担保人2身份证
    private String guarantor2IdNo;

    // 担保人2户口本
    private String guarantor2Hkb;

    // 小区外观
    private String housePic;

    // 单元楼照片
    private String houseUnitPic;

    // 门牌照片
    private String houseDoorPic;

    // 客厅照片
    private String houseRoomPic;

    // 主贷与住宅合影
    private String houseCustomerPic;

    // 签约员与客户在房子合影照片
    private String houseSaleCustomerPic;

    // 企业名称照片
    private String companyNamePic;

    // 办公场地照片
    private String companyPlacePic;

    // 生产车间照片
    private String companyWorkshopPic;

    // 签约员与客户在公司合影照片
    private String companySaleCustomerPic;

    // 二手车合格证
    private String secondHgz;

    // 里程表
    private String secondOdometer;

    // 车前正面照
    private String secondCarFrontPic;

    // 中控台
    private String secondConsolePic;

    // 车300评估页
    private String second300Pdf;

    // 汽修宝截图
    private String secondQxbPic;

    // 车内饰
    private String secondCarInPic;

    // 铭牌
    private String secondNumber;

    // 其他材料附件
    private String otherFilePdf;

    // 申请说明事项
    private String otherApplyNote;

    // 申请时间
    private String applyDatetime;

    // 撤销理由
    private String cancelReason;

    // 银行提交时间
    private String bankCommitDatetime;

    // 银行提交说明
    private String bankCommitNote;

    // 银行放款金额
    private String bankFkAmount;

    // 银行放款时间
    private String bankFkDatetime;

    // 收款银行
    private String bankReceiptCode;

    // 收款银行账号
    private String bankReceiptNumber;

    // 收款凭证
    private String bankReceiptPdf;

    // 收款说明
    private String bankReceiptNote;

    // 抵押提交时间
    private String pledgeCommitDatetime;

    // 抵押提交说明
    private String pledgeCommitNote;

    // 抵押合同编号
    private String pledgeContractCode;

    // 保险公司编号
    private String insuranceCompanyCode;

    // 车辆颜色
    private String carColor;

    // 车辆品牌
    private String carBrand;

    // 车架号码
    private String frameNo;

    // 发动机号码
    private String engineNo;

    // 商业险合计
    private String commerceInsurance;

    // 保险生效日期
    private String insuranceEffectDatetime;

    // 保险经办银行
    private String insuranceBank;

    // 担保合同编号
    private String guaranteeContractCode;

    // 登记证书号
    private String regCertificateCode;

    // 其他联系人
    private String otherContact;

    // 联系人手机
    private String contactMobile;

    // 担保人姓名
    private String guarantorName;

    // 担保人手机
    private String guarantorMobile;

    // 银行卡号
    private String bankCardNumber;

    // 对账单日
    private String billDatetime;

    // 月还款额
    private String monthAmount;

    // 身份证照片
    private String idNoPic;

    // 已入档清单
    private String fileList;

    // 资料是否完善
    private String isComplete;

    // 存放位置
    private String storePlace;

    // 入档备注
    private String fileRemark;

    // 经办人
    private String operator;

    // 经办日期
    private String operateDatetime;

    // 经办部门
    private String operateDepartment;

    // 制卡备注
    private String makecardRemark;

    // 提车日期
    private String deliveryDatetime;

    // 发票是否正确
    private String isRightInvoice;

    // 现发票价
    private String currentInvoicePrice;

    // 发票
    private String invoice;

    // 合格证
    private String certification;

    // 交强险
    private String forceInsurance;

    // 商业险
    private String businessInsurance;

    // 机动车登记证书
    private String motorRegCertification;

    // 批单
    private String pdPdf;

    // 发保合备注
    private String fbhRemark;

    // 发保合预警天数
    private String fbhWarnDay;

    // 状态
    private String status;

    // 应退按揭款
    private String shouldBackAmount;

    // 付款时间
    private String payDatetime;

    // 付款银行
    private String payBank;

    // 付款账号
    private String payAccount;

    // 付款凭证
    private String payPdf;

    // 作废申请日期
    private String zfApplyDatetime;

    // 作废作废原因
    private String zfReason;

    // 作废收款金额
    private String zfSkAmount;

    // 作废收款银行
    private String zfSkBank;

    // 作废收款账号
    private String zfSkBankcardNumber;

    // 作废收款时间
    private String zfSkReceiptDatetime;

    // 作废财务备注
    private String zfFinanceRemark;

    // 节点编号
    private String curNodeCode;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setLoanPeriods(String loanPeriods) {
        this.loanPeriods = loanPeriods;
    }

    public String getLoanPeriods() {
        return loanPeriods;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setShopWay(String shopWay) {
        this.shopWay = shopWay;
    }

    public String getShopWay() {
        return shopWay;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getRateType() {
        return rateType;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setIsSurvey(String isSurvey) {
        this.isSurvey = isSurvey;
    }

    public String getIsSurvey() {
        return isSurvey;
    }

    public void setBankRate(String bankRate) {
        this.bankRate = bankRate;
    }

    public String getBankRate() {
        return bankRate;
    }

    public void setCompanyLoanCs(String companyLoanCs) {
        this.companyLoanCs = companyLoanCs;
    }

    public String getCompanyLoanCs() {
        return companyLoanCs;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setGlobalRate(String globalRate) {
        this.globalRate = globalRate;
    }

    public String getGlobalRate() {
        return globalRate;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFee() {
        return fee;
    }

    public void setCarDealerSubsidy(String carDealerSubsidy) {
        this.carDealerSubsidy = carDealerSubsidy;
    }

    public String getCarDealerSubsidy() {
        return carDealerSubsidy;
    }

    public void setBankLoanCs(String bankLoanCs) {
        this.bankLoanCs = bankLoanCs;
    }

    public String getBankLoanCs() {
        return bankLoanCs;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setIsHouseProperty(String isHouseProperty) {
        this.isHouseProperty = isHouseProperty;
    }

    public String getIsHouseProperty() {
        return isHouseProperty;
    }

    public void setHouseProperty(String houseProperty) {
        this.houseProperty = houseProperty;
    }

    public String getHouseProperty() {
        return houseProperty;
    }

    public void setIsHouseContract(String isHouseContract) {
        this.isHouseContract = isHouseContract;
    }

    public String getIsHouseContract() {
        return isHouseContract;
    }

    public void setHouseContract(String houseContract) {
        this.houseContract = houseContract;
    }

    public String getHouseContract() {
        return houseContract;
    }

    public void setHouseInvoice(String houseInvoice) {
        this.houseInvoice = houseInvoice;
    }

    public String getHouseInvoice() {
        return houseInvoice;
    }

    public void setIsLicense(String isLicense) {
        this.isLicense = isLicense;
    }

    public String getIsLicense() {
        return isLicense;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setIsSiteProve(String isSiteProve) {
        this.isSiteProve = isSiteProve;
    }

    public String getIsSiteProve() {
        return isSiteProve;
    }

    public void setSiteProve(String siteProve) {
        this.siteProve = siteProve;
    }

    public String getSiteProve() {
        return siteProve;
    }

    public void setSiteArea(String siteArea) {
        this.siteArea = siteArea;
    }

    public String getSiteArea() {
        return siteArea;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarType() {
        return carType;
    }

    public void setIsDriceLicense(String isDriceLicense) {
        this.isDriceLicense = isDriceLicense;
    }

    public String getIsDriceLicense() {
        return isDriceLicense;
    }

    public void setDriceLicense(String driceLicense) {
        this.driceLicense = driceLicense;
    }

    public String getDriceLicense() {
        return driceLicense;
    }

    public void setOtherPropertyNote(String otherPropertyNote) {
        this.otherPropertyNote = otherPropertyNote;
    }

    public String getOtherPropertyNote() {
        return otherPropertyNote;
    }

    public void setApplyBirthAddress(String applyBirthAddress) {
        this.applyBirthAddress = applyBirthAddress;
    }

    public String getApplyBirthAddress() {
        return applyBirthAddress;
    }

    public void setApplyNowAddress(String applyNowAddress) {
        this.applyNowAddress = applyNowAddress;
    }

    public String getApplyNowAddress() {
        return applyNowAddress;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setGhBirthAddress(String ghBirthAddress) {
        this.ghBirthAddress = ghBirthAddress;
    }

    public String getGhBirthAddress() {
        return ghBirthAddress;
    }

    public void setGuarantor1BirthAddress(String guarantor1BirthAddress) {
        this.guarantor1BirthAddress = guarantor1BirthAddress;
    }

    public String getGuarantor1BirthAddress() {
        return guarantor1BirthAddress;
    }

    public void setGuarantor2BirthAddress(String guarantor2BirthAddress) {
        this.guarantor2BirthAddress = guarantor2BirthAddress;
    }

    public String getGuarantor2BirthAddress() {
        return guarantor2BirthAddress;
    }

    public void setOtherNote(String otherNote) {
        this.otherNote = otherNote;
    }

    public String getOtherNote() {
        return otherNote;
    }

    public void setOilSubsidy(String oilSubsidy) {
        this.oilSubsidy = oilSubsidy;
    }

    public String getOilSubsidy() {
        return oilSubsidy;
    }

    public void setOilSubsidyKil(String oilSubsidyKil) {
        this.oilSubsidyKil = oilSubsidyKil;
    }

    public String getOilSubsidyKil() {
        return oilSubsidyKil;
    }

    public void setIsPlatInsure(String isPlatInsure) {
        this.isPlatInsure = isPlatInsure;
    }

    public String getIsPlatInsure() {
        return isPlatInsure;
    }

    public void setGpsFee(String gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getGpsFee() {
        return gpsFee;
    }

    public void setGpsDeduct(String gpsDeduct) {
        this.gpsDeduct = gpsDeduct;
    }

    public String getGpsDeduct() {
        return gpsDeduct;
    }

    public void setGpsFeeWay(String gpsFeeWay) {
        this.gpsFeeWay = gpsFeeWay;
    }

    public String getGpsFeeWay() {
        return gpsFeeWay;
    }

    public void setLyAmount(String lyAmount) {
        this.lyAmount = lyAmount;
    }

    public String getLyAmount() {
        return lyAmount;
    }

    public void setFxAmount(String fxAmount) {
        this.fxAmount = fxAmount;
    }

    public String getFxAmount() {
        return fxAmount;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setFeeWay(String feeWay) {
        this.feeWay = feeWay;
    }

    public String getFeeWay() {
        return feeWay;
    }

    public void setMarryDivorce(String marryDivorce) {
        this.marryDivorce = marryDivorce;
    }

    public String getMarryDivorce() {
        return marryDivorce;
    }

    public void setApplyUserHkb(String applyUserHkb) {
        this.applyUserHkb = applyUserHkb;
    }

    public String getApplyUserHkb() {
        return applyUserHkb;
    }

    public void setBankBillPdf(String bankBillPdf) {
        this.bankBillPdf = bankBillPdf;
    }

    public String getBankBillPdf() {
        return bankBillPdf;
    }

    public void setSingleProvePdf(String singleProvePdf) {
        this.singleProvePdf = singleProvePdf;
    }

    public String getSingleProvePdf() {
        return singleProvePdf;
    }

    public void setIncomeProvePdf(String incomeProvePdf) {
        this.incomeProvePdf = incomeProvePdf;
    }

    public String getIncomeProvePdf() {
        return incomeProvePdf;
    }

    public void setLiveProvePdf(String liveProvePdf) {
        this.liveProvePdf = liveProvePdf;
    }

    public String getLiveProvePdf() {
        return liveProvePdf;
    }

    public void setBuildProvePdf(String buildProvePdf) {
        this.buildProvePdf = buildProvePdf;
    }

    public String getBuildProvePdf() {
        return buildProvePdf;
    }

    public void setHkbFirstPage(String hkbFirstPage) {
        this.hkbFirstPage = hkbFirstPage;
    }

    public String getHkbFirstPage() {
        return hkbFirstPage;
    }

    public void setHkbMainPage(String hkbMainPage) {
        this.hkbMainPage = hkbMainPage;
    }

    public String getHkbMainPage() {
        return hkbMainPage;
    }

    public void setGhHkb(String ghHkb) {
        this.ghHkb = ghHkb;
    }

    public String getGhHkb() {
        return ghHkb;
    }

    public void setGuarantor1IdNo(String guarantor1IdNo) {
        this.guarantor1IdNo = guarantor1IdNo;
    }

    public String getGuarantor1IdNo() {
        return guarantor1IdNo;
    }

    public void setGuarantor1Hkb(String guarantor1Hkb) {
        this.guarantor1Hkb = guarantor1Hkb;
    }

    public String getGuarantor1Hkb() {
        return guarantor1Hkb;
    }

    public void setGuarantor2IdNo(String guarantor2IdNo) {
        this.guarantor2IdNo = guarantor2IdNo;
    }

    public String getGuarantor2IdNo() {
        return guarantor2IdNo;
    }

    public void setGuarantor2Hkb(String guarantor2Hkb) {
        this.guarantor2Hkb = guarantor2Hkb;
    }

    public String getGuarantor2Hkb() {
        return guarantor2Hkb;
    }

    public void setHousePic(String housePic) {
        this.housePic = housePic;
    }

    public String getHousePic() {
        return housePic;
    }

    public void setHouseUnitPic(String houseUnitPic) {
        this.houseUnitPic = houseUnitPic;
    }

    public String getHouseUnitPic() {
        return houseUnitPic;
    }

    public void setHouseDoorPic(String houseDoorPic) {
        this.houseDoorPic = houseDoorPic;
    }

    public String getHouseDoorPic() {
        return houseDoorPic;
    }

    public void setHouseRoomPic(String houseRoomPic) {
        this.houseRoomPic = houseRoomPic;
    }

    public String getHouseRoomPic() {
        return houseRoomPic;
    }

    public void setHouseCustomerPic(String houseCustomerPic) {
        this.houseCustomerPic = houseCustomerPic;
    }

    public String getHouseCustomerPic() {
        return houseCustomerPic;
    }

    public void setHouseSaleCustomerPic(String houseSaleCustomerPic) {
        this.houseSaleCustomerPic = houseSaleCustomerPic;
    }

    public String getHouseSaleCustomerPic() {
        return houseSaleCustomerPic;
    }

    public void setCompanyNamePic(String companyNamePic) {
        this.companyNamePic = companyNamePic;
    }

    public String getCompanyNamePic() {
        return companyNamePic;
    }

    public void setCompanyPlacePic(String companyPlacePic) {
        this.companyPlacePic = companyPlacePic;
    }

    public String getCompanyPlacePic() {
        return companyPlacePic;
    }

    public void setCompanyWorkshopPic(String companyWorkshopPic) {
        this.companyWorkshopPic = companyWorkshopPic;
    }

    public String getCompanyWorkshopPic() {
        return companyWorkshopPic;
    }

    public void setCompanySaleCustomerPic(String companySaleCustomerPic) {
        this.companySaleCustomerPic = companySaleCustomerPic;
    }

    public String getCompanySaleCustomerPic() {
        return companySaleCustomerPic;
    }

    public void setSecondHgz(String secondHgz) {
        this.secondHgz = secondHgz;
    }

    public String getSecondHgz() {
        return secondHgz;
    }

    public void setSecondOdometer(String secondOdometer) {
        this.secondOdometer = secondOdometer;
    }

    public String getSecondOdometer() {
        return secondOdometer;
    }

    public void setSecondCarFrontPic(String secondCarFrontPic) {
        this.secondCarFrontPic = secondCarFrontPic;
    }

    public String getSecondCarFrontPic() {
        return secondCarFrontPic;
    }

    public void setSecondConsolePic(String secondConsolePic) {
        this.secondConsolePic = secondConsolePic;
    }

    public String getSecondConsolePic() {
        return secondConsolePic;
    }

    public void setSecond300Pdf(String second300Pdf) {
        this.second300Pdf = second300Pdf;
    }

    public String getSecond300Pdf() {
        return second300Pdf;
    }

    public void setSecondQxbPic(String secondQxbPic) {
        this.secondQxbPic = secondQxbPic;
    }

    public String getSecondQxbPic() {
        return secondQxbPic;
    }

    public void setSecondCarInPic(String secondCarInPic) {
        this.secondCarInPic = secondCarInPic;
    }

    public String getSecondCarInPic() {
        return secondCarInPic;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setOtherFilePdf(String otherFilePdf) {
        this.otherFilePdf = otherFilePdf;
    }

    public String getOtherFilePdf() {
        return otherFilePdf;
    }

    public void setOtherApplyNote(String otherApplyNote) {
        this.otherApplyNote = otherApplyNote;
    }

    public String getOtherApplyNote() {
        return otherApplyNote;
    }

    public void setApplyDatetime(String applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getApplyDatetime() {
        return applyDatetime;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setBankCommitDatetime(String bankCommitDatetime) {
        this.bankCommitDatetime = bankCommitDatetime;
    }

    public String getBankCommitDatetime() {
        return bankCommitDatetime;
    }

    public void setBankCommitNote(String bankCommitNote) {
        this.bankCommitNote = bankCommitNote;
    }

    public String getBankCommitNote() {
        return bankCommitNote;
    }

    public void setBankFkAmount(String bankFkAmount) {
        this.bankFkAmount = bankFkAmount;
    }

    public String getBankFkAmount() {
        return bankFkAmount;
    }

    public void setBankFkDatetime(String bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
    }

    public String getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankReceiptCode(String bankReceiptCode) {
        this.bankReceiptCode = bankReceiptCode;
    }

    public String getBankReceiptCode() {
        return bankReceiptCode;
    }

    public void setBankReceiptNumber(String bankReceiptNumber) {
        this.bankReceiptNumber = bankReceiptNumber;
    }

    public String getBankReceiptNumber() {
        return bankReceiptNumber;
    }

    public void setBankReceiptPdf(String bankReceiptPdf) {
        this.bankReceiptPdf = bankReceiptPdf;
    }

    public String getBankReceiptPdf() {
        return bankReceiptPdf;
    }

    public void setBankReceiptNote(String bankReceiptNote) {
        this.bankReceiptNote = bankReceiptNote;
    }

    public String getBankReceiptNote() {
        return bankReceiptNote;
    }

    public void setPledgeCommitDatetime(String pledgeCommitDatetime) {
        this.pledgeCommitDatetime = pledgeCommitDatetime;
    }

    public String getPledgeCommitDatetime() {
        return pledgeCommitDatetime;
    }

    public void setPledgeCommitNote(String pledgeCommitNote) {
        this.pledgeCommitNote = pledgeCommitNote;
    }

    public String getPledgeCommitNote() {
        return pledgeCommitNote;
    }

    public void setPledgeContractCode(String pledgeContractCode) {
        this.pledgeContractCode = pledgeContractCode;
    }

    public String getPledgeContractCode() {
        return pledgeContractCode;
    }

    public void setInsuranceCompanyCode(String insuranceCompanyCode) {
        this.insuranceCompanyCode = insuranceCompanyCode;
    }

    public String getInsuranceCompanyCode() {
        return insuranceCompanyCode;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setCommerceInsurance(String commerceInsurance) {
        this.commerceInsurance = commerceInsurance;
    }

    public String getCommerceInsurance() {
        return commerceInsurance;
    }

    public void setInsuranceEffectDatetime(String insuranceEffectDatetime) {
        this.insuranceEffectDatetime = insuranceEffectDatetime;
    }

    public String getInsuranceEffectDatetime() {
        return insuranceEffectDatetime;
    }

    public void setInsuranceBank(String insuranceBank) {
        this.insuranceBank = insuranceBank;
    }

    public String getInsuranceBank() {
        return insuranceBank;
    }

    public void setGuaranteeContractCode(String guaranteeContractCode) {
        this.guaranteeContractCode = guaranteeContractCode;
    }

    public String getGuaranteeContractCode() {
        return guaranteeContractCode;
    }

    public void setRegCertificateCode(String regCertificateCode) {
        this.regCertificateCode = regCertificateCode;
    }

    public String getRegCertificateCode() {
        return regCertificateCode;
    }

    public void setOtherContact(String otherContact) {
        this.otherContact = otherContact;
    }

    public String getOtherContact() {
        return otherContact;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setGuarantorName(String guarantorName) {
        this.guarantorName = guarantorName;
    }

    public String getGuarantorName() {
        return guarantorName;
    }

    public void setGuarantorMobile(String guarantorMobile) {
        this.guarantorMobile = guarantorMobile;
    }

    public String getGuarantorMobile() {
        return guarantorMobile;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBillDatetime(String billDatetime) {
        this.billDatetime = billDatetime;
    }

    public String getBillDatetime() {
        return billDatetime;
    }

    public void setMonthAmount(String monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getMonthAmount() {
        return monthAmount;
    }

    public void setIdNoPic(String idNoPic) {
        this.idNoPic = idNoPic;
    }

    public String getIdNoPic() {
        return idNoPic;
    }

    public void setFileList(String fileList) {
        this.fileList = fileList;
    }

    public String getFileList() {
        return fileList;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setStorePlace(String storePlace) {
        this.storePlace = storePlace;
    }

    public String getStorePlace() {
        return storePlace;
    }

    public void setFileRemark(String fileRemark) {
        this.fileRemark = fileRemark;
    }

    public String getFileRemark() {
        return fileRemark;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperateDatetime(String operateDatetime) {
        this.operateDatetime = operateDatetime;
    }

    public String getOperateDatetime() {
        return operateDatetime;
    }

    public void setOperateDepartment(String operateDepartment) {
        this.operateDepartment = operateDepartment;
    }

    public String getOperateDepartment() {
        return operateDepartment;
    }

    public void setMakecardRemark(String makecardRemark) {
        this.makecardRemark = makecardRemark;
    }

    public String getMakecardRemark() {
        return makecardRemark;
    }

    public void setDeliveryDatetime(String deliveryDatetime) {
        this.deliveryDatetime = deliveryDatetime;
    }

    public String getDeliveryDatetime() {
        return deliveryDatetime;
    }

    public void setIsRightInvoice(String isRightInvoice) {
        this.isRightInvoice = isRightInvoice;
    }

    public String getIsRightInvoice() {
        return isRightInvoice;
    }

    public void setCurrentInvoicePrice(String currentInvoicePrice) {
        this.currentInvoicePrice = currentInvoicePrice;
    }

    public String getCurrentInvoicePrice() {
        return currentInvoicePrice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getCertification() {
        return certification;
    }

    public void setForceInsurance(String forceInsurance) {
        this.forceInsurance = forceInsurance;
    }

    public String getForceInsurance() {
        return forceInsurance;
    }

    public void setBusinessInsurance(String businessInsurance) {
        this.businessInsurance = businessInsurance;
    }

    public String getBusinessInsurance() {
        return businessInsurance;
    }

    public void setMotorRegCertification(String motorRegCertification) {
        this.motorRegCertification = motorRegCertification;
    }

    public String getMotorRegCertification() {
        return motorRegCertification;
    }

    public void setPdPdf(String pdPdf) {
        this.pdPdf = pdPdf;
    }

    public String getPdPdf() {
        return pdPdf;
    }

    public void setFbhRemark(String fbhRemark) {
        this.fbhRemark = fbhRemark;
    }

    public String getFbhRemark() {
        return fbhRemark;
    }

    public void setFbhWarnDay(String fbhWarnDay) {
        this.fbhWarnDay = fbhWarnDay;
    }

    public String getFbhWarnDay() {
        return fbhWarnDay;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setShouldBackAmount(String shouldBackAmount) {
        this.shouldBackAmount = shouldBackAmount;
    }

    public String getShouldBackAmount() {
        return shouldBackAmount;
    }

    public void setPayDatetime(String payDatetime) {
        this.payDatetime = payDatetime;
    }

    public String getPayDatetime() {
        return payDatetime;
    }

    public void setPayBank(String payBank) {
        this.payBank = payBank;
    }

    public String getPayBank() {
        return payBank;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayPdf(String payPdf) {
        this.payPdf = payPdf;
    }

    public String getPayPdf() {
        return payPdf;
    }

    public void setZfApplyDatetime(String zfApplyDatetime) {
        this.zfApplyDatetime = zfApplyDatetime;
    }

    public String getZfApplyDatetime() {
        return zfApplyDatetime;
    }

    public void setZfReason(String zfReason) {
        this.zfReason = zfReason;
    }

    public String getZfReason() {
        return zfReason;
    }

    public void setZfSkAmount(String zfSkAmount) {
        this.zfSkAmount = zfSkAmount;
    }

    public String getZfSkAmount() {
        return zfSkAmount;
    }

    public void setZfSkBank(String zfSkBank) {
        this.zfSkBank = zfSkBank;
    }

    public String getZfSkBank() {
        return zfSkBank;
    }

    public void setZfSkBankcardNumber(String zfSkBankcardNumber) {
        this.zfSkBankcardNumber = zfSkBankcardNumber;
    }

    public String getZfSkBankcardNumber() {
        return zfSkBankcardNumber;
    }

    public void setZfSkReceiptDatetime(String zfSkReceiptDatetime) {
        this.zfSkReceiptDatetime = zfSkReceiptDatetime;
    }

    public String getZfSkReceiptDatetime() {
        return zfSkReceiptDatetime;
    }

    public void setZfFinanceRemark(String zfFinanceRemark) {
        this.zfFinanceRemark = zfFinanceRemark;
    }

    public String getZfFinanceRemark() {
        return zfFinanceRemark;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

}
