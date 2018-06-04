package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 预算单
 * @author: jiafr 
 * @since: 2018年5月29日 下午5:48:13 
 * @history:
 */
public class BudgetOrder extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 还款业务编号
    private String repayBizCode;

    // 贷款产品编号
    private String loanProductCode;

    // 产品名称
    private String loanProductName;

    // 贷款银行
    private String loanBank;

    // GPS费用
    private Long gpsFee;

    // 公证费
    private Long authFee;

    // 银行服务费
    private Long bankFee;

    // 公司服务费
    private Long companyFee;

    // 月供利率(%)
    private Double monthRate;

    // 征信单编号
    private String creditCode;

    // 业务种类(新车，二手车)
    private String bizType;

    // 贷款期数
    private String loanPeriod;

    // 开票单位
    private String invoiceCompany;

    // 品牌
    private String carBrand;

    // 车系
    private String carSeries;

    // 车型
    private String carModel;

    // 车辆照片
    private String carPic;

    // 合格证
    private String carHgzPic;

    // 合格证号
    private String carHgzNo;

    // 车架号
    private String carFrameNo;

    // 发动机号
    private String carEngineNo;

    // 市场指导价
    private Long originalPrice;

    // 开票价
    private Long invoicePrice;

    // 颜色
    private String carColor;

    // 月供保证金(履约保证金)
    private Long monthDeposit;

    // 首付金额
    private Long firstAmount;

    // 首付比例
    private Double firstRate;

    // 贷款金额
    private Long loanAmount;

    // 落户地点
    private String settleAddress;

    // 申请人编号(代注册回写)
    private String applyUserId;

    // 申请人姓名
    private String applyUserName;

    // 性别
    private String gender;

    // 婚姻状况
    private String marryState;

    // 民族
    private String nation;

    // 学历
    private String education;

    // 证件类型
    private String idKind;

    // 身份证号
    private String idNo;

    // 家庭人口
    private String familyNumber;

    // 手机号
    private String mobile;

    // 现居住地址
    private String nowAddress;

    // 邮编1
    private String postCode1;

    // 户口所在地
    private String residenceAddress;

    // 邮编2
    private String postCode2;

    // 家庭主要财产
    private String familyMainAsset;

    // 主要财产包括
    private String mainAssetInclude;

    // 主要收入来源
    private String mainIncome;

    // 工作单位名称
    private String workCompanyName;

    // 工作单位地址
    private String workCompanyAddress;

    // 单位性质
    private String workCompanyProperty;

    // 所属行业
    private String workBelongIndustry;

    // 职业
    private String workProfession;

    // 何时进入现单位工作
    private Date workDatetime;

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
    private Date mateZfbJourDatetimeStart;

    // 配偶支付宝流水时间止
    private Date mateZfbJourDatetimeEnd;

    // 配偶支付宝收入
    private Long mateZfbJourIncome;

    // 配偶支付宝支出
    private Long mateZfbJourExpend;

    // 配偶支付宝帐户余额
    private Long mateZfbJourBalance;

    // 配偶支付宝月均收入
    private Long mateZfbJourMonthIncome;

    // 配偶支付宝月均支出
    private Long mateZfbJourMonthExpend;

    // 配偶支付宝流水图片
    private String mateZfbJourPic;

    // 配偶支付宝流水备注
    private String mateZfbJourRemark;

    // 配偶微信流水时间起
    private Date mateWxJourDatetimeStart;

    // 配偶微信流水时间止
    private Date mateWxJourDatetimeEnd;

    // 配偶微信收入
    private Long mateWxJourIncome;

    // 配偶微信支出
    private Long mateWxJourExpend;

    // 配偶微信帐户余额
    private Long mateWxJourBalance;

    // 配偶微信月均收入
    private Long mateWxJourMonthIncome;

    // 配偶微信月均支出
    private Long mateWxJourMonthExpend;

    // 配偶微信流水图片
    private String mateWxJourPic;

    // 配偶微信流水备注
    private String mateWxJourRemark;

    // 配偶流水时间起
    private Date mateJourDatetimeStart;

    // 配偶流水时间止
    private Date mateJourDatetimeEnd;

    // 配偶收入
    private Long mateJourIncome;

    // 配偶支出
    private Long mateJourExpend;

    // 配偶帐户余额
    private Long mateJourBalance;

    // 配偶月均收入
    private Long mateJourMonthIncome;

    // 配偶月均支出
    private Long mateJourMonthExpend;

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
    private Date guaZfbJourDatetimeStart;

    // 担保人支付宝流水时间止
    private Date guaZfbJourDatetimeEnd;

    // 担保人支付宝收入
    private Long guaZfbJourIncome;

    // 担保人支付宝支出
    private Long guaZfbJourExpend;

    // 担保人支付宝帐户余额
    private Long guaZfbJourBalance;

    // 担保人支付宝月均收入
    private Long guaZfbJourMonthIncome;

    // 担保人支付宝月均支出
    private Long guaZfbJourMonthExpend;

    // 担保人支付宝流水图片
    private String guaZfbJourPic;

    // 担保人支付宝流水备注
    private String guaZfbJourRemark;

    // 担保人微信流水时间起
    private Date guaWxJourDatetimeStart;

    // 担保人微信流水时间止
    private Date guaWxJourDatetimeEnd;

    // 担保人微信收入
    private Long guaWxJourIncome;

    // 担保人微信支出
    private Long guaWxJourExpend;

    // 担保人微信帐户余额
    private Long guaWxJourBalance;

    // 担保人微信月均收入
    private Long guaWxJourMonthIncome;

    // 担保人微信月均支出
    private Long guaWxJourMonthExpend;

    // 担保人微信流水图片
    private String guaWxJourPic;

    // 担保人微信流水备注
    private String guaWxJourRemark;

    // 担保人流水时间起
    private Date guaJourDatetimeStart;

    // 担保人流水时间止
    private Date guaJourDatetimeEnd;

    // 担保人收入
    private Long guaJourIncome;

    // 担保人支出
    private Long guaJourExpend;

    // 担保人帐户余额
    private Long guaJourBalance;

    // 担保人月均收入
    private Long guaJourMonthIncome;

    // 担保人月均支出
    private Long guaJourMonthExpend;

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
    private Date zfbJourDatetimeStart;

    // 支付宝流水时间止
    private Date zfbJourDatetimeEnd;

    // 支付宝收入
    private Long zfbJourIncome;

    // 支付宝支出
    private Long zfbJourExpend;

    // 支付宝帐户余额
    private Long zfbJourBalance;

    // 支付宝月均收入
    private Long zfbJourMonthIncome;

    // 支付宝月均支出
    private Long zfbJourMonthExpend;

    // 支付宝流水图片
    private String zfbJourPic;

    // 支付宝流水备注
    private String zfbJourRemark;

    // 微信流水时间起
    private Date wxJourDatetimeStart;

    // 微信流水时间止
    private Date wxJourDatetimeEnd;

    // 微信收入
    private Long wxJourIncome;

    // 微信支出
    private Long wxJourExpend;

    // 微信帐户余额
    private Long wxJourBalance;

    // 微信月均收入
    private Long wxJourMonthIncome;

    // 微信月均支出
    private Long wxJourMonthExpend;

    // 微信流水图片
    private String wxJourPic;

    // 微信流水备注
    private String wxJourRemark;

    // 流水时间起
    private Date jourDatetimeStart;

    // 流水时间止
    private Date jourDatetimeEnd;

    // 收入
    private Long jourIncome;

    // 支出
    private Long jourExpend;

    // 帐户余额
    private Long jourBalance;

    // 月均收入
    private Long jourMonthIncome;

    // 月均支出
    private Long jourMonthExpend;

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

    // 是否垫资
    private String isAdvanceFund;

    // 面签视频
    private String interviewVideo;

    // 面签合同
    private String interviewContract;

    // 垫资日期
    private Date advanceFundDatetime;

    // 垫资金额
    private Long advanceFundAmount;

    // 水单
    private String billPdf;

    // 车辆落户日期
    private Date carSettleDatetime;

    // 车牌号
    private String carNumber;

    // 发票
    private String carInvoice;

    // 合格证
    private String carHgz;

    // 交强险
    private String carJqx;

    // 商业险
    private String carSyx;

    // 登记证书
    private String carRegcerti;

    // 车辆批单
    private String carPd;

    // 车钥匙
    private String carKey;

    // 大本扫描件
    private String carBigSmj;

    // 银行提交时间
    private Date bankCommitDatetime;

    // 银行提交说明
    private String bankCommitNote;

    // 还款卡银行行别
    private String repayBankCode;

    // 还款卡银行名称
    private String repayBankName;

    // 还款卡开户支行
    private String repaySubbranch;

    // 还款卡号
    private String repayBankcardNumber;

    // 银行账单日
    private int repayBillDate;

    // 银行还款日
    private int repayBankDate;

    // 公司还款日
    private Date repayCompanyDate;

    // 首期月供金额
    private Long repayFirstMonthAmount;

    // 首期还款日期
    private Date repayFirstMonthDatetime;

    // 每期月供金额
    private Long repayMonthAmount;

    // 银行放款日期
    private Date bankFkDatetime;

    // 收款银行
    private String receiptBankCode;

    // 收款银行名称
    private String receiptBankName;

    // 收款银行卡号
    private String receiptBankcardNumber;

    // 收款凭证
    private String receiptPdf;

    // 收款备注
    private String receiptRemark;

    // 抵押日期
    private Date pledgeDatetime;

    // 绿大本扫描件
    private String greenBigSmj;

    // 抵押提交银行时间
    private Date pledgeBankCommitDatetime;

    // 抵押提交说明
    private String pledgeBankCommitNote;

    // 入档位置
    private String enterLocation;

    // 业务员
    private String saleUserId;

    // 业务公司编号
    private String companyCode;

    // 申请时间
    private Date applyDatetime;

    // 当前节点编号
    private String curNodeCode;

    // 最新备注
    private String remark;

    /*---------辅助字段----------*/
    // 申请时间起始
    private Date applyDatetimeStart;

    // 申请时间结束
    private Date applyDatetimeEnd;

    // 角色编号
    private String roleCode;

    // gps安装列表
    private List<BudgetOrderGps> budgetOrderGpsList;

    // 征信列表
    private Credit credit;

    // 公司名称
    private String companyName;

    // 业务员姓名
    private String saleUserName;

    // 贷款银行名称
    private String loanBankName;

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public String getSaleUserName() {
        return saleUserName;
    }

    public void setSaleUserName(String saleUserName) {
        this.saleUserName = saleUserName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<BudgetOrderGps> getBudgetOrderGpsList() {
        return budgetOrderGpsList;
    }

    public void setBudgetOrderGpsList(List<BudgetOrderGps> budgetOrderGpsList) {
        this.budgetOrderGpsList = budgetOrderGpsList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getLoanProductCode() {
        return loanProductCode;
    }

    public void setLoanProductCode(String loanProductCode) {
        this.loanProductCode = loanProductCode;
    }

    public String getLoanProductName() {
        return loanProductName;
    }

    public void setLoanProductName(String loanProductName) {
        this.loanProductName = loanProductName;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public Long getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(Long gpsFee) {
        this.gpsFee = gpsFee;
    }

    public Long getAuthFee() {
        return authFee;
    }

    public void setAuthFee(Long authFee) {
        this.authFee = authFee;
    }

    public Long getBankFee() {
        return bankFee;
    }

    public void setBankFee(Long bankFee) {
        this.bankFee = bankFee;
    }

    public Long getCompanyFee() {
        return companyFee;
    }

    public void setCompanyFee(Long companyFee) {
        this.companyFee = companyFee;
    }

    public Double getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(Double monthRate) {
        this.monthRate = monthRate;
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

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Long invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Long getMonthDeposit() {
        return monthDeposit;
    }

    public void setMonthDeposit(Long monthDeposit) {
        this.monthDeposit = monthDeposit;
    }

    public Long getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Long firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Double getFirstRate() {
        return firstRate;
    }

    public void setFirstRate(Double firstRate) {
        this.firstRate = firstRate;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getSettleAddress() {
        return settleAddress;
    }

    public void setSettleAddress(String settleAddress) {
        this.settleAddress = settleAddress;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
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

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
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

    public Date getJourDatetimeStart() {
        return jourDatetimeStart;
    }

    public void setJourDatetimeStart(Date jourDatetimeStart) {
        this.jourDatetimeStart = jourDatetimeStart;
    }

    public Date getJourDatetimeEnd() {
        return jourDatetimeEnd;
    }

    public void setJourDatetimeEnd(Date jourDatetimeEnd) {
        this.jourDatetimeEnd = jourDatetimeEnd;
    }

    public Long getJourIncome() {
        return jourIncome;
    }

    public void setJourIncome(Long jourIncome) {
        this.jourIncome = jourIncome;
    }

    public Long getJourExpend() {
        return jourExpend;
    }

    public void setJourExpend(Long jourExpend) {
        this.jourExpend = jourExpend;
    }

    public Long getJourBalance() {
        return jourBalance;
    }

    public void setJourBalance(Long jourBalance) {
        this.jourBalance = jourBalance;
    }

    public Long getJourMonthIncome() {
        return jourMonthIncome;
    }

    public void setJourMonthIncome(Long jourMonthIncome) {
        this.jourMonthIncome = jourMonthIncome;
    }

    public Long getJourMonthExpend() {
        return jourMonthExpend;
    }

    public void setJourMonthExpend(Long jourMonthExpend) {
        this.jourMonthExpend = jourMonthExpend;
    }

    public String getJourRemark() {
        return jourRemark;
    }

    public void setJourRemark(String jourRemark) {
        this.jourRemark = jourRemark;
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

    public String getInterviewVideo() {
        return interviewVideo;
    }

    public void setInterviewVideo(String interviewVideo) {
        this.interviewVideo = interviewVideo;
    }

    public String getInterviewContract() {
        return interviewContract;
    }

    public void setInterviewContract(String interviewContract) {
        this.interviewContract = interviewContract;
    }

    public Date getAdvanceFundDatetime() {
        return advanceFundDatetime;
    }

    public void setAdvanceFundDatetime(Date advanceFundDatetime) {
        this.advanceFundDatetime = advanceFundDatetime;
    }

    public Long getAdvanceFundAmount() {
        return advanceFundAmount;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public void setAdvanceFundAmount(Long advanceFundAmount) {
        this.advanceFundAmount = advanceFundAmount;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public Date getCarSettleDatetime() {
        return carSettleDatetime;
    }

    public void setCarSettleDatetime(Date carSettleDatetime) {
        this.carSettleDatetime = carSettleDatetime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarInvoice() {
        return carInvoice;
    }

    public void setCarInvoice(String carInvoice) {
        this.carInvoice = carInvoice;
    }

    public String getCarHgz() {
        return carHgz;
    }

    public void setCarHgz(String carHgz) {
        this.carHgz = carHgz;
    }

    public String getCarJqx() {
        return carJqx;
    }

    public void setCarJqx(String carJqx) {
        this.carJqx = carJqx;
    }

    public String getCarSyx() {
        return carSyx;
    }

    public void setCarSyx(String carSyx) {
        this.carSyx = carSyx;
    }

    public String getCarRegcerti() {
        return carRegcerti;
    }

    public void setCarRegcerti(String carRegcerti) {
        this.carRegcerti = carRegcerti;
    }

    public String getCarPd() {
        return carPd;
    }

    public void setCarPd(String carPd) {
        this.carPd = carPd;
    }

    public String getCarKey() {
        return carKey;
    }

    public void setCarKey(String carKey) {
        this.carKey = carKey;
    }

    public String getCarBigSmj() {
        return carBigSmj;
    }

    public void setCarBigSmj(String carBigSmj) {
        this.carBigSmj = carBigSmj;
    }

    public Date getBankCommitDatetime() {
        return bankCommitDatetime;
    }

    public void setBankCommitDatetime(Date bankCommitDatetime) {
        this.bankCommitDatetime = bankCommitDatetime;
    }

    public String getBankCommitNote() {
        return bankCommitNote;
    }

    public void setBankCommitNote(String bankCommitNote) {
        this.bankCommitNote = bankCommitNote;
    }

    public String getRepayBankCode() {
        return repayBankCode;
    }

    public void setRepayBankCode(String repayBankCode) {
        this.repayBankCode = repayBankCode;
    }

    public String getRepayBankName() {
        return repayBankName;
    }

    public void setRepayBankName(String repayBankName) {
        this.repayBankName = repayBankName;
    }

    public String getRepaySubbranch() {
        return repaySubbranch;
    }

    public void setRepaySubbranch(String repaySubbranch) {
        this.repaySubbranch = repaySubbranch;
    }

    public String getRepayBankcardNumber() {
        return repayBankcardNumber;
    }

    public void setRepayBankcardNumber(String repayBankcardNumber) {
        this.repayBankcardNumber = repayBankcardNumber;
    }

    public int getRepayBillDate() {
        return repayBillDate;
    }

    public void setRepayBillDate(int repayBillDate) {
        this.repayBillDate = repayBillDate;
    }

    public int getRepayBankDate() {
        return repayBankDate;
    }

    public void setRepayBankDate(int repayBankDate) {
        this.repayBankDate = repayBankDate;
    }

    public Date getRepayCompanyDate() {
        return repayCompanyDate;
    }

    public void setRepayCompanyDate(Date repayCompanyDate) {
        this.repayCompanyDate = repayCompanyDate;
    }

    public Long getRepayFirstMonthAmount() {
        return repayFirstMonthAmount;
    }

    public void setRepayFirstMonthAmount(Long repayFirstMonthAmount) {
        this.repayFirstMonthAmount = repayFirstMonthAmount;
    }

    public Date getRepayFirstMonthDatetime() {
        return repayFirstMonthDatetime;
    }

    public void setRepayFirstMonthDatetime(Date repayFirstMonthDatetime) {
        this.repayFirstMonthDatetime = repayFirstMonthDatetime;
    }

    public Long getRepayMonthAmount() {
        return repayMonthAmount;
    }

    public void setRepayMonthAmount(Long repayMonthAmount) {
        this.repayMonthAmount = repayMonthAmount;
    }

    public Date getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankFkDatetime(Date bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
    }

    public String getReceiptBankCode() {
        return receiptBankCode;
    }

    public void setReceiptBankCode(String receiptBankCode) {
        this.receiptBankCode = receiptBankCode;
    }

    public String getReceiptBankName() {
        return receiptBankName;
    }

    public void setReceiptBankName(String receiptBankName) {
        this.receiptBankName = receiptBankName;
    }

    public String getReceiptBankcardNumber() {
        return receiptBankcardNumber;
    }

    public void setReceiptBankcardNumber(String receiptBankcardNumber) {
        this.receiptBankcardNumber = receiptBankcardNumber;
    }

    public String getReceiptPdf() {
        return receiptPdf;
    }

    public void setReceiptPdf(String receiptPdf) {
        this.receiptPdf = receiptPdf;
    }

    public String getReceiptRemark() {
        return receiptRemark;
    }

    public void setReceiptRemark(String receiptRemark) {
        this.receiptRemark = receiptRemark;
    }

    public Date getPledgeDatetime() {
        return pledgeDatetime;
    }

    public void setPledgeDatetime(Date pledgeDatetime) {
        this.pledgeDatetime = pledgeDatetime;
    }

    public String getGreenBigSmj() {
        return greenBigSmj;
    }

    public void setGreenBigSmj(String greenBigSmj) {
        this.greenBigSmj = greenBigSmj;
    }

    public Date getPledgeBankCommitDatetime() {
        return pledgeBankCommitDatetime;
    }

    public void setPledgeBankCommitDatetime(Date pledgeBankCommitDatetime) {
        this.pledgeBankCommitDatetime = pledgeBankCommitDatetime;
    }

    public String getPledgeBankCommitNote() {
        return pledgeBankCommitNote;
    }

    public void setPledgeBankCommitNote(String pledgeBankCommitNote) {
        this.pledgeBankCommitNote = pledgeBankCommitNote;
    }

    public String getEnterLocation() {
        return enterLocation;
    }

    public void setEnterLocation(String enterLocation) {
        this.enterLocation = enterLocation;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
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

    public Date getMateZfbJourDatetimeStart() {
        return mateZfbJourDatetimeStart;
    }

    public void setMateZfbJourDatetimeStart(Date mateZfbJourDatetimeStart) {
        this.mateZfbJourDatetimeStart = mateZfbJourDatetimeStart;
    }

    public Date getMateZfbJourDatetimeEnd() {
        return mateZfbJourDatetimeEnd;
    }

    public void setMateZfbJourDatetimeEnd(Date mateZfbJourDatetimeEnd) {
        this.mateZfbJourDatetimeEnd = mateZfbJourDatetimeEnd;
    }

    public Long getMateZfbJourIncome() {
        return mateZfbJourIncome;
    }

    public void setMateZfbJourIncome(Long mateZfbJourIncome) {
        this.mateZfbJourIncome = mateZfbJourIncome;
    }

    public Long getMateZfbJourExpend() {
        return mateZfbJourExpend;
    }

    public void setMateZfbJourExpend(Long mateZfbJourExpend) {
        this.mateZfbJourExpend = mateZfbJourExpend;
    }

    public Long getMateZfbJourBalance() {
        return mateZfbJourBalance;
    }

    public void setMateZfbJourBalance(Long mateZfbJourBalance) {
        this.mateZfbJourBalance = mateZfbJourBalance;
    }

    public Long getMateZfbJourMonthIncome() {
        return mateZfbJourMonthIncome;
    }

    public void setMateZfbJourMonthIncome(Long mateZfbJourMonthIncome) {
        this.mateZfbJourMonthIncome = mateZfbJourMonthIncome;
    }

    public Long getMateZfbJourMonthExpend() {
        return mateZfbJourMonthExpend;
    }

    public void setMateZfbJourMonthExpend(Long mateZfbJourMonthExpend) {
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

    public Date getMateWxJourDatetimeStart() {
        return mateWxJourDatetimeStart;
    }

    public void setMateWxJourDatetimeStart(Date mateWxJourDatetimeStart) {
        this.mateWxJourDatetimeStart = mateWxJourDatetimeStart;
    }

    public Date getMateWxJourDatetimeEnd() {
        return mateWxJourDatetimeEnd;
    }

    public void setMateWxJourDatetimeEnd(Date mateWxJourDatetimeEnd) {
        this.mateWxJourDatetimeEnd = mateWxJourDatetimeEnd;
    }

    public Long getMateWxJourIncome() {
        return mateWxJourIncome;
    }

    public void setMateWxJourIncome(Long mateWxJourIncome) {
        this.mateWxJourIncome = mateWxJourIncome;
    }

    public Long getMateWxJourExpend() {
        return mateWxJourExpend;
    }

    public void setMateWxJourExpend(Long mateWxJourExpend) {
        this.mateWxJourExpend = mateWxJourExpend;
    }

    public Long getMateWxJourBalance() {
        return mateWxJourBalance;
    }

    public void setMateWxJourBalance(Long mateWxJourBalance) {
        this.mateWxJourBalance = mateWxJourBalance;
    }

    public Long getMateWxJourMonthIncome() {
        return mateWxJourMonthIncome;
    }

    public void setMateWxJourMonthIncome(Long mateWxJourMonthIncome) {
        this.mateWxJourMonthIncome = mateWxJourMonthIncome;
    }

    public Long getMateWxJourMonthExpend() {
        return mateWxJourMonthExpend;
    }

    public void setMateWxJourMonthExpend(Long mateWxJourMonthExpend) {
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

    public Date getMateJourDatetimeStart() {
        return mateJourDatetimeStart;
    }

    public void setMateJourDatetimeStart(Date mateJourDatetimeStart) {
        this.mateJourDatetimeStart = mateJourDatetimeStart;
    }

    public Date getMateJourDatetimeEnd() {
        return mateJourDatetimeEnd;
    }

    public void setMateJourDatetimeEnd(Date mateJourDatetimeEnd) {
        this.mateJourDatetimeEnd = mateJourDatetimeEnd;
    }

    public Long getMateJourIncome() {
        return mateJourIncome;
    }

    public void setMateJourIncome(Long mateJourIncome) {
        this.mateJourIncome = mateJourIncome;
    }

    public Long getMateJourExpend() {
        return mateJourExpend;
    }

    public void setMateJourExpend(Long mateJourExpend) {
        this.mateJourExpend = mateJourExpend;
    }

    public Long getMateJourBalance() {
        return mateJourBalance;
    }

    public void setMateJourBalance(Long mateJourBalance) {
        this.mateJourBalance = mateJourBalance;
    }

    public Long getMateJourMonthIncome() {
        return mateJourMonthIncome;
    }

    public void setMateJourMonthIncome(Long mateJourMonthIncome) {
        this.mateJourMonthIncome = mateJourMonthIncome;
    }

    public Long getMateJourMonthExpend() {
        return mateJourMonthExpend;
    }

    public void setMateJourMonthExpend(Long mateJourMonthExpend) {
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

    public Date getGuaZfbJourDatetimeStart() {
        return guaZfbJourDatetimeStart;
    }

    public void setGuaZfbJourDatetimeStart(Date guaZfbJourDatetimeStart) {
        this.guaZfbJourDatetimeStart = guaZfbJourDatetimeStart;
    }

    public Date getGuaZfbJourDatetimeEnd() {
        return guaZfbJourDatetimeEnd;
    }

    public void setGuaZfbJourDatetimeEnd(Date guaZfbJourDatetimeEnd) {
        this.guaZfbJourDatetimeEnd = guaZfbJourDatetimeEnd;
    }

    public Long getGuaZfbJourIncome() {
        return guaZfbJourIncome;
    }

    public void setGuaZfbJourIncome(Long guaZfbJourIncome) {
        this.guaZfbJourIncome = guaZfbJourIncome;
    }

    public Long getGuaZfbJourExpend() {
        return guaZfbJourExpend;
    }

    public void setGuaZfbJourExpend(Long guaZfbJourExpend) {
        this.guaZfbJourExpend = guaZfbJourExpend;
    }

    public Long getGuaZfbJourBalance() {
        return guaZfbJourBalance;
    }

    public void setGuaZfbJourBalance(Long guaZfbJourBalance) {
        this.guaZfbJourBalance = guaZfbJourBalance;
    }

    public Long getGuaZfbJourMonthIncome() {
        return guaZfbJourMonthIncome;
    }

    public void setGuaZfbJourMonthIncome(Long guaZfbJourMonthIncome) {
        this.guaZfbJourMonthIncome = guaZfbJourMonthIncome;
    }

    public Long getGuaZfbJourMonthExpend() {
        return guaZfbJourMonthExpend;
    }

    public void setGuaZfbJourMonthExpend(Long guaZfbJourMonthExpend) {
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

    public Date getGuaWxJourDatetimeStart() {
        return guaWxJourDatetimeStart;
    }

    public void setGuaWxJourDatetimeStart(Date guaWxJourDatetimeStart) {
        this.guaWxJourDatetimeStart = guaWxJourDatetimeStart;
    }

    public Date getGuaWxJourDatetimeEnd() {
        return guaWxJourDatetimeEnd;
    }

    public void setGuaWxJourDatetimeEnd(Date guaWxJourDatetimeEnd) {
        this.guaWxJourDatetimeEnd = guaWxJourDatetimeEnd;
    }

    public Long getGuaWxJourIncome() {
        return guaWxJourIncome;
    }

    public void setGuaWxJourIncome(Long guaWxJourIncome) {
        this.guaWxJourIncome = guaWxJourIncome;
    }

    public Long getGuaWxJourExpend() {
        return guaWxJourExpend;
    }

    public void setGuaWxJourExpend(Long guaWxJourExpend) {
        this.guaWxJourExpend = guaWxJourExpend;
    }

    public Long getGuaWxJourBalance() {
        return guaWxJourBalance;
    }

    public void setGuaWxJourBalance(Long guaWxJourBalance) {
        this.guaWxJourBalance = guaWxJourBalance;
    }

    public Long getGuaWxJourMonthIncome() {
        return guaWxJourMonthIncome;
    }

    public void setGuaWxJourMonthIncome(Long guaWxJourMonthIncome) {
        this.guaWxJourMonthIncome = guaWxJourMonthIncome;
    }

    public Long getGuaWxJourMonthExpend() {
        return guaWxJourMonthExpend;
    }

    public void setGuaWxJourMonthExpend(Long guaWxJourMonthExpend) {
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

    public Date getGuaJourDatetimeStart() {
        return guaJourDatetimeStart;
    }

    public void setGuaJourDatetimeStart(Date guaJourDatetimeStart) {
        this.guaJourDatetimeStart = guaJourDatetimeStart;
    }

    public Date getGuaJourDatetimeEnd() {
        return guaJourDatetimeEnd;
    }

    public void setGuaJourDatetimeEnd(Date guaJourDatetimeEnd) {
        this.guaJourDatetimeEnd = guaJourDatetimeEnd;
    }

    public Long getGuaJourIncome() {
        return guaJourIncome;
    }

    public void setGuaJourIncome(Long guaJourIncome) {
        this.guaJourIncome = guaJourIncome;
    }

    public Long getGuaJourExpend() {
        return guaJourExpend;
    }

    public void setGuaJourExpend(Long guaJourExpend) {
        this.guaJourExpend = guaJourExpend;
    }

    public Long getGuaJourBalance() {
        return guaJourBalance;
    }

    public void setGuaJourBalance(Long guaJourBalance) {
        this.guaJourBalance = guaJourBalance;
    }

    public Long getGuaJourMonthIncome() {
        return guaJourMonthIncome;
    }

    public void setGuaJourMonthIncome(Long guaJourMonthIncome) {
        this.guaJourMonthIncome = guaJourMonthIncome;
    }

    public Long getGuaJourMonthExpend() {
        return guaJourMonthExpend;
    }

    public void setGuaJourMonthExpend(Long guaJourMonthExpend) {
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

    public Date getZfbJourDatetimeStart() {
        return zfbJourDatetimeStart;
    }

    public void setZfbJourDatetimeStart(Date zfbJourDatetimeStart) {
        this.zfbJourDatetimeStart = zfbJourDatetimeStart;
    }

    public Date getZfbJourDatetimeEnd() {
        return zfbJourDatetimeEnd;
    }

    public void setZfbJourDatetimeEnd(Date zfbJourDatetimeEnd) {
        this.zfbJourDatetimeEnd = zfbJourDatetimeEnd;
    }

    public Long getZfbJourIncome() {
        return zfbJourIncome;
    }

    public void setZfbJourIncome(Long zfbJourIncome) {
        this.zfbJourIncome = zfbJourIncome;
    }

    public Long getZfbJourExpend() {
        return zfbJourExpend;
    }

    public void setZfbJourExpend(Long zfbJourExpend) {
        this.zfbJourExpend = zfbJourExpend;
    }

    public Long getZfbJourBalance() {
        return zfbJourBalance;
    }

    public void setZfbJourBalance(Long zfbJourBalance) {
        this.zfbJourBalance = zfbJourBalance;
    }

    public Long getZfbJourMonthIncome() {
        return zfbJourMonthIncome;
    }

    public void setZfbJourMonthIncome(Long zfbJourMonthIncome) {
        this.zfbJourMonthIncome = zfbJourMonthIncome;
    }

    public Long getZfbJourMonthExpend() {
        return zfbJourMonthExpend;
    }

    public void setZfbJourMonthExpend(Long zfbJourMonthExpend) {
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

    public Date getWxJourDatetimeStart() {
        return wxJourDatetimeStart;
    }

    public void setWxJourDatetimeStart(Date wxJourDatetimeStart) {
        this.wxJourDatetimeStart = wxJourDatetimeStart;
    }

    public Date getWxJourDatetimeEnd() {
        return wxJourDatetimeEnd;
    }

    public void setWxJourDatetimeEnd(Date wxJourDatetimeEnd) {
        this.wxJourDatetimeEnd = wxJourDatetimeEnd;
    }

    public Long getWxJourIncome() {
        return wxJourIncome;
    }

    public void setWxJourIncome(Long wxJourIncome) {
        this.wxJourIncome = wxJourIncome;
    }

    public Long getWxJourExpend() {
        return wxJourExpend;
    }

    public void setWxJourExpend(Long wxJourExpend) {
        this.wxJourExpend = wxJourExpend;
    }

    public Long getWxJourBalance() {
        return wxJourBalance;
    }

    public void setWxJourBalance(Long wxJourBalance) {
        this.wxJourBalance = wxJourBalance;
    }

    public Long getWxJourMonthIncome() {
        return wxJourMonthIncome;
    }

    public void setWxJourMonthIncome(Long wxJourMonthIncome) {
        this.wxJourMonthIncome = wxJourMonthIncome;
    }

    public Long getWxJourMonthExpend() {
        return wxJourMonthExpend;
    }

    public void setWxJourMonthExpend(Long wxJourMonthExpend) {
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

    public Date getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(Date workDatetime) {
        this.workDatetime = workDatetime;
    }

}
