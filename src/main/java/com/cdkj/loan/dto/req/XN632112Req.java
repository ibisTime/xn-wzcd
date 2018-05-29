package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改征信
 * @author: jiafr 
 * @since: 2018年5月29日 下午7:36:06 
 * @history:
 */
public class XN632112Req {

    private String loanBank;

    private String loanAmount;

    private String bizType;

    private String secondCarReport;

    private String xszFront;

    private String xszReverse;

    private List<XN632112ReqCreditUser> creditUserList;

    @NotBlank
    private String operator;

    @NotBlank
    private String creditCode;

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getSecondCarReport() {
        return secondCarReport;
    }

    public void setSecondCarReport(String secondCarReport) {
        this.secondCarReport = secondCarReport;
    }

    public String getXszFront() {
        return xszFront;
    }

    public void setXszFront(String xszFront) {
        this.xszFront = xszFront;
    }

    public String getXszReverse() {
        return xszReverse;
    }

    public void setXszReverse(String xszReverse) {
        this.xszReverse = xszReverse;
    }

    public List<XN632112ReqCreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<XN632112ReqCreditUser> creditUserList) {
        this.creditUserList = creditUserList;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

}
