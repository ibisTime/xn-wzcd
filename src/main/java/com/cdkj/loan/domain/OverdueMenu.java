package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 导入逾期名单
* @author: CYunlai 
* @since: 2018-06-02 17:37:07
* @history:
*/
public class OverdueMenu extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 批量日期
    private Date batchDatetime;

    // 客户姓名(匹配)
    private String realName;

    // 证件号(匹配)
    private String idNo;

    // 贷款银行
    private String loanBankCode;

    // 贷款金额(匹配)
    private Long loanAmount;

    // 总期数
    private int periods;

    // 剩余金额
    private Long remainAmount;

    // 放款日期(匹配)
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

    // 处理时间
    private Date handleDatetime;

    // 处理说明
    private String handleNote;

    // 准入单编号
    private String budgetOrderCode;

    // 还款业务
    private String repayBizCode;

    // 还款计划
    private String repayPlanCode;

    /*--------辅助字段----------*/

    private Date advanceFundDatetimeStart;// 垫资日期始

    private Date advanceFundDatetimeEnd;// 垫资日期止

    private String loanBankName;// 贷款银行名称

    // 银行放款日期
    private Date bankFkDatetimeStart;

    // 银行放款日期
    private Date bankFkDatetimeEnd;

    // 业务类型
    private RepayBiz repayBiz;

    public Date getBatchDatetime() {
        return batchDatetime;
    }

    public void setBatchDatetime(Date batchDatetime) {
        this.batchDatetime = batchDatetime;
    }

    public RepayBiz getRepayBiz() {
        return repayBiz;
    }

    public void setRepayBiz(RepayBiz repayBiz) {
        this.repayBiz = repayBiz;
    }

    public Date getBankFkDatetimeStart() {
        return bankFkDatetimeStart;
    }

    public void setBankFkDatetimeStart(Date bankFkDatetimeStart) {
        this.bankFkDatetimeStart = bankFkDatetimeStart;
    }

    public Date getBankFkDatetimeEnd() {
        return bankFkDatetimeEnd;
    }

    public void setBankFkDatetimeEnd(Date bankFkDatetimeEnd) {
        this.bankFkDatetimeEnd = bankFkDatetimeEnd;
    }

    public Date getHandleDatetime() {
        return handleDatetime;
    }

    public void setHandleDatetime(Date handleDatetime) {
        this.handleDatetime = handleDatetime;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getRepayPlanCode() {
        return repayPlanCode;
    }

    public void setRepayPlanCode(String repayPlanCode) {
        this.repayPlanCode = repayPlanCode;
    }

    public Date getAdvanceFundDatetimeStart() {
        return advanceFundDatetimeStart;
    }

    public void setAdvanceFundDatetimeStart(Date advanceFundDatetimeStart) {
        this.advanceFundDatetimeStart = advanceFundDatetimeStart;
    }

    public Date getAdvanceFundDatetimeEnd() {
        return advanceFundDatetimeEnd;
    }

    public void setAdvanceFundDatetimeEnd(Date advanceFundDatetimeEnd) {
        this.advanceFundDatetimeEnd = advanceFundDatetimeEnd;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdNo() {
        return idNo;
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

    public Date getImportDatetime() {
        return importDatetime;
    }

    public void setImportDatetime(Date importDatetime) {
        this.importDatetime = importDatetime;
    }

    public void setImportNote(String importNote) {
        this.importNote = importNote;
    }

    public String getImportNote() {
        return importNote;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

}
