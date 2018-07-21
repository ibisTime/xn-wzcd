package com.cdkj.loan.dto.req;

/**
 * 返点财务放款
 * @author: jiafr 
 * @since: 2018年6月18日 下午2:37:04 
 * @history:
 */
public class XN632241Req {

    // 编号
    private String code;

    // 付款时间
    private String payDatetime;

    // 付款账号编号
    private String payBankcardCode;

    // 水单
    private String billPdf;

    // 付款备注
    private String payRemark;

    // 操作人
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPayBankcardCode() {
        return payBankcardCode;
    }

    public void setPayBankcardCode(String payBankcardCode) {
        this.payBankcardCode = payBankcardCode;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(String payDatetime) {
        this.payDatetime = payDatetime;
    }

}
