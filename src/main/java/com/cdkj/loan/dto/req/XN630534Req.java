package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 缴纳代偿金额
 * @author: jiafr 
 * @since: 2018年8月27日 上午10:22:30 
 * @history:
 */
public class XN630534Req {

    @NotBlank
    private String code;// 还款业务编号

    @NotBlank
    private String operator;// 操作人

    @NotBlank
    private String payType;// 支付方式

    @NotBlank
    private String payAmount;// 支付金额

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

}
