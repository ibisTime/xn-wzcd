package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 退回佣金
 * @author: jiafr 
 * @since: 2018年8月10日 下午5:23:19 
 * @history:
 */
public class XN632313Req {

    // 银行返佣编号
    @NotBlank
    private String code;

    // 退回金额
    @NotBlank
    private String sendBackAmount;

    // 银行回单
    @NotBlank
    private String billPdf;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSendBackAmount() {
        return sendBackAmount;
    }

    public void setSendBackAmount(String sendBackAmount) {
        this.sendBackAmount = sendBackAmount;
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

}
