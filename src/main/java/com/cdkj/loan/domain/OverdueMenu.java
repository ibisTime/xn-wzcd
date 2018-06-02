package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 逾期名单
 * @author: jiafr 
 * @since: 2018年5月31日 上午1:42:41 
 * @history:
 */
public class OverdueMenu extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 导入日期
    private Date importDatetime;

    // 客户姓名
    private String realName;

    // 证件号
    private String IdNo;

    // 贷款银行
    private String loanBank;

    // 贷款金额
    private Long loanAmount;

    // 总期数
    private String periods;

    // 剩余金额
    private Long remainAmount;

    // 放款日期
    private Date loanDatetime;

    // 逾期金额
    private Long overdueAmount;

    // 准入单编号
    private String budgetOrder;

    // 逾期日期
    private Date overdueDatetime;

    // 状态
    private String status;

    // 垫资日期
    private Date advanceFundDatetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getImportDatetime() {
        return importDatetime;
    }

    public void setImportDatetime(Date importDatetime) {
        this.importDatetime = importDatetime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNo() {
        return IdNo;
    }

    public void setIdNo(String idNo) {
        IdNo = idNo;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public Long getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Long remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Date getLoanDatetime() {
        return loanDatetime;
    }

    public void setLoanDatetime(Date loanDatetime) {
        this.loanDatetime = loanDatetime;
    }

    public Long getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Long overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public String getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(String budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public Date getOverdueDatetime() {
        return overdueDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAdvanceFundDatetime() {
        return advanceFundDatetime;
    }

    public void setAdvanceFundDatetime(Date advanceFundDatetime) {
        this.advanceFundDatetime = advanceFundDatetime;
    }

    public void setOverdueDatetime(Date overdueDatetime) {
        this.overdueDatetime = overdueDatetime;
    }

}
