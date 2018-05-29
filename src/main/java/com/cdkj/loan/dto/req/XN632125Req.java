package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-财务确认垫资
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632125Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    // 垫资日期
    @NotBlank
    private String advanceFundDatetime;

    // 垫资金额
    @NotBlank
    private String advanceFundAmount;

    // 水单
    @NotBlank
    private String billPdf;

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

    public String getAdvanceFundDatetime() {
        return advanceFundDatetime;
    }

    public void setAdvanceFundDatetime(String advanceFundDatetime) {
        this.advanceFundDatetime = advanceFundDatetime;
    }

    public String getAdvanceFundAmount() {
        return advanceFundAmount;
    }

    public void setAdvanceFundAmount(String advanceFundAmount) {
        this.advanceFundAmount = advanceFundAmount;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }
}
