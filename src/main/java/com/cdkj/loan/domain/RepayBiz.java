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

    // 关联编号(预算单编号)
    private String refCode;

    // 业务公司编号
    private String companyCode;

    // 业务总价(预算单的发票价格)
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

    // 放款时间
    private Date bankFkDatetime;

    // 风险保证金(准入单)
    private Long fxDeposit;

    // 首期还款日期
    private Date firstRepayDatetime;

    // 首期月供金额
    private Long firstRepayAmount;

    // 每期账单日
    private int billDatetime;

    // 每期还款日期
    private int monthDatetime;

    // 每期月供金额
    private Long monthAmount;

    // 履约保证金（准入单）
    private Long lyDeposit;

    // 扣除履约保证金（结清单申请）
    private Long cutLyDeposit;

    // 节点
    private String curNodeCode;

    // 剩余欠款(剩余本金本息，利息已包含在本金中)
    private Long restAmount;

    // 未还清收总成本
    private Long restTotalCost;

    // 再次逾期保证金总额(作废)
    private Long overdueTotalDeposit;

    // 再次逾期保证金总收入(作废)
    private Long overdueTotalDepositIncome;

    // 额外保证金收入(作废)
    private Long totalInDeposit;

    // 剩余逾期总金额
    private Long restOverdueAmount;

    // 累计逾期期数
    private int totalOverdueCount;

    // 现有逾期的次数
    private int curOverdueCount;

    // 现有代偿金额(黄名单)
    private Long restReplaceRepayAmount;

    // 累计代偿次数
    private int totalReplaceRepayCount;

    // 现在代偿次数
    private int curReplaceRepayCount;

    // 黑名单处理结果备案(商品分期)
    private String blackHandleNote;

    // 是否提前结清(0=正常结清 1=提前结清)
    private String isAdvanceSettled;

    // 结清证明
    private String settleAttach;

    // 结清时间
    private Date settleDatetime;

    // 付款银行(公司结清)
    private String paymentBank;

    // 付款凭证(公司结清)
    private String paymentPdf;

    // 处理结果
    private String dealResult;

    // 处理结果附件
    private String dealEnclosure;

    // 是否有押金单
    private String isDepositReceipt;

    // 押金单
    private String depositReceipt;

    // 押金单遗失证明
    private String depositReceiptLostProof;

    // 退款开户行
    private String refundBankSubbranch;

    // 退款户名
    private String refundBankRealName;

    // 退款账号
    private String refundBankcard;

    // 第二年按公司指定续保
    private String secondCompanyInsurance;

    // 第三年按公司指定续保
    private String thirdCompanyInsurance;

    // 解除抵押说明
    private String releaseApplyNote;

    // 解除抵押申请时间
    private Date releaseApplyDatetime;

    // 解除抵押时间
    private Date releaseDatetime;

    // 解除抵押回录说明
    private String releaseNote;

    // 解除抵押模板
    private String releaseTemplateId;

    // ********************司法诉讼打款回来的********************

    // 司法诉讼收款时间
    private Date judgeReceiptDatetime;

    // 司法诉讼收款金额
    private Long judgeReceiptAmount;

    // 司法诉讼收款银行编号
    private String judgeReceiptBankCode;

    // 司法诉讼收款银行账号
    private String judgeReceiptBankcard;

    // 司法诉讼备注
    private String judgeNote;

    // 司法诉讼收款凭证
    private String judgeBillPdf;

    // 是否恢复执行
    private String isImplementAgain;

    // ********************司法诉讼打款回来的********************

    // ********************结清打款回来的********************
    // 结清付款时间
    private Date settlePayDatetime;

    // 结清付款账号编号
    private String settleBankcard;

    // 结清打款凭证
    private String settlePdf;

    // 结清说明
    private String settleNote;

    // ********************结清打款回来的********************

    // 最近修改人
    private String updater;

    // 最近修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 团队编号
    private String teamCode;

    // 是否在物流传递中
    private String isLogistics;

    // 最终收款人
    private String finalPayee;

    // 附件
    private String payeeEnclosure;

    // ****** 辅助字段 ******
    // 预算单编号
    private String budgetOrderCode;

    // 用户信息
    private User user;

    // 角色编号
    private String roleCode;

    // 车贷订单
    private BudgetOrder budgetOrder;

    // 当月还款计划
    RepayPlan curMonthRepayPlan;

    // 还款计划列表
    List<RepayPlan> repayPlanList;

    // 商品订单
    private Order mallOrder;

    // 银行放款日期起
    private Date bankFkDatetimeStart;

    // 银行放款日期止
    private Date bankFkDatetimeEnd;

    private String keyWord;// 关键字

    private RepayPlan overdueRepayPlan;

    private List<String> curNodeCodeList;// 节点编号列表

    // 司法诉讼
    private Judge judge;

    // 更新人姓名
    private String updaterName;

    // 贷款银行名称
    private String loanBankName;

    // 还款卡号
    private String bankcardNumber;

    // 最新的收车时间
    private Date newestTakeDatetime;

    private int curOverdueCountStart; // 现有逾期的次数起

    private int curOverdueCountEnd; // 现有逾期的次数止

    private List<String> curOverdueCountList; // 现有逾期的次数列表

    // 业务公司名称
    private String companyName;

    // 实际退款金额(还款计划保证金相加)
    private Long actualRefunds;

    public Long getActualRefunds() {
        return actualRefunds;
    }

    public void setActualRefunds(Long actualRefunds) {
        this.actualRefunds = actualRefunds;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getIsImplementAgain() {
        return isImplementAgain;
    }

    public void setIsImplementAgain(String isImplementAgain) {
        this.isImplementAgain = isImplementAgain;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIsDepositReceipt() {
        return isDepositReceipt;
    }

    public void setIsDepositReceipt(String isDepositReceipt) {
        this.isDepositReceipt = isDepositReceipt;
    }

    public String getDepositReceiptLostProof() {
        return depositReceiptLostProof;
    }

    public void setDepositReceiptLostProof(String depositReceiptLostProof) {
        this.depositReceiptLostProof = depositReceiptLostProof;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getPaymentBank() {
        return paymentBank;
    }

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }

    public String getPaymentPdf() {
        return paymentPdf;
    }

    public void setPaymentPdf(String paymentPdf) {
        this.paymentPdf = paymentPdf;
    }

    public List<String> getCurOverdueCountList() {
        return curOverdueCountList;
    }

    public void setCurOverdueCountList(List<String> curOverdueCountList) {
        this.curOverdueCountList = curOverdueCountList;
    }

    public String getFinalPayee() {
        return finalPayee;
    }

    public void setFinalPayee(String finalPayee) {
        this.finalPayee = finalPayee;
    }

    public String getPayeeEnclosure() {
        return payeeEnclosure;
    }

    public void setPayeeEnclosure(String payeeEnclosure) {
        this.payeeEnclosure = payeeEnclosure;
    }

    public int getCurOverdueCountStart() {
        return curOverdueCountStart;
    }

    public void setCurOverdueCountStart(int curOverdueCountStart) {
        this.curOverdueCountStart = curOverdueCountStart;
    }

    public int getCurOverdueCountEnd() {
        return curOverdueCountEnd;
    }

    public void setCurOverdueCountEnd(int curOverdueCountEnd) {
        this.curOverdueCountEnd = curOverdueCountEnd;
    }

    public Date getNewestTakeDatetime() {
        return newestTakeDatetime;
    }

    public void setNewestTakeDatetime(Date newestTakeDatetime) {
        this.newestTakeDatetime = newestTakeDatetime;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getReleaseTemplateId() {
        return releaseTemplateId;
    }

    public void setReleaseTemplateId(String releaseTemplateId) {
        this.releaseTemplateId = releaseTemplateId;
    }

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
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

    public String getJudgeReceiptBankCode() {
        return judgeReceiptBankCode;
    }

    public void setJudgeReceiptBankCode(String judgeReceiptBankCode) {
        this.judgeReceiptBankCode = judgeReceiptBankCode;
    }

    public String getDealEnclosure() {
        return dealEnclosure;
    }

    public void setDealEnclosure(String dealEnclosure) {
        this.dealEnclosure = dealEnclosure;
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

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public Date getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankFkDatetime(Date bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
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

    public int getBillDatetime() {
        return billDatetime;
    }

    public void setBillDatetime(int billDatetime) {
        this.billDatetime = billDatetime;
    }

    public Date getReleaseApplyDatetime() {
        return releaseApplyDatetime;
    }

    public void setReleaseApplyDatetime(Date releaseApplyDatetime) {
        this.releaseApplyDatetime = releaseApplyDatetime;
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

    public String getIsLogistics() {
        return isLogistics;
    }

    public void setIsLogistics(String isLogistics) {
        this.isLogistics = isLogistics;
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

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
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

    public Long getTotalInDeposit() {
        return totalInDeposit;
    }

    public void setTotalInDeposit(Long totalInDeposit) {
        this.totalInDeposit = totalInDeposit;
    }

    public Long getRestOverdueAmount() {
        return restOverdueAmount;
    }

    public void setRestOverdueAmount(Long restOverdueAmount) {
        this.restOverdueAmount = restOverdueAmount;
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

    public Long getRestReplaceRepayAmount() {
        return restReplaceRepayAmount;
    }

    public void setRestReplaceRepayAmount(Long restReplaceRepayAmount) {
        this.restReplaceRepayAmount = restReplaceRepayAmount;
    }

    public int getTotalReplaceRepayCount() {
        return totalReplaceRepayCount;
    }

    public void setTotalReplaceRepayCount(int totalReplaceRepayCount) {
        this.totalReplaceRepayCount = totalReplaceRepayCount;
    }

    public int getCurReplaceRepayCount() {
        return curReplaceRepayCount;
    }

    public void setCurReplaceRepayCount(int curReplaceRepayCount) {
        this.curReplaceRepayCount = curReplaceRepayCount;
    }

    public String getBlackHandleNote() {
        return blackHandleNote;
    }

    public void setBlackHandleNote(String blackHandleNote) {
        this.blackHandleNote = blackHandleNote;
    }

    public Date getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(Date settleDatetime) {
        this.settleDatetime = settleDatetime;
    }

    public String getIsAdvanceSettled() {
        return isAdvanceSettled;
    }

    public void setIsAdvanceSettled(String isAdvanceSettled) {
        this.isAdvanceSettled = isAdvanceSettled;
    }

    public String getSettleAttach() {
        return settleAttach;
    }

    public void setSettleAttach(String settleAttach) {
        this.settleAttach = settleAttach;
    }

    public String getDepositReceipt() {
        return depositReceipt;
    }

    public void setDepositReceipt(String depositReceipt) {
        this.depositReceipt = depositReceipt;
    }

    public String getRefundBankSubbranch() {
        return refundBankSubbranch;
    }

    public void setRefundBankSubbranch(String refundBankSubbranch) {
        this.refundBankSubbranch = refundBankSubbranch;
    }

    public String getRefundBankRealName() {
        return refundBankRealName;
    }

    public void setRefundBankRealName(String refundBankRealName) {
        this.refundBankRealName = refundBankRealName;
    }

    public String getRefundBankcard() {
        return refundBankcard;
    }

    public void setRefundBankcard(String refundBankcard) {
        this.refundBankcard = refundBankcard;
    }

    public String getSecondCompanyInsurance() {
        return secondCompanyInsurance;
    }

    public void setSecondCompanyInsurance(String secondCompanyInsurance) {
        this.secondCompanyInsurance = secondCompanyInsurance;
    }

    public String getThirdCompanyInsurance() {
        return thirdCompanyInsurance;
    }

    public void setThirdCompanyInsurance(String thirdCompanyInsurance) {
        this.thirdCompanyInsurance = thirdCompanyInsurance;
    }

    public String getReleaseApplyNote() {
        return releaseApplyNote;
    }

    public void setReleaseApplyNote(String releaseApplyNote) {
        this.releaseApplyNote = releaseApplyNote;
    }

    public Date getReleaseDatetime() {
        return releaseDatetime;
    }

    public void setReleaseDatetime(Date releaseDatetime) {
        this.releaseDatetime = releaseDatetime;
    }

    public String getReleaseNote() {
        return releaseNote;
    }

    public void setReleaseNote(String releaseNote) {
        this.releaseNote = releaseNote;
    }

    public Date getJudgeReceiptDatetime() {
        return judgeReceiptDatetime;
    }

    public void setJudgeReceiptDatetime(Date judgeReceiptDatetime) {
        this.judgeReceiptDatetime = judgeReceiptDatetime;
    }

    public Long getJudgeReceiptAmount() {
        return judgeReceiptAmount;
    }

    public void setJudgeReceiptAmount(Long judgeReceiptAmount) {
        this.judgeReceiptAmount = judgeReceiptAmount;
    }

    public String getJudgeReceiptBankcard() {
        return judgeReceiptBankcard;
    }

    public void setJudgeReceiptBankcard(String judgeReceiptBankcard) {
        this.judgeReceiptBankcard = judgeReceiptBankcard;
    }

    public String getJudgeNote() {
        return judgeNote;
    }

    public void setJudgeNote(String judgeNote) {
        this.judgeNote = judgeNote;
    }

    public String getJudgeBillPdf() {
        return judgeBillPdf;
    }

    public void setJudgeBillPdf(String judgeBillPdf) {
        this.judgeBillPdf = judgeBillPdf;
    }

    public Date getSettlePayDatetime() {
        return settlePayDatetime;
    }

    public void setSettlePayDatetime(Date settlePayDatetime) {
        this.settlePayDatetime = settlePayDatetime;
    }

    public String getSettleBankcard() {
        return settleBankcard;
    }

    public void setSettleBankcard(String settleBankcard) {
        this.settleBankcard = settleBankcard;
    }

    public String getSettlePdf() {
        return settlePdf;
    }

    public void setSettlePdf(String settlePdf) {
        this.settlePdf = settlePdf;
    }

    public String getSettleNote() {
        return settleNote;
    }

    public void setSettleNote(String settleNote) {
        this.settleNote = settleNote;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public BudgetOrder getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(BudgetOrder budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public RepayPlan getCurMonthRepayPlan() {
        return curMonthRepayPlan;
    }

    public void setCurMonthRepayPlan(RepayPlan curMonthRepayPlan) {
        this.curMonthRepayPlan = curMonthRepayPlan;
    }

    public List<RepayPlan> getRepayPlanList() {
        return repayPlanList;
    }

    public void setRepayPlanList(List<RepayPlan> repayPlanList) {
        this.repayPlanList = repayPlanList;
    }

    public Order getMallOrder() {
        return mallOrder;
    }

    public void setMallOrder(Order mallOrder) {
        this.mallOrder = mallOrder;
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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public RepayPlan getOverdueRepayPlan() {
        return overdueRepayPlan;
    }

    public void setOverdueRepayPlan(RepayPlan overdueRepayPlan) {
        this.overdueRepayPlan = overdueRepayPlan;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

}
