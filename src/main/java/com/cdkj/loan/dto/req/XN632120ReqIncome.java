package com.cdkj.loan.dto.req;

/**
 * 征信人员收入
 * @author: xieyj 
 * @since: 2018年5月27日 下午1:57:33 
 * @history:
 */
public class XN632120ReqIncome {

    // 月收入
    private String monthIncome;

    // 结息
    private String settleInterest;

    // 余额
    private String balance;

    // 流水是否体现月收入
    private String jourShowIncome;

    // 是否打件
    private String isPrint;

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getSettleInterest() {
        return settleInterest;
    }

    public void setSettleInterest(String settleInterest) {
        this.settleInterest = settleInterest;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getJourShowIncome() {
        return jourShowIncome;
    }

    public void setJourShowIncome(String jourShowIncome) {
        this.jourShowIncome = jourShowIncome;
    }

    public String getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(String isPrint) {
        this.isPrint = isPrint;
    }
}
