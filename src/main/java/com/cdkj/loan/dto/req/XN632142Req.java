package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 银行放款合同打印
 * @author: CYL 
 * @since: 2018年6月30日 下午1:04:40 
 * @history:
 */
public class XN632142Req {

    // 预算单编号
    @NotBlank
    private String code;

    // 邮政编码
    @NotBlank
    private String postcode;

    // 家庭电话
    private String familyPhone;

    // 申请人就职单位电话
    private String applyUserCompanyPhone;

    // 共还人电话
    private String ghMobile;

    // 共还人公司名称
    private String ghCompanyName;

    // 品牌型号
    private String carBrandModel;

    // 车牌号码
    private String carNumber;

    // 期限
    private String guarantContractDeadline;

    // 月费率
    private String guarantMonthFeeRate;

    // 担保人现住址
    private String guarantorNowAddress;

    // 担保人家庭电话
    private String guarantorFamilyPhone;

    // 担保人单位
    private String guarantorCompanyName;

    // 担保人就职单位电话
    private String guarantorCompanyPhone;

    // 担保人就职单位地址
    private String guarantorCompanyAddress;

    // 承保公司
    private String insuranceCompany;

    // 担保客户说明
    private String guarantApplyUserNote;

    // 套打模板
    @NotBlank
    private String guarantPrintTemplateId;

    // 操作人
    @NotBlank
    private String operater;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getGuarantorNowAddress() {
        return guarantorNowAddress;
    }

    public void setGuarantorNowAddress(String guarantorNowAddress) {
        this.guarantorNowAddress = guarantorNowAddress;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getApplyUserCompanyPhone() {
        return applyUserCompanyPhone;
    }

    public void setApplyUserCompanyPhone(String applyUserCompanyPhone) {
        this.applyUserCompanyPhone = applyUserCompanyPhone;
    }

    public String getCarBrandModel() {
        return carBrandModel;
    }

    public void setCarBrandModel(String carBrandModel) {
        this.carBrandModel = carBrandModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getGuarantContractDeadline() {
        return guarantContractDeadline;
    }

    public void setGuarantContractDeadline(String guarantContractDeadline) {
        this.guarantContractDeadline = guarantContractDeadline;
    }

    public String getGuarantMonthFeeRate() {
        return guarantMonthFeeRate;
    }

    public void setGuarantMonthFeeRate(String guarantMonthFeeRate) {
        this.guarantMonthFeeRate = guarantMonthFeeRate;
    }

    public String getGuarantorFamilyPhone() {
        return guarantorFamilyPhone;
    }

    public void setGuarantorFamilyPhone(String guarantorFamilyPhone) {
        this.guarantorFamilyPhone = guarantorFamilyPhone;
    }

    public String getGuarantorCompanyName() {
        return guarantorCompanyName;
    }

    public void setGuarantorCompanyName(String guarantorCompanyName) {
        this.guarantorCompanyName = guarantorCompanyName;
    }

    public String getGuarantorCompanyPhone() {
        return guarantorCompanyPhone;
    }

    public void setGuarantorCompanyPhone(String guarantorCompanyPhone) {
        this.guarantorCompanyPhone = guarantorCompanyPhone;
    }

    public String getGuarantorCompanyAddress() {
        return guarantorCompanyAddress;
    }

    public void setGuarantorCompanyAddress(String guarantorCompanyAddress) {
        this.guarantorCompanyAddress = guarantorCompanyAddress;
    }

    public String getGhMobile() {
        return ghMobile;
    }

    public void setGhMobile(String ghMobile) {
        this.ghMobile = ghMobile;
    }

    public String getGhCompanyName() {
        return ghCompanyName;
    }

    public void setGhCompanyName(String ghCompanyName) {
        this.ghCompanyName = ghCompanyName;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getGuarantApplyUserNote() {
        return guarantApplyUserNote;
    }

    public void setGuarantApplyUserNote(String guarantApplyUserNote) {
        this.guarantApplyUserNote = guarantApplyUserNote;
    }

    public String getGuarantPrintTemplateId() {
        return guarantPrintTemplateId;
    }

    public void setGuarantPrintTemplateId(String guarantPrintTemplateId) {
        this.guarantPrintTemplateId = guarantPrintTemplateId;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

}
