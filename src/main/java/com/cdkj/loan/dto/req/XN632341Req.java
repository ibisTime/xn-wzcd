package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 续保
 * @author: silver 
 * @since: 2018年6月18日 上午11:13:16 
 * @history:
 */
public class XN632341Req {
    // 预算单编号
    @NotBlank
    private String code;

    // 保险公司编号
    @NotBlank
    private String insuranceCompanyCode;

    // 投保时间
    @NotBlank
    private String insuranceApplyDatetime;

    // 到期日期
    @NotBlank
    private String insuranceEndDatetime;

    // 交强险保单
    @NotBlank
    private String insuranceForcePdf;

    // 商业险保单
    @NotBlank
    private String insuranceBusinessPdf;

    // 续保说明
    @NotBlank
    private String insuranceNote;

    // 说明人
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

    public String getInsuranceApplyDatetime() {
        return insuranceApplyDatetime;
    }

    public void setInsuranceApplyDatetime(String insuranceApplyDatetime) {
        this.insuranceApplyDatetime = insuranceApplyDatetime;
    }

    public String getInsuranceEndDatetime() {
        return insuranceEndDatetime;
    }

    public void setInsuranceEndDatetime(String insuranceEndDatetime) {
        this.insuranceEndDatetime = insuranceEndDatetime;
    }

    public String getInsuranceForcePdf() {
        return insuranceForcePdf;
    }

    public void setInsuranceForcePdf(String insuranceForcePdf) {
        this.insuranceForcePdf = insuranceForcePdf;
    }

    public String getInsuranceBusinessPdf() {
        return insuranceBusinessPdf;
    }

    public void setInsuranceBusinessPdf(String insuranceBusinessPdf) {
        this.insuranceBusinessPdf = insuranceBusinessPdf;
    }

    public String getInsuranceNote() {
        return insuranceNote;
    }

    public void setInsuranceNote(String insuranceNote) {
        this.insuranceNote = insuranceNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
