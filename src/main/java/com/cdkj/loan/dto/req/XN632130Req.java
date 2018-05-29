package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-确认收款
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632130Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
}
