package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月17日 下午2:52:00 
 * @history:
 */
public class XN632176Req {

    // 垫资汇总编号
    private String code;

    // 付款时间
    private String payDatetime;

    // 付款账号编号
    private String payBankcardCode;

    // 付款凭证（水单）
    private String billPdf;

    // 付款意见说明
    private String payNote;

    // 更新人
    private String operator;

    // 垫资单编号列表
    private List<String> codeList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
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

    public String getPayNote() {
        return payNote;
    }

    public void setPayNote(String payNote) {
        this.payNote = payNote;
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
