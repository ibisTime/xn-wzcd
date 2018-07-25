package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月17日 下午2:52:00 
 * @history:
 */
public class XN632176Req {

    // 业务公司编号
    @NotBlank
    private String companyCode;

    // 垫资日期
    @NotBlank
    private String payDatetime;

    // 付款账号编号
    @NotBlank
    private String payBankcardCode;

    // 付款凭证（水单）
    @NotBlank
    private String billPdf;

    // 付款意见说明
    private String payNote;

    // 操作人
    private String operator;

    // 垫资单编号列表(通过制单的)
    private List<String> codeList;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

}
