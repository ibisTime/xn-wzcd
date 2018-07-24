package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 修改征信
 * @author: jiafr 
 * @since: 2018年6月14日 下午8:47:26 
 * @history:
 */
public class XN632112Req {

    // 操作类型 0保存1发送
    @NotBlank
    private String buttonCode;

    // 操作人
    @NotBlank
    private String operator;

    // 征信单编号
    @NotBlank
    private String creditCode;

    @NotBlank
    private String loanBankCode;

    @NotBlank
    private String shopWay;

    @NotBlank
    private String loanAmount;

    private String xszFront;

    private String xszReverse;

    @NotEmpty
    private List<XN632112ReqChild> creditUserList;

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

    public List<XN632112ReqChild> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<XN632112ReqChild> creditUserList) {
        this.creditUserList = creditUserList;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode;
    }

}
