package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 履约保证金开票
* @author: CYunlai 
* @since: 2018-08-21 17:36:53
* @history:
*/
public class PerformanceBond extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // id
    private int id;

    // 预算单编号
    private String budgetCode;

    // 客户姓名
    private String customerName;

    // 汽车经销商
    private String carDealerCode;

    // 业务员
    private String saleUser;

    // 贷款银行
    private String loanBankCode;

    // 贷款金额
    private Long loanAmount;

    // 履约保证金
    private Long lyAmount;

    // 放款日期
    private Date bankFkDatetime;

    // 收款打印单号
    private String printNumber;

    // 收款打印日期
    private Date printDatetime;

    /*------------辅助字段-------------*/

    // 贷款银行名称
    private String loanBankName;

    // 汽车经销商名称
    private String carDealerName;

    // 业务员名称
    private String saleUserName;

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public String getCarDealerName() {
        return carDealerName;
    }

    public void setCarDealerName(String carDealerName) {
        this.carDealerName = carDealerName;
    }

    public String getSaleUserName() {
        return saleUserName;
    }

    public void setSaleUserName(String saleUserName) {
        this.saleUserName = saleUserName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getSaleUser() {
        return saleUser;
    }

    public void setSaleUser(String saleUser) {
        this.saleUser = saleUser;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getLyAmount() {
        return lyAmount;
    }

    public void setLyAmount(Long lyAmount) {
        this.lyAmount = lyAmount;
    }

    public Date getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankFkDatetime(Date bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
    }

    public String getPrintNumber() {
        return printNumber;
    }

    public void setPrintNumber(String printNumber) {
        this.printNumber = printNumber;
    }

    public Date getPrintDatetime() {
        return printDatetime;
    }

    public void setPrintDatetime(Date printDatetime) {
        this.printDatetime = printDatetime;
    }

}
