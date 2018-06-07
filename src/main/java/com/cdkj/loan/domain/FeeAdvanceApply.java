package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 费用预支申请
* @author: jiafr 
* @since: 2018-06-06 20:31:00
* @history:
*/
public class FeeAdvanceApply extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 4353828548933811186L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 关联资产审批编号
    private String refAssertCode;

    // 关联车贷业务编号
    private String refBudgetOrderCode;

    // 预支金额
    private Long amount;

    // 开户银行
    private String subbranch;

    // 银行账号
    private String bankcardNumber;

    // 账户名
    private String accountName;

    // 申请人
    private String applyUser;

    // 申请时间
    private Date applyDatetime;

    // 申请说明
    private String applyNote;

    // 付款时间
    private Date payDatetime;

    // 付款银行
    private String payBank;

    // 付款账号
    private String payBankcard;

    // 付款凭证
    private String payPdf;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // *************db properties***************

    // 申请时间起
    private Date applyDateStart;

    // 申请时间止
    private Date applyDateEnd;

    // 申请用户
    private SYSUser applySysUser;

    // 更新用户
    private SYSUser updateSysUser;

    // 资产实体
    private AssertApply refAssertApply;

    // 预算单
    private BudgetOrder refBudgetOrder;

    // 付款银行
    private Bank payBankInfo;

    public Bank getPayBankInfo() {
        return payBankInfo;
    }

    public void setPayBankInfo(Bank payBankInfo) {
        this.payBankInfo = payBankInfo;
    }

    public SYSUser getApplySysUser() {
        return applySysUser;
    }

    public void setApplySysUser(SYSUser applySysUser) {
        this.applySysUser = applySysUser;
    }

    public SYSUser getUpdateSysUser() {
        return updateSysUser;
    }

    public void setUpdateSysUser(SYSUser updateSysUser) {
        this.updateSysUser = updateSysUser;
    }

    public AssertApply getRefAssertApply() {
        return refAssertApply;
    }

    public void setRefAssertApply(AssertApply refAssertApply) {
        this.refAssertApply = refAssertApply;
    }

    public BudgetOrder getRefBudgetOrder() {
        return refBudgetOrder;
    }

    public void setRefBudgetOrder(BudgetOrder refBudgetOrder) {
        this.refBudgetOrder = refBudgetOrder;
    }

    public Date getApplyDateStart() {
        return applyDateStart;
    }

    public void setApplyDateStart(Date applyDateStart) {
        this.applyDateStart = applyDateStart;
    }

    public Date getApplyDateEnd() {
        return applyDateEnd;
    }

    public void setApplyDateEnd(Date applyDateEnd) {
        this.applyDateEnd = applyDateEnd;
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

    public String getRefAssertCode() {
        return refAssertCode;
    }

    public void setRefAssertCode(String refAssertCode) {
        this.refAssertCode = refAssertCode;
    }

    public String getRefBudgetOrderCode() {
        return refBudgetOrderCode;
    }

    public void setRefBudgetOrderCode(String refBudgetOrderCode) {
        this.refBudgetOrderCode = refBudgetOrderCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }

    public String getPayBank() {
        return payBank;
    }

    public void setPayBank(String payBank) {
        this.payBank = payBank;
    }

    public String getPayBankcard() {
        return payBankcard;
    }

    public void setPayBankcard(String payBankcard) {
        this.payBankcard = payBankcard;
    }

    public String getPayPdf() {
        return payPdf;
    }

    public void setPayPdf(String payPdf) {
        this.payPdf = payPdf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
