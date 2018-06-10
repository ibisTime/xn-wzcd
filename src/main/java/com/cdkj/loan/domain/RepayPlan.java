package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

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
    private Long repayInterest;

    // 已还金额
    private Long payedAmount;

    // 剩余欠款
    private long overplusAmount;

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

    // 实际代偿金额
    private Long realRepayAmount;

    // 拖车申请金额
    private Long tsCarAmount;

    // 拖车收款账号
    private String tsBankcardNumber;

    // 拖车开户行
    private String tsBankName;

    // 拖车开户支行
    private String tsSubbranch;

    // 拖车申请说明
    private String tcApplyNote;

    // 打款金额
    private Long remitAmount;

    // 打款水单
    private String remitBillPdf;

    // 收车地点
    private String takeCarAddress;

    // 拖车时间
    private Date takeDatetime;

    // 拖车人员
    private String takeName;

    // 拖车停放位置
    private String takeLocation;

    // 拖车说明
    private String takeNote;

    // 流水
    private String jourPdf;

    // 房产
    private String housePdf;

    // 担保人姓名
    private String guaName;

    // 担保人身份证号
    private String guaIdNo;

    // 担保人手机号
    private String guaMobile;

    // 担保人现居住地址
    private String guaNowAddress;

    // 担保赎回说明
    private String guaNote;

    // 建议(1=6个月保证金/2=已结清)
    private String suggest;

    // 建议说明
    private String suggestNote;

    // 团队买断扣除金额
    private Long buyOutAmount;

    // ****** 辅助字段 ******
    // 还款计划开始时间
    private Date repayStartDatetime;

    // 还款计划结束时间
    private Date repayEndDatetime;

    // 用户信息
    private User user;

    // 还款业务
    private RepayBiz repayBiz;

    // 费用清单
    private List<Cost> costList;

    // 催收记录
    private List<RemindLog> remindLogList;

    // 状态list
    private List<String> statusList;

    // 未结清贷款金额
    private Long unsettledLoan;

    // 本月还款金额
    private Long monthRepayAmount;

    // 还款卡号
    private String bankcardNumber;

    public Long getRealRepayAmount() {
        return realRepayAmount;
    }

    public void setRealRepayAmount(Long realRepayAmount) {
        this.realRepayAmount = realRepayAmount;
    }

    public Long getBuyOutAmount() {
        return buyOutAmount;
    }

    public void setBuyOutAmount(Long buyOutAmount) {
        this.buyOutAmount = buyOutAmount;
    }

    public Long getRemitAmount() {
        return remitAmount;
    }

    public void setRemitAmount(Long remitAmount) {
        this.remitAmount = remitAmount;
    }

    public String getRemitBillPdf() {
        return remitBillPdf;
    }

    public void setRemitBillPdf(String remitBillPdf) {
        this.remitBillPdf = remitBillPdf;
    }

    public String getTakeCarAddress() {
        return takeCarAddress;
    }

    public void setTakeCarAddress(String takeCarAddress) {
        this.takeCarAddress = takeCarAddress;
    }

    public Date getTakeDatetime() {
        return takeDatetime;
    }

    public void setTakeDatetime(Date takeDatetime) {
        this.takeDatetime = takeDatetime;
    }

    public String getTakeName() {
        return takeName;
    }

    public void setTakeName(String takeName) {
        this.takeName = takeName;
    }

    public String getTakeLocation() {
        return takeLocation;
    }

    public void setTakeLocation(String takeLocation) {
        this.takeLocation = takeLocation;
    }

    public String getTakeNote() {
        return takeNote;
    }

    public void setTakeNote(String takeNote) {
        this.takeNote = takeNote;
    }

    public String getJourPdf() {
        return jourPdf;
    }

    public void setJourPdf(String jourPdf) {
        this.jourPdf = jourPdf;
    }

    public String getHousePdf() {
        return housePdf;
    }

    public void setHousePdf(String housePdf) {
        this.housePdf = housePdf;
    }

    public String getGuaName() {
        return guaName;
    }

    public void setGuaName(String guaName) {
        this.guaName = guaName;
    }

    public String getGuaIdNo() {
        return guaIdNo;
    }

    public void setGuaIdNo(String guaIdNo) {
        this.guaIdNo = guaIdNo;
    }

    public String getGuaMobile() {
        return guaMobile;
    }

    public void setGuaMobile(String guaMobile) {
        this.guaMobile = guaMobile;
    }

    public String getGuaNowAddress() {
        return guaNowAddress;
    }

    public void setGuaNowAddress(String guaNowAddress) {
        this.guaNowAddress = guaNowAddress;
    }

    public String getGuaNote() {
        return guaNote;
    }

    public void setGuaNote(String guaNote) {
        this.guaNote = guaNote;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getSuggestNote() {
        return suggestNote;
    }

    public void setSuggestNote(String suggestNote) {
        this.suggestNote = suggestNote;
    }

    public String getTcApplyNote() {
        return tcApplyNote;
    }

    public void setTcApplyNote(String tcApplyNote) {
        this.tcApplyNote = tcApplyNote;
    }

    public Long getTsCarAmount() {
        return tsCarAmount;
    }

    public void setTsCarAmount(Long tsCarAmount) {
        this.tsCarAmount = tsCarAmount;
    }

    public String getTsBankcardNumber() {
        return tsBankcardNumber;
    }

    public void setTsBankcardNumber(String tsBankcardNumber) {
        this.tsBankcardNumber = tsBankcardNumber;
    }

    public String getTsBankName() {
        return tsBankName;
    }

    public void setTsBankName(String tsBankName) {
        this.tsBankName = tsBankName;
    }

    public String getTsSubbranch() {
        return tsSubbranch;
    }

    public void setTsSubbranch(String tsSubbranch) {
        this.tsSubbranch = tsSubbranch;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public Long getMonthRepayAmount() {
        return monthRepayAmount;
    }

    public void setMonthRepayAmount(Long monthRepayAmount) {
        this.monthRepayAmount = monthRepayAmount;
    }

    public Long getUnsettledLoan() {
        return unsettledLoan;
    }

    public void setUnsettledLoan(Long unsettledLoan) {
        this.unsettledLoan = unsettledLoan;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
    }

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

    public Date getRepayStartDatetime() {
        return repayStartDatetime;
    }

    public void setRepayStartDatetime(Date repayStartDatetime) {
        this.repayStartDatetime = repayStartDatetime;
    }

    public Date getRepayEndDatetime() {
        return repayEndDatetime;
    }

    public void setRepayEndDatetime(Date repayEndDatetime) {
        this.repayEndDatetime = repayEndDatetime;
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

    public Long getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(Long repayInterest) {
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

    public long getOverplusAmount() {
        return overplusAmount;
    }

    public void setOverplusAmount(long overplusAmount) {
        this.overplusAmount = overplusAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RepayBiz getRepayBiz() {
        return repayBiz;
    }

    public void setRepayBiz(RepayBiz repayBiz) {
        this.repayBiz = repayBiz;
    }

    public List<RemindLog> getRemindLogList() {
        return remindLogList;
    }

    public void setRemindLogList(List<RemindLog> remindLogList) {
        this.remindLogList = remindLogList;
    }

}
