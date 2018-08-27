package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 财务确认收货
 * @author: silver 
 * @since: 2018年6月16日 下午3:39:21 
 * @history:
 */
public class XN630563Req {
    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 司法诉讼收款时间
    @NotBlank
    private String judgeReceiptDatetime;

    // 司法诉讼收款金额
    @NotBlank
    private String judgeReceiptAmount;

    // 司法诉讼收款银行编号
    @NotBlank
    private String judgeReceiptBankCode;

    // 司法诉讼收款凭证
    @NotBlank
    private String judgeBillPdf;

    // 司法诉讼备注
    private String judgeNote;

    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getJudgeReceiptBankCode() {
        return judgeReceiptBankCode;
    }

    public void setJudgeReceiptBankCode(String judgeReceiptBankCode) {
        this.judgeReceiptBankCode = judgeReceiptBankCode;
    }

    public String getJudgeReceiptDatetime() {
        return judgeReceiptDatetime;
    }

    public void setJudgeReceiptDatetime(String judgeReceiptDatetime) {
        this.judgeReceiptDatetime = judgeReceiptDatetime;
    }

    public String getJudgeReceiptAmount() {
        return judgeReceiptAmount;
    }

    public void setJudgeReceiptAmount(String judgeReceiptAmount) {
        this.judgeReceiptAmount = judgeReceiptAmount;
    }

    public String getJudgeBillPdf() {
        return judgeBillPdf;
    }

    public void setJudgeBillPdf(String judgeBillPdf) {
        this.judgeBillPdf = judgeBillPdf;
    }

    public String getJudgeNote() {
        return judgeNote;
    }

    public void setJudgeNote(String judgeNote) {
        this.judgeNote = judgeNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
