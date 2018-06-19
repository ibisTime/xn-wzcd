package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class XN632120Req {

    // 操作人
    private String operator;

    // 预算单编号
    private String budgetOrderCode;

    // 处理类型(0 保存 1 发送)
    @NotBlank
    private String dealType;

    // 客户类型
    private String customerType;

    // 汽车经销商编号
    @NotBlank
    private String carDealerCode;

    // 贷款支行编号
    private String loanBankSubbranch;

    // 厂商指导价
    private String originalPrice;

    // 车辆型号
    private String carModel;

    // 贷款周期
    private String loanPeriods;

    // 发票价格
    private String invoicePrice;

    // 利率类型
    private String rateType;

    // 是否需要贷前调查
    private String isSurvey;

    // 银行利率
    private String bankRate;

    // 是否垫资
    private String isAdvanceFund;

    // 服务费
    private String fee;

    // 厂家贴息
    private String carDealerSubsidy;

    // 申请人就职单位
    private String applyUserCompany;

    // 申请人职位
    private String applyUserDuty;

    // 婚姻状况
    private String marryState;

    // 月收入
    private String applyUserMonthIncome;

    // 结息
    private String applyUserSettleInterest;

    // 余额
    private String applyUserBalance;

    // 流水是否体现月收入
    private String applyUserJourShowIncome;

    // 是否打件
    private String applyUserIsPrint;

    // 月收入
    private String ghMonthIncome;

    // 结息
    private String ghSettleInterest;

    // 余额
    private String ghBalance;

    // 流水是否体现月收入
    private String ghJourShowIncome;

    // 是否打件
    private String ghIsPrint;

    // 月收入
    private String guarantor1MonthIncome;

    // 结息
    private String guarantor1SettleInterest;

    // 余额
    private String guarantor1Balance;

    // 流水是否体现月收入
    private String guarantor1JourShowIncome;

    // 是否打件
    private String guarantor1IsPrint;

    // 月收入
    private String guarantor2MonthIncome;

    // 结息
    private String guarantor2SettleInterest;

    // 余额
    private String guarantor2Balance;

    // 流水是否体现月收入
    private String guarantor2JourShowIncome;

    // 是否打件
    private String guarantor2IsPrint;

    // 其他收入说明
    private String otherIncomeNote;

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

    // GPS提成
    private String gpsDeduct;

    // GPS收费方式
    private String gpsFeeWay;

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

    // gps列表编号
    @NotEmpty
    private List<String> gpsList;

    // 用款用途
    @NotEmpty
    private List<XN632120ReqRepointDetail> repointDetailList;

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public List<XN632120ReqRepointDetail> getRepointDetailList() {
        return repointDetailList;
    }

    public void setRepointDetailList(
            List<XN632120ReqRepointDetail> repointDetailList) {
        this.repointDetailList = repointDetailList;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getApplyUserCompany() {
        return applyUserCompany;
    }

    public void setApplyUserCompany(String applyUserCompany) {
        this.applyUserCompany = applyUserCompany;
    }

    public String getApplyUserDuty() {
        return applyUserDuty;
    }

    public void setApplyUserDuty(String applyUserDuty) {
        this.applyUserDuty = applyUserDuty;
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
    }

    public String getOtherIncomeNote() {
        return otherIncomeNote;
    }

    public void setOtherIncomeNote(String otherIncomeNote) {
        this.otherIncomeNote = otherIncomeNote;
    }

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

    public List<String> getGpsList() {
        return gpsList;
    }

    public void setGpsList(List<String> gpsList) {
        this.gpsList = gpsList;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getLoanPeriods() {
        return loanPeriods;
    }

    public void setLoanPeriods(String loanPeriods) {
        this.loanPeriods = loanPeriods;
    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getIsSurvey() {
        return isSurvey;
    }

    public void setIsSurvey(String isSurvey) {
        this.isSurvey = isSurvey;
    }

    public String getBankRate() {
        return bankRate;
    }

    public void setBankRate(String bankRate) {
        this.bankRate = bankRate;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getCarDealerSubsidy() {
        return carDealerSubsidy;
    }

    public void setCarDealerSubsidy(String carDealerSubsidy) {
        this.carDealerSubsidy = carDealerSubsidy;
    }

    public String getIsHouseProperty() {
        return isHouseProperty;
    }

    public void setIsHouseProperty(String isHouseProperty) {
        this.isHouseProperty = isHouseProperty;
    }

    public String getHouseProperty() {
        return houseProperty;
    }

    public void setHouseProperty(String houseProperty) {
        this.houseProperty = houseProperty;
    }

    public String getIsHouseContract() {
        return isHouseContract;
    }

    public void setIsHouseContract(String isHouseContract) {
        this.isHouseContract = isHouseContract;
    }

    public String getHouseContract() {
        return houseContract;
    }

    public void setHouseContract(String houseContract) {
        this.houseContract = houseContract;
    }

    public String getHouseInvoice() {
        return houseInvoice;
    }

    public void setHouseInvoice(String houseInvoice) {
        this.houseInvoice = houseInvoice;
    }

    public String getIsLicense() {
        return isLicense;
    }

    public void setIsLicense(String isLicense) {
        this.isLicense = isLicense;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getIsSiteProve() {
        return isSiteProve;
    }

    public void setIsSiteProve(String isSiteProve) {
        this.isSiteProve = isSiteProve;
    }

    public String getSiteProve() {
        return siteProve;
    }

    public void setSiteProve(String siteProve) {
        this.siteProve = siteProve;
    }

    public String getSiteArea() {
        return siteArea;
    }

    public void setSiteArea(String siteArea) {
        this.siteArea = siteArea;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getIsDriceLicense() {
        return isDriceLicense;
    }

    public void setIsDriceLicense(String isDriceLicense) {
        this.isDriceLicense = isDriceLicense;
    }

    public String getDriceLicense() {
        return driceLicense;
    }

    public void setDriceLicense(String driceLicense) {
        this.driceLicense = driceLicense;
    }

    public String getLoanBankSubbranch() {
        return loanBankSubbranch;
    }

    public void setLoanBankSubbranch(String loanBankSubbranch) {
        this.loanBankSubbranch = loanBankSubbranch;
    }

    public String getOtherPropertyNote() {
        return otherPropertyNote;
    }

    public void setOtherPropertyNote(String otherPropertyNote) {
        this.otherPropertyNote = otherPropertyNote;
    }

    public String getApplyBirthAddress() {
        return applyBirthAddress;
    }

    public void setApplyBirthAddress(String applyBirthAddress) {
        this.applyBirthAddress = applyBirthAddress;
    }

    public String getApplyNowAddress() {
        return applyNowAddress;
    }

    public void setApplyNowAddress(String applyNowAddress) {
        this.applyNowAddress = applyNowAddress;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getGhBirthAddress() {
        return ghBirthAddress;
    }

    public void setGhBirthAddress(String ghBirthAddress) {
        this.ghBirthAddress = ghBirthAddress;
    }

    public String getGuarantor1BirthAddress() {
        return guarantor1BirthAddress;
    }

    public void setGuarantor1BirthAddress(String guarantor1BirthAddress) {
        this.guarantor1BirthAddress = guarantor1BirthAddress;
    }

    public String getGuarantor2BirthAddress() {
        return guarantor2BirthAddress;
    }

    public void setGuarantor2BirthAddress(String guarantor2BirthAddress) {
        this.guarantor2BirthAddress = guarantor2BirthAddress;
    }

    public String getOtherNote() {
        return otherNote;
    }

    public void setOtherNote(String otherNote) {
        this.otherNote = otherNote;
    }

    public String getOilSubsidy() {
        return oilSubsidy;
    }

    public void setOilSubsidy(String oilSubsidy) {
        this.oilSubsidy = oilSubsidy;
    }

    public String getOilSubsidyKil() {
        return oilSubsidyKil;
    }

    public void setOilSubsidyKil(String oilSubsidyKil) {
        this.oilSubsidyKil = oilSubsidyKil;
    }

    public String getIsPlatInsure() {
        return isPlatInsure;
    }

    public void setIsPlatInsure(String isPlatInsure) {
        this.isPlatInsure = isPlatInsure;
    }

    public String getGpsDeduct() {
        return gpsDeduct;
    }

    public void setGpsDeduct(String gpsDeduct) {
        this.gpsDeduct = gpsDeduct;
    }

    public String getGpsFeeWay() {
        return gpsFeeWay;
    }

    public void setGpsFeeWay(String gpsFeeWay) {
        this.gpsFeeWay = gpsFeeWay;
    }

    public String getFeeWay() {
        return feeWay;
    }

    public void setFeeWay(String feeWay) {
        this.feeWay = feeWay;
    }

    public String getMarryDivorce() {
        return marryDivorce;
    }

    public void setMarryDivorce(String marryDivorce) {
        this.marryDivorce = marryDivorce;
    }

    public String getApplyUserHkb() {
        return applyUserHkb;
    }

    public void setApplyUserHkb(String applyUserHkb) {
        this.applyUserHkb = applyUserHkb;
    }

    public String getBankBillPdf() {
        return bankBillPdf;
    }

    public void setBankBillPdf(String bankBillPdf) {
        this.bankBillPdf = bankBillPdf;
    }

    public String getSingleProvePdf() {
        return singleProvePdf;
    }

    public void setSingleProvePdf(String singleProvePdf) {
        this.singleProvePdf = singleProvePdf;
    }

    public String getIncomeProvePdf() {
        return incomeProvePdf;
    }

    public void setIncomeProvePdf(String incomeProvePdf) {
        this.incomeProvePdf = incomeProvePdf;
    }

    public String getLiveProvePdf() {
        return liveProvePdf;
    }

    public void setLiveProvePdf(String liveProvePdf) {
        this.liveProvePdf = liveProvePdf;
    }

    public String getBuildProvePdf() {
        return buildProvePdf;
    }

    public void setBuildProvePdf(String buildProvePdf) {
        this.buildProvePdf = buildProvePdf;
    }

    public String getHkbFirstPage() {
        return hkbFirstPage;
    }

    public void setHkbFirstPage(String hkbFirstPage) {
        this.hkbFirstPage = hkbFirstPage;
    }

    public String getHkbMainPage() {
        return hkbMainPage;
    }

    public void setHkbMainPage(String hkbMainPage) {
        this.hkbMainPage = hkbMainPage;
    }

    public String getGhHkb() {
        return ghHkb;
    }

    public void setGhHkb(String ghHkb) {
        this.ghHkb = ghHkb;
    }

    public String getGuarantor1IdNo() {
        return guarantor1IdNo;
    }

    public void setGuarantor1IdNo(String guarantor1IdNo) {
        this.guarantor1IdNo = guarantor1IdNo;
    }

    public String getGuarantor1Hkb() {
        return guarantor1Hkb;
    }

    public void setGuarantor1Hkb(String guarantor1Hkb) {
        this.guarantor1Hkb = guarantor1Hkb;
    }

    public String getGuarantor2IdNo() {
        return guarantor2IdNo;
    }

    public void setGuarantor2IdNo(String guarantor2IdNo) {
        this.guarantor2IdNo = guarantor2IdNo;
    }

    public String getGuarantor2Hkb() {
        return guarantor2Hkb;
    }

    public void setGuarantor2Hkb(String guarantor2Hkb) {
        this.guarantor2Hkb = guarantor2Hkb;
    }

    public String getHousePic() {
        return housePic;
    }

    public String getApplyUserMonthIncome() {
        return applyUserMonthIncome;
    }

    public void setApplyUserMonthIncome(String applyUserMonthIncome) {
        this.applyUserMonthIncome = applyUserMonthIncome;
    }

    public String getApplyUserSettleInterest() {
        return applyUserSettleInterest;
    }

    public void setApplyUserSettleInterest(String applyUserSettleInterest) {
        this.applyUserSettleInterest = applyUserSettleInterest;
    }

    public String getApplyUserBalance() {
        return applyUserBalance;
    }

    public void setApplyUserBalance(String applyUserBalance) {
        this.applyUserBalance = applyUserBalance;
    }

    public String getApplyUserJourShowIncome() {
        return applyUserJourShowIncome;
    }

    public void setApplyUserJourShowIncome(String applyUserJourShowIncome) {
        this.applyUserJourShowIncome = applyUserJourShowIncome;
    }

    public String getApplyUserIsPrint() {
        return applyUserIsPrint;
    }

    public void setApplyUserIsPrint(String applyUserIsPrint) {
        this.applyUserIsPrint = applyUserIsPrint;
    }

    public String getGhMonthIncome() {
        return ghMonthIncome;
    }

    public void setGhMonthIncome(String ghMonthIncome) {
        this.ghMonthIncome = ghMonthIncome;
    }

    public String getGhSettleInterest() {
        return ghSettleInterest;
    }

    public void setGhSettleInterest(String ghSettleInterest) {
        this.ghSettleInterest = ghSettleInterest;
    }

    public String getGhBalance() {
        return ghBalance;
    }

    public void setGhBalance(String ghBalance) {
        this.ghBalance = ghBalance;
    }

    public String getGhJourShowIncome() {
        return ghJourShowIncome;
    }

    public void setGhJourShowIncome(String ghJourShowIncome) {
        this.ghJourShowIncome = ghJourShowIncome;
    }

    public String getGhIsPrint() {
        return ghIsPrint;
    }

    public void setGhIsPrint(String ghIsPrint) {
        this.ghIsPrint = ghIsPrint;
    }

    public String getGuarantor1MonthIncome() {
        return guarantor1MonthIncome;
    }

    public void setGuarantor1MonthIncome(String guarantor1MonthIncome) {
        this.guarantor1MonthIncome = guarantor1MonthIncome;
    }

    public String getGuarantor1SettleInterest() {
        return guarantor1SettleInterest;
    }

    public void setGuarantor1SettleInterest(String guarantor1SettleInterest) {
        this.guarantor1SettleInterest = guarantor1SettleInterest;
    }

    public String getGuarantor1Balance() {
        return guarantor1Balance;
    }

    public void setGuarantor1Balance(String guarantor1Balance) {
        this.guarantor1Balance = guarantor1Balance;
    }

    public String getGuarantor1JourShowIncome() {
        return guarantor1JourShowIncome;
    }

    public void setGuarantor1JourShowIncome(String guarantor1JourShowIncome) {
        this.guarantor1JourShowIncome = guarantor1JourShowIncome;
    }

    public String getGuarantor1IsPrint() {
        return guarantor1IsPrint;
    }

    public void setGuarantor1IsPrint(String guarantor1IsPrint) {
        this.guarantor1IsPrint = guarantor1IsPrint;
    }

    public String getGuarantor2MonthIncome() {
        return guarantor2MonthIncome;
    }

    public void setGuarantor2MonthIncome(String guarantor2MonthIncome) {
        this.guarantor2MonthIncome = guarantor2MonthIncome;
    }

    public String getGuarantor2SettleInterest() {
        return guarantor2SettleInterest;
    }

    public void setGuarantor2SettleInterest(String guarantor2SettleInterest) {
        this.guarantor2SettleInterest = guarantor2SettleInterest;
    }

    public String getGuarantor2Balance() {
        return guarantor2Balance;
    }

    public void setGuarantor2Balance(String guarantor2Balance) {
        this.guarantor2Balance = guarantor2Balance;
    }

    public String getGuarantor2JourShowIncome() {
        return guarantor2JourShowIncome;
    }

    public void setGuarantor2JourShowIncome(String guarantor2JourShowIncome) {
        this.guarantor2JourShowIncome = guarantor2JourShowIncome;
    }

    public String getGuarantor2IsPrint() {
        return guarantor2IsPrint;
    }

    public void setGuarantor2IsPrint(String guarantor2IsPrint) {
        this.guarantor2IsPrint = guarantor2IsPrint;
    }

    public void setHousePic(String housePic) {
        this.housePic = housePic;
    }

    public String getHouseUnitPic() {
        return houseUnitPic;
    }

    public void setHouseUnitPic(String houseUnitPic) {
        this.houseUnitPic = houseUnitPic;
    }

    public String getHouseDoorPic() {
        return houseDoorPic;
    }

    public void setHouseDoorPic(String houseDoorPic) {
        this.houseDoorPic = houseDoorPic;
    }

    public String getHouseRoomPic() {
        return houseRoomPic;
    }

    public void setHouseRoomPic(String houseRoomPic) {
        this.houseRoomPic = houseRoomPic;
    }

    public String getHouseCustomerPic() {
        return houseCustomerPic;
    }

    public void setHouseCustomerPic(String houseCustomerPic) {
        this.houseCustomerPic = houseCustomerPic;
    }

    public String getHouseSaleCustomerPic() {
        return houseSaleCustomerPic;
    }

    public void setHouseSaleCustomerPic(String houseSaleCustomerPic) {
        this.houseSaleCustomerPic = houseSaleCustomerPic;
    }

    public String getCompanyNamePic() {
        return companyNamePic;
    }

    public void setCompanyNamePic(String companyNamePic) {
        this.companyNamePic = companyNamePic;
    }

    public String getCompanyPlacePic() {
        return companyPlacePic;
    }

    public void setCompanyPlacePic(String companyPlacePic) {
        this.companyPlacePic = companyPlacePic;
    }

    public String getCompanyWorkshopPic() {
        return companyWorkshopPic;
    }

    public void setCompanyWorkshopPic(String companyWorkshopPic) {
        this.companyWorkshopPic = companyWorkshopPic;
    }

    public String getCompanySaleCustomerPic() {
        return companySaleCustomerPic;
    }

    public void setCompanySaleCustomerPic(String companySaleCustomerPic) {
        this.companySaleCustomerPic = companySaleCustomerPic;
    }

    public String getSecondHgz() {
        return secondHgz;
    }

    public void setSecondHgz(String secondHgz) {
        this.secondHgz = secondHgz;
    }

    public String getSecondOdometer() {
        return secondOdometer;
    }

    public void setSecondOdometer(String secondOdometer) {
        this.secondOdometer = secondOdometer;
    }

    public String getSecondCarFrontPic() {
        return secondCarFrontPic;
    }

    public void setSecondCarFrontPic(String secondCarFrontPic) {
        this.secondCarFrontPic = secondCarFrontPic;
    }

    public String getSecondConsolePic() {
        return secondConsolePic;
    }

    public void setSecondConsolePic(String secondConsolePic) {
        this.secondConsolePic = secondConsolePic;
    }

    public String getSecond300Pdf() {
        return second300Pdf;
    }

    public void setSecond300Pdf(String second300Pdf) {
        this.second300Pdf = second300Pdf;
    }

    public String getSecondQxbPic() {
        return secondQxbPic;
    }

    public void setSecondQxbPic(String secondQxbPic) {
        this.secondQxbPic = secondQxbPic;
    }

    public String getSecondCarInPic() {
        return secondCarInPic;
    }

    public void setSecondCarInPic(String secondCarInPic) {
        this.secondCarInPic = secondCarInPic;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOtherFilePdf() {
        return otherFilePdf;
    }

    public void setOtherFilePdf(String otherFilePdf) {
        this.otherFilePdf = otherFilePdf;
    }

    public String getOtherApplyNote() {
        return otherApplyNote;
    }

    public void setOtherApplyNote(String otherApplyNote) {
        this.otherApplyNote = otherApplyNote;
    }

    public String getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(String applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

}
