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

    // 申请人姓名
    private String realName;

    // 申请人证件类型
    private String idKind;

    // 申请人证件号
    private String idNo;

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

    // 是否提前还款
    private String isEarlyRepayment;

    // 总期数
    private int periods;

    // 剩余期数
    private int restPeriods;

    // 银行利率(作废)
    private double bankRate;

    // 贷款时间起点
    private Date loanStartDatetime;

    // 贷款时间终点
    private Date loanEndDatetime;

    // 放款时间
    private Date bankFkDatetime;

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

    // 扣除的履约保证金(退款金额)
    private Long cutLyDeposit;

    // 节点
    private String curNodeCode;

    // 剩余欠款(剩余本金本息，利息已包含在本金中)
    private Long restAmount;

    // 未还清收总成本
    private Long restTotalCost;

    // 再次逾期保证金总额
    private Long overdueTotalDeposit;

    // 再次逾期保证金总收入
    private Long overdueTotalDepositIncome;

    // 额外保证金收入(作废)
    private Long totalInDeposit;

    // 逾期总金额
    private Long overdueAmount;

    // 累计逾期期数
    private int totalOverdueCount;

    // 实际逾期期数
    private int curOverdueCount;

    // 黑名单处理结果备案(商品分期)
    private String blackHandleNote;

    // 是否提前结清(0=正常结清 1=提前结清)
    private String isAdvanceSettled;

    // 结清证明
    private String settleAttach;

    // 结清时间
    private Date settleDatetime;

    // 解除抵押时间
    private Date releaseDatetime;

    // 最近修改人
    private String updater;

    // 最近修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ****** 辅助字段 ******

    // 预算单编号
    private String budgetOrderCode;

    // 用户信息
    private User user;

    // 统计未代偿总金额
    private String unRepayTotalAmount;

    // 角色编号
    private String roleCode;

    // 车贷订单
    private BudgetOrder budgetOrder;

    // 还款计划列表
    List<RepayPlan> repayPlanList;

    // 商品订单
    private Order mallOrder;

    // 实际退款金额
    private Long actualRefunds;

    // 借款余额
    private Long loanBalance;

    // 银行名称
    private String loanBankName;

    // 拖车时间
    private Date takeDatetime;

    // 银行放款日期
    private Date bankFkDatetimeStart;

    // 银行放款日期
    private Date bankFkDatetimeEnd;

    public Date getBankFkDatetimeStart() {
        return bankFkDatetimeStart;
    }

    public void setBankFkDatetimeStart(Date bankFkDatetimeStart) {
        this.bankFkDatetimeStart = bankFkDatetimeStart;
    }

    public Date getTakeDatetime() {
        return takeDatetime;
    }

    public void setTakeDatetime(Date takeDatetime) {
        this.takeDatetime = takeDatetime;
    }

    public Date getBankFkDatetimeEnd() {
        return bankFkDatetimeEnd;
    }

    public void setBankFkDatetimeEnd(Date bankFkDatetimeEnd) {
        this.bankFkDatetimeEnd = bankFkDatetimeEnd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Date getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankFkDatetime(Date bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getUnRepayTotalAmount() {
        return unRepayTotalAmount;
    }

    public void setUnRepayTotalAmount(String unRepayTotalAmount) {
        this.unRepayTotalAmount = unRepayTotalAmount;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getOverdueTotalDeposit() {
        return overdueTotalDeposit;
    }

    public void setOverdueTotalDeposit(Long overdueTotalDeposit) {
        this.overdueTotalDeposit = overdueTotalDeposit;
    }

    public Long getOverdueTotalDepositIncome() {
        return overdueTotalDepositIncome;
    }

    public void setOverdueTotalDepositIncome(Long overdueTotalDepositIncome) {
        this.overdueTotalDepositIncome = overdueTotalDepositIncome;
    }

    public String getIsAdvanceSettled() {
        return isAdvanceSettled;
    }

    public void setIsAdvanceSettled(String isAdvanceSettled) {
        this.isAdvanceSettled = isAdvanceSettled;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public Long getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Long loanBalance) {
        this.loanBalance = loanBalance;
    }

    public List<RepayPlan> getRepayPlanList() {
        return repayPlanList;
    }

    public void setRepayPlanList(List<RepayPlan> repayPlanList) {
        this.repayPlanList = repayPlanList;
    }

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

    public String getIsEarlyRepayment() {
        return isEarlyRepayment;
    }

    public void setIsEarlyRepayment(String isEarlyRepayment) {
        this.isEarlyRepayment = isEarlyRepayment;
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

    public String getSettleAttach() {
        return settleAttach;
    }

    public void setSettleAttach(String settleAttach) {
        this.settleAttach = settleAttach;
    }

    public Date getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(Date settleDatetime) {
        this.settleDatetime = settleDatetime;
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

    public BudgetOrder getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(BudgetOrder budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public Order getMallOrder() {
        return mallOrder;
    }

    public void setMallOrder(Order mallOrder) {
        this.mallOrder = mallOrder;
    }

    public Long getActualRefunds() {
        return actualRefunds;
    }

    public void setActualRefunds(Long actualRefunds) {
        this.actualRefunds = actualRefunds;
    }

    public Date getReleaseDatetime() {
        return releaseDatetime;
    }

    public void setReleaseDatetime(Date releaseDatetime) {
        this.releaseDatetime = releaseDatetime;
    }

}
