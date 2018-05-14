package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 还款业务
* @author: haiqingzheng
* @since: 2018年05月01日 17:58:51
* @history:
*/
public class RepayBiz extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 申请人编号
    private String userId;

    // 还款卡编号
    private String bankcardCode;

    // 关联类型
    private String refType;

    // 关联编号
    private String refCode;

    // 业务总价
    private Long bizPrice;

    // 首付比例
    private double sfRate;

    // 首付金额
    private Long sfAmount;

    // 贷款银行
    private String loanBank;

    // 贷款金额
    private Long loanAmount;

    // 总期数
    private int periods;

    // 剩余期数
    private int restPeriods;

    // 银行利率
    private double bankRate;

    // 贷款时间起点
    private Date loanStartDatetime;

    // 贷款时间终点
    private Date loanEndDatetime;

    // 风险保证金
    private Long fxDeposit;

    // 首期还款日期
    private Date firstRepayDatetime;

    // 首期月供金额
    private Long firstRepayAmount;

    // 每期还款日期
    private int monthDatetime;

    // 每期月供金额
    private Long monthAmount;

    // 履约保证金（可退）
    private Long lyDeposit;

    // 扣除的履约保证金
    private Long cutLyDeposit;

    // 状态
    private String status;

    // 剩余欠款
    private Long restAmount;

    // 未还清收总成本
    private Long restTotalCost;

    // 额外保证金收入
    private Long totalInDeposit;

    // 逾期总金额
    private Long overdueAmount;

    // 累计逾期期数
    private int totalOverdueCount;

    // 实际逾期期数
    private int curOverdueCount;

    // 黑名单处理结果备案
    private String blackHandleNote;

    // 结清证明
    private String closeAttach;//

    // 结清时间
    private Date closeDatetime;//
    // 最近修改人

    private String updater;

    // 最近修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ****** 辅助字段 ******

    // 用户信息
    private User user;

    // 车贷订单
    private LoanOrder loanOrder;

    // 车贷订单列表
    List<LoanOrder> loanOrderList;

    // 商品订单
    private Order mallOrder;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
    }

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getRefCode() {
        return refCode;
    }

    public Long getBizPrice() {
        return bizPrice;
    }

    public void setBizPrice(Long bizPrice) {
        this.bizPrice = bizPrice;
    }

    public double getSfRate() {
        return sfRate;
    }

    public void setSfRate(double sfRate) {
        this.sfRate = sfRate;
    }

    public Long getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(Long sfAmount) {
        this.sfAmount = sfAmount;
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

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public int getRestPeriods() {
        return restPeriods;
    }

    public void setRestPeriods(int restPeriods) {
        this.restPeriods = restPeriods;
    }

    public double getBankRate() {
        return bankRate;
    }

    public void setBankRate(double bankRate) {
        this.bankRate = bankRate;
    }

    public Date getLoanStartDatetime() {
        return loanStartDatetime;
    }

    public void setLoanStartDatetime(Date loanStartDatetime) {
        this.loanStartDatetime = loanStartDatetime;
    }

    public Date getLoanEndDatetime() {
        return loanEndDatetime;
    }

    public void setLoanEndDatetime(Date loanEndDatetime) {
        this.loanEndDatetime = loanEndDatetime;
    }

    public Long getFxDeposit() {
        return fxDeposit;
    }

    public void setFxDeposit(Long fxDeposit) {
        this.fxDeposit = fxDeposit;
    }

    public Date getFirstRepayDatetime() {
        return firstRepayDatetime;
    }

    public void setFirstRepayDatetime(Date firstRepayDatetime) {
        this.firstRepayDatetime = firstRepayDatetime;
    }

    public Long getFirstRepayAmount() {
        return firstRepayAmount;
    }

    public void setFirstRepayAmount(Long firstRepayAmount) {
        this.firstRepayAmount = firstRepayAmount;
    }

    public int getMonthDatetime() {
        return monthDatetime;
    }

    public void setMonthDatetime(int monthDatetime) {
        this.monthDatetime = monthDatetime;
    }

    public Long getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(Long monthAmount) {
        this.monthAmount = monthAmount;
    }

    public Long getLyDeposit() {
        return lyDeposit;
    }

    public void setLyDeposit(Long lyDeposit) {
        this.lyDeposit = lyDeposit;
    }

    public Long getCutLyDeposit() {
        return cutLyDeposit;
    }

    public void setCutLyDeposit(Long cutLyDeposit) {
        this.cutLyDeposit = cutLyDeposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(Long restAmount) {
        this.restAmount = restAmount;
    }

    public Long getRestTotalCost() {
        return restTotalCost;
    }

    public void setRestTotalCost(Long restTotalCost) {
        this.restTotalCost = restTotalCost;
    }

    public Long getTotalInDeposit() {
        return totalInDeposit;
    }

    public void setTotalInDeposit(Long totalInDeposit) {
        this.totalInDeposit = totalInDeposit;
    }

    public Long getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Long overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public int getTotalOverdueCount() {
        return totalOverdueCount;
    }

    public void setTotalOverdueCount(int totalOverdueCount) {
        this.totalOverdueCount = totalOverdueCount;
    }

    public int getCurOverdueCount() {
        return curOverdueCount;
    }

    public void setCurOverdueCount(int curOverdueCount) {
        this.curOverdueCount = curOverdueCount;
    }

    public String getBlackHandleNote() {
        return blackHandleNote;
    }

    public void setBlackHandleNote(String blackHandleNote) {
        this.blackHandleNote = blackHandleNote;
    }

    public String getCloseAttach() {
        return closeAttach;
    }

    public void setCloseAttach(String closeAttach) {
        this.closeAttach = closeAttach;
    }

    public Date getCloseDatetime() {
        return closeDatetime;
    }

    public void setCloseDatetime(Date closeDatetime) {
        this.closeDatetime = closeDatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoanOrder getLoanOrder() {
        return loanOrder;
    }

    public void setLoanOrder(LoanOrder loanOrder) {
        this.loanOrder = loanOrder;
    }

    public Order getMallOrder() {
        return mallOrder;
    }

    public void setMallOrder(Order mallOrder) {
        this.mallOrder = mallOrder;
    }

    public List<LoanOrder> getLoanOrderList() {
        return loanOrderList;
    }

    public void setLoanOrderList(List<LoanOrder> loanOrderList) {
        this.loanOrderList = loanOrderList;
    }

}
