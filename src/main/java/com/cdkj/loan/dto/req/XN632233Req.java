package com.cdkj.loan.dto.req;

/**
 * 发票不匹配财务确认
 * @author: jiafr 
 * @since: 2018年6月18日 上午12:37:10 
 * @history:
 */
public class XN632233Req {

    // 类型
    private String type;

    // 预算单编号
    private String code;

    // 付款金额
    private String payAmount;

    // 付款时间
    private String payDatetime;

    // 付款账号编号
    private String payBankcardCode;

    // 付款凭证（水单）
    private String payBillPdf;

    // 收款金额
    private String collectionAmount;

    // 收款时间
    private String collectionDatetime;

    // 收款银行（收款账号编号）
    private String collectionBankcardCode;

    // 收款凭证（水单）
    private String collectionBillPdf;

    // 收款意见说明
    private String remark;

    // 更新人
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

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(String payDatetime) {
        this.payDatetime = payDatetime;
    }

    public String getPayBankcardCode() {
        return payBankcardCode;
    }

    public void setPayBankcardCode(String payBankcardCode) {
        this.payBankcardCode = payBankcardCode;
    }

    public String getPayBillPdf() {
        return payBillPdf;
    }

    public void setPayBillPdf(String payBillPdf) {
        this.payBillPdf = payBillPdf;
    }

    public String getCollectionAmount() {
        return collectionAmount;
    }

    public void setCollectionAmount(String collectionAmount) {
        this.collectionAmount = collectionAmount;
    }

    public String getCollectionDatetime() {
        return collectionDatetime;
    }

    public void setCollectionDatetime(String collectionDatetime) {
        this.collectionDatetime = collectionDatetime;
    }

    public String getCollectionBankcardCode() {
        return collectionBankcardCode;
    }

    public void setCollectionBankcardCode(String collectionBankcardCode) {
        this.collectionBankcardCode = collectionBankcardCode;
    }

    public String getCollectionBillPdf() {
        return collectionBillPdf;
    }

    public void setCollectionBillPdf(String collectionBillPdf) {
        this.collectionBillPdf = collectionBillPdf;
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
