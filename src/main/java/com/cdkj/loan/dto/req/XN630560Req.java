package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 司法诉讼
 * @author: silver 
 * @since: 2018年6月16日 下午2:48:11 
 * @history:
 */
public class XN630560Req {
    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 案号
    @NotBlank
    private String caseNumber;

    // 原告
    @NotBlank
    private String plaintiff;

    // 被告
    @NotBlank
    private String defendant;

    // 诉讼标的
    @NotBlank
    private String caseSubject;

    // 诉讼费
    @NotBlank
    private String caseFee;

    // 起诉日期
    @NotBlank
    private String caseStartDatetime;

    // 起诉附件
    @NotBlank
    private String casePdf;

    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getPlaintiff() {
        return plaintiff;
    }

    public void setPlaintiff(String plaintiff) {
        this.plaintiff = plaintiff;
    }

    public String getDefendant() {
        return defendant;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public String getCaseSubject() {
        return caseSubject;
    }

    public void setCaseSubject(String caseSubject) {
        this.caseSubject = caseSubject;
    }

    public String getCaseFee() {
        return caseFee;
    }

    public void setCaseFee(String caseFee) {
        this.caseFee = caseFee;
    }

    public String getCaseStartDatetime() {
        return caseStartDatetime;
    }

    public void setCaseStartDatetime(String caseStartDatetime) {
        this.caseStartDatetime = caseStartDatetime;
    }

    public String getCasePdf() {
        return casePdf;
    }

    public void setCasePdf(String casePdf) {
        this.casePdf = casePdf;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
