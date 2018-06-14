package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认银行放款
 * @author: silver 
 * @since: 2018年6月13日 下午1:35:51 
 * @history:
 */
public class XN632141Req {
    // 编号
    @NotBlank
    private String code;

    // 银行放款金额
    @NotBlank
    private String bankFkAmount;

    // 银行放款时间
    @NotBlank
    private String bankFkDatetime;

    // 收款银行
    @NotBlank
    private String bankReceiptCode;

    // 收款银行账号
    @NotBlank
    private String bankReceiptNumber;

    // 收款凭证
    @NotBlank
    private String bankReceiptPdf;

    // 收款说明
    private String bankReceiptNote;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankFkAmount() {
        return bankFkAmount;
    }

    public void setBankFkAmount(String bankFkAmount) {
        this.bankFkAmount = bankFkAmount;
    }

    public String getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankFkDatetime(String bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
    }

    public String getBankReceiptCode() {
        return bankReceiptCode;
    }

    public void setBankReceiptCode(String bankReceiptCode) {
        this.bankReceiptCode = bankReceiptCode;
    }

    public String getBankReceiptNumber() {
        return bankReceiptNumber;
    }

    public void setBankReceiptNumber(String bankReceiptNumber) {
        this.bankReceiptNumber = bankReceiptNumber;
    }

    public String getBankReceiptPdf() {
        return bankReceiptPdf;
    }

    public void setBankReceiptPdf(String bankReceiptPdf) {
        this.bankReceiptPdf = bankReceiptPdf;
    }

    public String getBankReceiptNote() {
        return bankReceiptNote;
    }

    public void setBankReceiptNote(String bankReceiptNote) {
        this.bankReceiptNote = bankReceiptNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
