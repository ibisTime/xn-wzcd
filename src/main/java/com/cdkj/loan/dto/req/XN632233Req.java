package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 发票不匹配财务确认
 * @author: jiafr 
 * @since: 2018年6月18日 上午12:37:10 
 * @history:
 */
public class XN632233Req {

    // 类型（2发票不匹配补打款3发票不匹配收回款）
    @NotBlank
    private String type;

    // 预算单编号
    @NotBlank
    private String code;

    // 付款金额
    @NotBlank
    private String amount;

    // 付款时间
    @NotBlank
    private String datetime;

    // 付款账号编号
    @NotBlank
    private String bankcardCode;

    // 付款凭证（水单）
    @NotBlank
    private String billPdf;

    // 备注
    private String remark;

    // 操作人
    private String operator;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
