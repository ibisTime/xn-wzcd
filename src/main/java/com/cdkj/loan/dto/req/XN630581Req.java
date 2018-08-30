package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630581Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 经办法官
    @NotBlank
    private String handleJudge;

    // 执行案号
    private String hearCaseNumber;

    // 优先权标的物
    @NotBlank
    private String caseSubject;

    // 操作人
    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getHandleJudge() {
        return handleJudge;
    }

    public void setHandleJudge(String handleJudge) {
        this.handleJudge = handleJudge;
    }

    public String getHearCaseNumber() {
        return hearCaseNumber;
    }

    public void setHearCaseNumber(String hearCaseNumber) {
        this.hearCaseNumber = hearCaseNumber;
    }

    public String getCaseSubject() {
        return caseSubject;
    }

    public void setCaseSubject(String caseSubject) {
        this.caseSubject = caseSubject;
    }

}
