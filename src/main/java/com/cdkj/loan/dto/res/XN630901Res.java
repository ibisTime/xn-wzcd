package com.cdkj.loan.dto.res;

/**
 * 车贷分期业务统计
 * @author: jiafr 
 * @since: 2018年8月3日 下午7:31:13 
 * @history:
 */
public class XN630901Res {

    // 分公司名称
    private String companyName;

    // 上日余额
    private String previousBalance;

    // 上日逾期额
    private String previousOverdueAmount;

    // 上日逾期率
    private String previousOverdueRate;

    // 借方发生额
    private String borrowAmount;

    // 借方逾期额
    private String borrowOverdueAmount;

    // 贷方发生额
    private String loanAmount;

    // 贷方逾期额
    private String loanOverdueAmount;

    // 当日余额
    private String currentDayBalance;

    // 当日逾期额
    private String currentDayOverdue;

    // 当日逾期率
    private String currentDayOverdueRate;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(String previousBalance) {
        this.previousBalance = previousBalance;
    }

    public String getPreviousOverdueAmount() {
        return previousOverdueAmount;
    }

    public void setPreviousOverdueAmount(String previousOverdueAmount) {
        this.previousOverdueAmount = previousOverdueAmount;
    }

    public String getPreviousOverdueRate() {
        return previousOverdueRate;
    }

    public void setPreviousOverdueRate(String previousOverdueRate) {
        this.previousOverdueRate = previousOverdueRate;
    }

    public String getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(String borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public String getBorrowOverdueAmount() {
        return borrowOverdueAmount;
    }

    public void setBorrowOverdueAmount(String borrowOverdueAmount) {
        this.borrowOverdueAmount = borrowOverdueAmount;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanOverdueAmount() {
        return loanOverdueAmount;
    }

    public void setLoanOverdueAmount(String loanOverdueAmount) {
        this.loanOverdueAmount = loanOverdueAmount;
    }

    public String getCurrentDayBalance() {
        return currentDayBalance;
    }

    public void setCurrentDayBalance(String currentDayBalance) {
        this.currentDayBalance = currentDayBalance;
    }

    public String getCurrentDayOverdue() {
        return currentDayOverdue;
    }

    public void setCurrentDayOverdue(String currentDayOverdue) {
        this.currentDayOverdue = currentDayOverdue;
    }

    public String getCurrentDayOverdueRate() {
        return currentDayOverdueRate;
    }

    public void setCurrentDayOverdueRate(String currentDayOverdueRate) {
        this.currentDayOverdueRate = currentDayOverdueRate;
    }

}
