package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 诉讼跟进
 * @author: silver 
 * @since: 2018年6月16日 下午3:31:47 
 * @history:
 */
public class XN630561Req {
    // 编号
    @NotBlank
    private String code;

    // 诉讼费
    @NotBlank
    private String caseFee;

    // 起诉状态
    @NotBlank
    private String caseStatus;

    // 开庭日期
    private String courtDatetime;

    // 判决日期
    private String judgeDatetime;

    // 判决附件
    @NotBlank
    private String judgePdf;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCaseFee() {
        return caseFee;
    }

    public void setCaseFee(String caseFee) {
        this.caseFee = caseFee;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCourtDatetime() {
        return courtDatetime;
    }

    public void setCourtDatetime(String courtDatetime) {
        this.courtDatetime = courtDatetime;
    }

    public String getJudgeDatetime() {
        return judgeDatetime;
    }

    public void setJudgeDatetime(String judgeDatetime) {
        this.judgeDatetime = judgeDatetime;
    }

    public String getJudgePdf() {
        return judgePdf;
    }

    public void setJudgePdf(String judgePdf) {
        this.judgePdf = judgePdf;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
