package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 车贷档案补录
 * @author: silver 
 * @since: 2018年6月13日 下午1:54:31 
 * @history:
 */
public class XN632200Req {
    // 编号
    @NotBlank
    private String code;

    // 保险公司编号
    private String insuranceCompanyCode;

    // 车辆颜色
    private String carColor;

    // 交强险
    private String forceInsurance;

    // 商业险合计
    private String commerceInsurance;

    // 保险生效日期
    private String insuranceEffectDatetime;

    // 保险经办银行
    private String insuranceBank;

    // 登记证书号
    private String regCertificateCode;

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

    // 担保人1姓名
    private String guarantor1Name;

    // 担保人1手机
    private String guarantor1Mobile;

    // 担保人2姓名
    private String guarantor2Name;

    // 担保人2手机
    private String guarantor2Mobile;

    // 银行卡号
    @NotBlank
    private String bankCardNumber;

    // 对账单日
    @NotBlank
    private String billDatetime;

    // 银行还款日
    @NotBlank
    private String repayBankDate;

    // 首期还款金额
    @NotBlank
    private String repayFirstMonthAmount;

    // 首期还款日期
    @NotBlank
    private String repayFirstMonthDatetime;

    // 每期月供金额
    @NotBlank
    private String repayMonthAmount;

    // 身份证照片
    private String idNoPic;

    // 已入档清单
    private List<String> fileList;

    // 资料是否完善
    @NotBlank
    private String isComplete;

    // 存放位置
    private String storePlace;

    // 入档备注
    private String fileRemark;

    // 经办人
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepayBankDate() {
        return repayBankDate;
    }

    public void setRepayBankDate(String repayBankDate) {
        this.repayBankDate = repayBankDate;
    }

    public String getRepayFirstMonthAmount() {
        return repayFirstMonthAmount;
    }

    public void setRepayFirstMonthAmount(String repayFirstMonthAmount) {
        this.repayFirstMonthAmount = repayFirstMonthAmount;
    }

    public String getRepayFirstMonthDatetime() {
        return repayFirstMonthDatetime;
    }

    public void setRepayFirstMonthDatetime(String repayFirstMonthDatetime) {
        this.repayFirstMonthDatetime = repayFirstMonthDatetime;
    }

    public String getRepayMonthAmount() {
        return repayMonthAmount;
    }

    public void setRepayMonthAmount(String repayMonthAmount) {
        this.repayMonthAmount = repayMonthAmount;
    }

    public String getInsuranceCompanyCode() {
        return insuranceCompanyCode;
    }

    public void setInsuranceCompanyCode(String insuranceCompanyCode) {
        this.insuranceCompanyCode = insuranceCompanyCode;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getForceInsurance() {
        return forceInsurance;
    }

    public void setForceInsurance(String forceInsurance) {
        this.forceInsurance = forceInsurance;
    }

    public String getCommerceInsurance() {
        return commerceInsurance;
    }

    public void setCommerceInsurance(String commerceInsurance) {
        this.commerceInsurance = commerceInsurance;
    }

    public String getInsuranceEffectDatetime() {
        return insuranceEffectDatetime;
    }

    public void setInsuranceEffectDatetime(String insuranceEffectDatetime) {
        this.insuranceEffectDatetime = insuranceEffectDatetime;
    }

    public String getInsuranceBank() {
        return insuranceBank;
    }

    public void setInsuranceBank(String insuranceBank) {
        this.insuranceBank = insuranceBank;
    }

    public String getRegCertificateCode() {
        return regCertificateCode;
    }

    public void setRegCertificateCode(String regCertificateCode) {
        this.regCertificateCode = regCertificateCode;
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

    public String getGuarantor1Name() {
        return guarantor1Name;
    }

    public void setGuarantor1Name(String guarantor1Name) {
        this.guarantor1Name = guarantor1Name;
    }

    public String getGuarantor1Mobile() {
        return guarantor1Mobile;
    }

    public void setGuarantor1Mobile(String guarantor1Mobile) {
        this.guarantor1Mobile = guarantor1Mobile;
    }

    public String getGuarantor2Name() {
        return guarantor2Name;
    }

    public void setGuarantor2Name(String guarantor2Name) {
        this.guarantor2Name = guarantor2Name;
    }

    public String getGuarantor2Mobile() {
        return guarantor2Mobile;
    }

    public void setGuarantor2Mobile(String guarantor2Mobile) {
        this.guarantor2Mobile = guarantor2Mobile;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBillDatetime() {
        return billDatetime;
    }

    public void setBillDatetime(String billDatetime) {
        this.billDatetime = billDatetime;
    }

    public String getIdNoPic() {
        return idNoPic;
    }

    public void setIdNoPic(String idNoPic) {
        this.idNoPic = idNoPic;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    public String getStorePlace() {
        return storePlace;
    }

    public void setStorePlace(String storePlace) {
        this.storePlace = storePlace;
    }

    public String getFileRemark() {
        return fileRemark;
    }

    public void setFileRemark(String fileRemark) {
        this.fileRemark = fileRemark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
