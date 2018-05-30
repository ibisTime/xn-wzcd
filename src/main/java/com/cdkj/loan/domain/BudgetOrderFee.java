package com.cdkj.loan.domain;

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
    private String shouldAmount;

    // 实收手续费总额
    private String realAmount;

    // 是否已结清(0 待结清 1 已结清)
    private String isSettled;

    // 更新人
    private String updater;

    // 更新时间
    private String updateDatetime;

    // 备注
    private String remark;

    // 准入单编号
    private String budgetOrder;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setShouldAmount(String shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    public String getShouldAmount() {
        return shouldAmount;
    }

    public void setRealAmount(String realAmount) {
        this.realAmount = realAmount;
    }

    public String getRealAmount() {
        return realAmount;
    }

    public void setIsSettled(String isSettled) {
        this.isSettled = isSettled;
    }

    public String getIsSettled() {
        return isSettled;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setBudgetOrder(String budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public String getBudgetOrder() {
        return budgetOrder;
    }

}
