package com.cdkj.loan.dto.req;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月17日 下午2:52:00 
 * @history:
 */
public class XN632176Req {

    // 业务公司编号
    private String companyCode;

    // 垫资总金额
    private Long totalAdvanceFund;

    // 付款金额
    private Long payAmount;

    // 付款时间
    private Date payDatetime;

    // 付款账号编号
    private String payBankcardCode;

    // 付款凭证（水单）
    private String billPdf;

    // 付款意见说明
    private String payNote;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 垫资单编号列表
    private List<String> codeList;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Long getTotalAdvanceFund() {
        return totalAdvanceFund;
    }

    public void setTotalAdvanceFund(Long totalAdvanceFund) {
        this.totalAdvanceFund = totalAdvanceFund;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
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

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}
