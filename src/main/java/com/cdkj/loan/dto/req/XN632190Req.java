package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 车贷档案补录
 * @author: silver 
 * @since: 2018年6月13日 下午1:54:31 
 * @history:
 */
public class XN632190Req {
    // 编号
    @NotBlank
    private String code;

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

    // 交强险
    private String forceInsurance;

    // 商业险合计
    private String commerceInsurance;

    // 保险生效日期
    private String insuranceEffectDatetime;

    // 保险经办银行
    private String insuranceBank;

    // 业务员编号
    private String saleUserId;

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
    private List<String> fileList;

    // 资料是否完善
    @NotBlank
    private String isComplete;

    // 存放位置
    private String storePlace;

    // 入档备注
    private String fileRemark;

    // 经办人
    @NotBlank
    private String operator;

    // 经办部门
    @NotBlank
    private String operateDepartment;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
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

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getGuaranteeContractCode() {
        return guaranteeContractCode;
    }

    public void setGuaranteeContractCode(String guaranteeContractCode) {
        this.guaranteeContractCode = guaranteeContractCode;
    }

    public String getRegCertificateCode() {
        return regCertificateCode;
    }

    public void setRegCertificateCode(String regCertificateCode) {
        this.regCertificateCode = regCertificateCode;
    }

    public String getOtherContact() {
        return otherContact;
    }

    public void setOtherContact(String otherContact) {
        this.otherContact = otherContact;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getGuarantorName() {
        return guarantorName;
    }

    public void setGuarantorName(String guarantorName) {
        this.guarantorName = guarantorName;
    }

    public String getGuarantorMobile() {
        return guarantorMobile;
    }

    public void setGuarantorMobile(String guarantorMobile) {
        this.guarantorMobile = guarantorMobile;
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

    public String getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(String monthAmount) {
        this.monthAmount = monthAmount;
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

    public String getOperateDepartment() {
        return operateDepartment;
    }

    public void setOperateDepartment(String operateDepartment) {
        this.operateDepartment = operateDepartment;
    }

}
