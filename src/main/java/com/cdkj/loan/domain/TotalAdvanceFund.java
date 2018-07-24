package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 垫资汇总表
* @author: jiafr 
* @since: 2018-06-17 11:16:01
* @history:
*/
public class TotalAdvanceFund extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型(1第一次打款2发票不匹配补打款3发票不匹配收回款)
    private String type;

    // 业务公司编号
    private String companyCode;

    // 垫资总金额（制单时通过审核的所有垫资单相加总金额）
    private Long totalAdvanceFund;

    // 付款金额（垫资总金额-请款预算单金额=本次垫资金额）
    private Long payAmount;

    // 制单意见说明
    private String makeBillNote;

    // 付款时间
    private Date payDatetime;

    // 付款账号编号
    private String payBankcardCode;

    // 付款凭证（水单）
    private String billPdf;

    // 付款意见说明
    private String payNote;

    // 收款金额
    private Long collectionAmount;

    // 收款时间
    private Date collectionDatetime;

    // 收款银行（收款账号编号）
    private String collectionBankcardCode;

    // 收款凭证（水单）
    private String collectionBillPdf;

    // 收款意见说明
    private String collectionNote;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 状态（0待打款给分公司 1已打款给分公司）
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getMakeBillNote() {
        return makeBillNote;
    }

    public void setMakeBillNote(String makeBillNote) {
        this.makeBillNote = makeBillNote;
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

    public Long getCollectionAmount() {
        return collectionAmount;
    }

    public void setCollectionAmount(Long collectionAmount) {
        this.collectionAmount = collectionAmount;
    }

    public Date getCollectionDatetime() {
        return collectionDatetime;
    }

    public void setCollectionDatetime(Date collectionDatetime) {
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

    public String getCollectionNote() {
        return collectionNote;
    }

    public void setCollectionNote(String collectionNote) {
        this.collectionNote = collectionNote;
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
