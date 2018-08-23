package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 奖金提成
* @author: CYunlai 
* @since: 2018-08-20 21:08:48
* @history:
*/
public class BonusesList extends ABaseDO {

    private static final long serialVersionUID = 4044647931440714600L;

    // 编号
    private String code;

    // 月份（yyyy-MM）
    private String month;

    // 业务员
    private String saleUser;

    // 预算单编号
    private String budgetCode;

    // 是否自主开发
    private String isSelfDevelop;

    // 自主开发奖金
    private Long selfDevelopAmount;

    // 非自主开发奖金
    private Long notSelfDevelopAmount;

    // 贷款金额
    private Long loanAmount;

    // 是否已放款
    private String isLoanBank;

    /*--------辅助字段---------*/

    // 放款月份起
    private String monthStart;

    // 放款月份止
    private String monthEnd;

    public String getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(String monthStart) {
        this.monthStart = monthStart;
    }

    public String getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(String monthEnd) {
        this.monthEnd = monthEnd;
    }

    public String getIsLoanBank() {
        return isLoanBank;
    }

    public void setIsLoanBank(String isLoanBank) {
        this.isLoanBank = isLoanBank;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setSaleUser(String saleUser) {
        this.saleUser = saleUser;
    }

    public String getSaleUser() {
        return saleUser;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setIsSelfDevelop(String isSelfDevelop) {
        this.isSelfDevelop = isSelfDevelop;
    }

    public String getIsSelfDevelop() {
        return isSelfDevelop;
    }

    public Long getSelfDevelopAmount() {
        return selfDevelopAmount;
    }

    public void setSelfDevelopAmount(Long selfDevelopAmount) {
        this.selfDevelopAmount = selfDevelopAmount;
    }

    public Long getNotSelfDevelopAmount() {
        return notSelfDevelopAmount;
    }

    public void setNotSelfDevelopAmount(Long notSelfDevelopAmount) {
        this.notSelfDevelopAmount = notSelfDevelopAmount;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

}
