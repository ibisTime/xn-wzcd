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

    // 客户姓名
    private String realName;

    // 证件号
    private String IdNo;

    // 贷款银行名称
    private String loanBankName;

    // 贷款金额
    private Long loanAmount;

    // 总期数
    private int periods;

    // 剩余金额
    private Long remainAmount;

    // 放款日期
    private Date fkDatetime;

    // 逾期金额
    private Long overdueAmount;

    // 逾期日期
    private Date overdueDatetime;

    // 导入日期
    private Date importDatetime;

    // 导入说明
    private String importNote;

    // 状态(0 待处理 1 已处理)
    private String status;

    // 处理说明
    private String handleNote;

    // 准入单编号
    private String budgetOrderCode;

    // ********** db properties **********

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public Date getImportDatetime() {
        return importDatetime;
    }

    public void setImportDatetime(Date importDatetime) {
        this.importDatetime = importDatetime;
    }

    public String getImportNote() {
        return importNote;
    }

    public void setImportNote(String importNote) {
        this.importNote = importNote;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public Long getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Long remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Date getFkDatetime() {
        return fkDatetime;
    }

    public void setFkDatetime(Date fkDatetime) {
        this.fkDatetime = fkDatetime;
    }

    public Long getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Long overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Date getOverdueDatetime() {
        return overdueDatetime;
    }

    public void setOverdueDatetime(Date overdueDatetime) {
        this.overdueDatetime = overdueDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }
}
