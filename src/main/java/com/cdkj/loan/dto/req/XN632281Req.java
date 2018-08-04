package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632281Req {

    // 预算单编号
    @NotBlank
    private String code;

    // 审核结果
    @NotBlank
    private String approveResult;

    // 审核说明
    @NotBlank
    private String approveNote;

    // 付款水单
    private String billPdf;

    // 操作人
    @NotBlank
    private String operator;

    // 收款账号编号
    @NotBlank
    private String zfSkBankcardCode;

    // 收款时间
    @NotBlank
    private String zfSkReceiptDatetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getZfSkBankcardCode() {
        return zfSkBankcardCode;
    }

    public void setZfSkBankcardCode(String zfSkBankcardCode) {
        this.zfSkBankcardCode = zfSkBankcardCode;
    }

    public String getZfSkReceiptDatetime() {
        return zfSkReceiptDatetime;
    }

    public void setZfSkReceiptDatetime(String zfSkReceiptDatetime) {
        this.zfSkReceiptDatetime = zfSkReceiptDatetime;
    }

}
