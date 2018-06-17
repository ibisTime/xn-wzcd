package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 垫资表
* @author: jiafr 
* @since: 2018-06-15 20:40:16
* @history:
*/
public class AdvanceFund extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 预算单编号
    private String budgetCode;

    // 垫资汇总单编号(分公司业务才有)
    private String totalAdvanceFundCode;

    // 类型(1总公司业务 2分公司业务)
    private String type;

    // 客户姓名
    private String customerName;

    // 业务公司编号
    private String companyCode;

    // 汽车经销商编号
    private String carDealerCode;

    // 用款金额(应退按揭款)
    private Long useAmount;

    // 贷款银行编号
    private String loanBankCode;

    // 是否垫资
    private String isAdvanceFund;

    // 收款账号编号
    private String collectBankcardCode;

    // 节点编号
    private String curNodeCode;

    // 制单意见说明
    private String makeBillNote;

    // 垫资金额
    private Long advanceFundAmount;

    // 垫资日期
    private Date advanceFundDatetime;

    // 付款银行编号
    private String payBankcardCode;

    // 付款凭证
    private String billPdf;

    // 意见说明
    private String note;

    // 撤销理由
    private String cancelReason;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    public String getTotalAdvanceFundCode() {
        return totalAdvanceFundCode;
    }

    public void setTotalAdvanceFundCode(String totalAdvanceFundCode) {
        this.totalAdvanceFundCode = totalAdvanceFundCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public Long getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(Long useAmount) {
        this.useAmount = useAmount;
    }

    public void setAdvanceFundAmount(Long advanceFundAmount) {
        this.advanceFundAmount = advanceFundAmount;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setCollectBankcardCode(String collectBankcardCode) {
        this.collectBankcardCode = collectBankcardCode;
    }

    public String getCollectBankcardCode() {
        return collectBankcardCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setMakeBillNote(String makeBillNote) {
        this.makeBillNote = makeBillNote;
    }

    public String getMakeBillNote() {
        return makeBillNote;
    }

    public Long getAdvanceFundAmount() {
        return advanceFundAmount;
    }

    public Date getAdvanceFundDatetime() {
        return advanceFundDatetime;
    }

    public void setAdvanceFundDatetime(Date advanceFundDatetime) {
        this.advanceFundDatetime = advanceFundDatetime;
    }

    public void setPayBankcardCode(String payBankcardCode) {
        this.payBankcardCode = payBankcardCode;
    }

    public String getPayBankcardCode() {
        return payBankcardCode;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}
