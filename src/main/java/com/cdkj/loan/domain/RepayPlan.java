package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 还款计划
* @author: haiqingzheng
* @since: 2018年05月01日 18:52:51
* @history:
*/
public class RepayPlan extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 关联业务编号
    private String repayBizCode;

    // 借款人编号
    private String userId;

    // 总期数
    private int periods;

    // 当前期数
    private int curPeriods;

    // 还款时间
    private Date repayDatetime;

    // 本期本金
    private Long repayCapital;

    // 本期利息
    private double repayInterest;

    // 已还金额
    private Long payedAmount;

    // 逾期金额
    private Long overdueAmount;

    // 状态
    private String status;

    // 逾期处理人
    private String overdueHandler;

    // 逾期处理时间
    private Date overdueHandleDatetime;

    // 逾期处理说明
    private String overdueHandleNote;

    // 清收费用总额
    private Long totalFee;

    // 已缴纳清收费用总额
    private Long payedFee;

    // 再次逾期保证金
    private Long overdueDeposit;

    // 再次逾期保证金收取方式
    private String depositWay;

    // 实际可退的再次逾期保证金
    private Long shouldDeposit;

    // 已催款次数
    private int remindCount;

    // ****** 辅助字段 ******

    // 用户信息
    private CUser user;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public int getCurPeriods() {
        return curPeriods;
    }

    public void setCurPeriods(int curPeriods) {
        this.curPeriods = curPeriods;
    }

    public Date getRepayDatetime() {
        return repayDatetime;
    }

    public void setRepayDatetime(Date repayDatetime) {
        this.repayDatetime = repayDatetime;
    }

    public Long getRepayCapital() {
        return repayCapital;
    }

    public void setRepayCapital(Long repayCapital) {
        this.repayCapital = repayCapital;
    }

    public double getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(double repayInterest) {
        this.repayInterest = repayInterest;
    }

    public Long getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Long payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Long getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Long overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOverdueHandler() {
        return overdueHandler;
    }

    public void setOverdueHandler(String overdueHandler) {
        this.overdueHandler = overdueHandler;
    }

    public Date getOverdueHandleDatetime() {
        return overdueHandleDatetime;
    }

    public void setOverdueHandleDatetime(Date overdueHandleDatetime) {
        this.overdueHandleDatetime = overdueHandleDatetime;
    }

    public String getOverdueHandleNote() {
        return overdueHandleNote;
    }

    public void setOverdueHandleNote(String overdueHandleNote) {
        this.overdueHandleNote = overdueHandleNote;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getPayedFee() {
        return payedFee;
    }

    public void setPayedFee(Long payedFee) {
        this.payedFee = payedFee;
    }

    public Long getOverdueDeposit() {
        return overdueDeposit;
    }

    public void setOverdueDeposit(Long overdueDeposit) {
        this.overdueDeposit = overdueDeposit;
    }

    public String getDepositWay() {
        return depositWay;
    }

    public void setDepositWay(String depositWay) {
        this.depositWay = depositWay;
    }

    public Long getShouldDeposit() {
        return shouldDeposit;
    }

    public void setShouldDeposit(Long shouldDeposit) {
        this.shouldDeposit = shouldDeposit;
    }

    public int getRemindCount() {
        return remindCount;
    }

    public void setRemindCount(int remindCount) {
        this.remindCount = remindCount;
    }

    public CUser getUser() {
        return user;
    }

    public void setUser(CUser user) {
        this.user = user;
    }

}
