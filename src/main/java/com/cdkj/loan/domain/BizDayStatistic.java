package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 车贷分期业务日计表
* @author: jiafr 
* @since: 2018-08-06 17:41:34
* @history:
*/
public class BizDayStatistic extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // id
    private String id;

    // 分公司编号
    private String companyCode;

    // 借方发生额(当日银行放款总额)
    private Long debitAmount;

    // 贷方发生额(当日客户还款总额)
    private Long loanAmount;

    // 当日余额
    private Long balance;

    // 贷方逾期金额
    private Long loanOverdueAmount;

    // 当日逾期余额
    private Long overdueBalance;

    // 当日逾期率
    private Double overdueRate;

    // 日期（yyyy-MM-dd）
    private Date date;

    /***************db properties******************/

    private String companyName;// 分公司名称

    private String preBalance;// 上日余额

    private String preOverdueBalance;// 上日逾期余额

    private String preOverdueRate;// 上日逾期率

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Long getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Long debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getLoanOverdueAmount() {
        return loanOverdueAmount;
    }

    public void setLoanOverdueAmount(Long loanOverdueAmount) {
        this.loanOverdueAmount = loanOverdueAmount;
    }

    public Double getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(Double overdueRate) {
        this.overdueRate = overdueRate;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getOverdueBalance() {
        return overdueBalance;
    }

    public void setOverdueBalance(Long overdueBalance) {
        this.overdueBalance = overdueBalance;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(String preBalance) {
        this.preBalance = preBalance;
    }

    public String getPreOverdueBalance() {
        return preOverdueBalance;
    }

    public void setPreOverdueBalance(String preOverdueBalance) {
        this.preOverdueBalance = preOverdueBalance;
    }

    public String getPreOverdueRate() {
        return preOverdueRate;
    }

    public void setPreOverdueRate(String preOverdueRate) {
        this.preOverdueRate = preOverdueRate;
    }

}
