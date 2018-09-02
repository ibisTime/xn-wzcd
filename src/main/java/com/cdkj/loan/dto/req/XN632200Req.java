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
    @NotBlank(message = "商业险合计不能为空")
    private String commerceInsurance;

    // 保险生效日期
    private String insuranceEffectDatetime;

    // 保险经办银行
    private String insuranceBank;

    // 登记证书号
    private String regCertificateCode;

    // 担保人1姓名
    private String guarantor1Name;

    // 担保人1手机
    private String guarantor1Mobile;

    // 担保人2姓名
    private String guarantor2Name;

    // 担保人2手机
    private String guarantor2Mobile;

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
