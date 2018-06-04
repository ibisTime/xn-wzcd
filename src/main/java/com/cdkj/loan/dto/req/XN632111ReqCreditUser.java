package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 录入征信结果（征信人员）
 * @author: jiafr 
 * @since: 2018年5月25日 下午10:23:09 
 * @history:
 */
public class XN632111ReqCreditUser {

    // 征信人员编号
    @NotBlank
    private String creditUserCode;

    // 银行征信结果
    @NotBlank
    private String bankCreditResultPdf;

    // 银行征信结果说明
    @NotBlank
    private String bankCreditResultRemark;

    public String getCreditUserCode() {
        return creditUserCode;
    }

    public void setCreditUserCode(String creditUserCode) {
        this.creditUserCode = creditUserCode;
    }

    public String getBankCreditResultPdf() {
        return bankCreditResultPdf;
    }

    public void setBankCreditResultPdf(String bankCreditResultPdf) {
        this.bankCreditResultPdf = bankCreditResultPdf;
    }

    public String getBankCreditResultRemark() {
        return bankCreditResultRemark;
    }

    public void setBankCreditResultRemark(String bankCreditResultRemark) {
        this.bankCreditResultRemark = bankCreditResultRemark;
    }

}
