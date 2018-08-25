package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630566Req {

    // 还款业务编号
    @NotBlank
    private String repayBizCode;

    // 受理时间
    @NotBlank
    private String acceptanceTime;

    // 受理费
    @NotBlank
    private String acceptanceFee;

    // 案号
    @NotBlank
    private String caseNumber;

    // 操作人
    @NotBlank
    private String operator;

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getAcceptanceFee() {
        return acceptanceFee;
    }

    public void setAcceptanceFee(String acceptanceFee) {
        this.acceptanceFee = acceptanceFee;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAcceptanceTime() {
        return acceptanceTime;
    }

    public void setAcceptanceTime(String acceptanceTime) {
        this.acceptanceTime = acceptanceTime;
    }

}
