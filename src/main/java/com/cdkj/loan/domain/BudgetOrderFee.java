package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 准入单手续费
* @author: xieyj 
* @since: 2018-05-30 18:58:33
* @history:
*/
public class BudgetOrderFee extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 公司编号
    private String companyCode;

    // 用户编号
    private String userId;

    // 应收手续费总额
    private Long shouldAmount;

    // 实收手续费总额
    private Long realAmount;

    // 是否已结清(0 待结清 1 已结清)
    private String isSettled;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 准入单编号
    private String budgetOrder;

    /*-------辅助字段----------*/

    private List<BudgetOrderFeeDetail> BudgetOrderFeeDetailList;

    // 业务公司名
    private String companyName;

    // 贷款银行
    private String loanBankName;

    // 贷款金额
    private Long loanAmount;

    private String updaterRealName;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getShouldAmount() {
        return shouldAmount;
    }

    public void setShouldAmount(Long shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    public Long getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Long realAmount) {
        this.realAmount = realAmount;
    }

    public String getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(String isSettled) {
        this.isSettled = isSettled;
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

    public String getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(String budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public List<BudgetOrderFeeDetail> getBudgetOrderFeeDetailList() {
        return BudgetOrderFeeDetailList;
    }

    public void setBudgetOrderFeeDetailList(
            List<BudgetOrderFeeDetail> budgetOrderFeeDetailList) {
        BudgetOrderFeeDetailList = budgetOrderFeeDetailList;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUpdaterRealName() {
        return updaterRealName;
    }

    public void setUpdaterRealName(String updaterRealName) {
        this.updaterRealName = updaterRealName;
    }

}
