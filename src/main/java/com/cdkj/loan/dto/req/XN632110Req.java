package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 征信新增
 * @author: jiafr 
 * @since: 2018年5月24日 下午8:57:22 
 * @history:
 */
public class XN632110Req {

    @NotBlank
    private String loanBankCode;

    @NotBlank
    private String shopWay;

    @NotBlank
    private String loanAmount;

    private String xszFront;

    private String xszReverse;

    @NotBlank
    private String operator;

    @NotEmpty
    private List<XN632110ReqChild> creditUserList;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getShopWay() {
        return shopWay;
    }

    public void setShopWay(String shopWay) {
        this.shopWay = shopWay;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
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

    public List<XN632110ReqChild> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<XN632110ReqChild> creditUserList) {
        this.creditUserList = creditUserList;
    }

}
