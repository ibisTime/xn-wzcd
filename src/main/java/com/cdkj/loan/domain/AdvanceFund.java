package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 垫资表
* @author: jiafr 
* @since: 2018-06-15 20:40:16
* @history:
*/
public class AdvanceFund extends ABaseDO {

    private static final long serialVersionUID = 8269296004558344190L;

    // 编号
    private String code;

    // 预算单编号
    private String budgetCode;

    // 垫资汇总单编号(外地公司业务才有)
    private String totalAdvanceFundCode;

    // 类型(1本地公司业务 2外地公司业务)
    private String type;

    // 客户姓名
    private String customerName;

    // 业务公司编号
    private String companyCode;

    // 汽车经销商编号
    private String carDealerCode;

    // 用款金额(应退按揭款)
    private Long useAmount;

    // 贷款金额
    private Long loanAmount;

    // 手续费
    private Long serviceCharge;

    // 手续费收取方式
    private String serviceChargeWay;

    // GPS费
    private Long gpsFee;

    // GPS收取方式
    private String gpsFeeWay;

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

    // 垫资金额(财务打款界面填写的垫资金额)
    private Long advanceFundAmount;

    // 垫资日期
    private Date advanceFundDatetime;

    // 付款账号编号
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

    // 申请人编号
    private String applyUser;

    // 申请时间
    private Date applyDatetime;

    /*********************db properties******************/

    // 角色编号
    private String roleCode;

    // 申请时间起
    private Date applyDatetimeStart;

    // 申请时间止
    private Date applyDatetimeEnd;

    // 更新时间起
    private Date updateDatetimeStart;

    // 更新时间止
    private Date updateDatetimeEnd;

    // 征信单编号
    private String creditCode;

    // 收款账号
    private String collectionAccountNo;

    // 收款银行名称
    private String collectBankName;

    // 收款银行支行名称
    private String collectSubbranch;

    // 收款账号户名
    private String collectAccountName;

    // 付款账号
    private String payAccountNo;

    // 贷款银行名称
    private String loanBankName;

    // 业务公司名称
    private String bizCompanyName;

    // 汽车经销商名称
    private String carDealerName;

    // 申请人姓名
    private String applyUserName;

    // 客户身份证号
    private String applyUserIdNo;

    // 预算单
    private BudgetOrder budgetOrder;

    // 节点编号列表
    private List<String> curNodeCodeList;

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getCollectSubbranch() {
        return collectSubbranch;
    }

    public void setCollectSubbranch(String collectSubbranch) {
        this.collectSubbranch = collectSubbranch;
    }

    public String getApplyUserIdNo() {
        return applyUserIdNo;
    }

    public void setApplyUserIdNo(String applyUserIdNo) {
        this.applyUserIdNo = applyUserIdNo;
    }

    public String getCollectBankName() {
        return collectBankName;
    }

    public void setCollectBankName(String collectBankName) {
        this.collectBankName = collectBankName;
    }

    public Long getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Long serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Long getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(Long gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getServiceChargeWay() {
        return serviceChargeWay;
    }

    public void setServiceChargeWay(String serviceChargeWay) {
        this.serviceChargeWay = serviceChargeWay;
    }

    public String getGpsFeeWay() {
        return gpsFeeWay;
    }

    public void setGpsFeeWay(String gpsFeeWay) {
        this.gpsFeeWay = gpsFeeWay;
    }

    public BudgetOrder getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(BudgetOrder budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public String getPayAccountNo() {
        return payAccountNo;
    }

    public void setPayAccountNo(String payAccountNo) {
        this.payAccountNo = payAccountNo;
    }

    public String getCollectionAccountNo() {
        return collectionAccountNo;
    }

    public void setCollectionAccountNo(String collectionAccountNo) {
        this.collectionAccountNo = collectionAccountNo;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public String getBizCompanyName() {
        return bizCompanyName;
    }

    public void setBizCompanyName(String bizCompanyName) {
        this.bizCompanyName = bizCompanyName;
    }

    public String getCarDealerName() {
        return carDealerName;
    }

    public void setCarDealerName(String carDealerName) {
        this.carDealerName = carDealerName;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

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

    public Date getUpdateDatetimeStart() {
        return updateDatetimeStart;
    }

    public void setUpdateDatetimeStart(Date updateDatetimeStart) {
        this.updateDatetimeStart = updateDatetimeStart;
    }

    public Date getUpdateDatetimeEnd() {
        return updateDatetimeEnd;
    }

    public void setUpdateDatetimeEnd(Date updateDatetimeEnd) {
        this.updateDatetimeEnd = updateDatetimeEnd;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

    public String getCollectAccountName() {
        return collectAccountName;
    }

    public void setCollectAccountName(String collectAccountName) {
        this.collectAccountName = collectAccountName;
    }

}
